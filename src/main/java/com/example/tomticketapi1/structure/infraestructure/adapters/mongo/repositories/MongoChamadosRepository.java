package com.example.tomticketapi1.structure.infraestructure.adapters.mongo.repositories;

import com.example.tomticketapi1.structure.domain.entities.formats.UploadsResponse;
import com.example.tomticketapi1.structure.domain.repositories.ChamadosRepository;
import com.example.tomticketapi1.structure.dto.entitiesDTO.chamadosDTO.ChamadoDTO;
import com.example.tomticketapi1.structure.dto.entitiesDTO.chamadosDTO.ChamadosDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * A classe MongoChamadosRepository implementa a interface ChamadosRepository
 * e fornece métodos para interagir com a coleção "chamados-payer" no MongoDB.
 */
@Repository
public class MongoChamadosRepository implements ChamadosRepository {

    private static final Logger logger = LoggerFactory.getLogger(MongoChamadosRepository.class);
    private final MongoTemplate mongoTemplate;

    /**
     * Construtor que recebe o MongoTemplate para interações com o banco de dados.
     *
     * @param mongoTemplate o objeto MongoTemplate usado para operações de banco de dados.
     */
    @Autowired
    public MongoChamadosRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * Faz o upload dos chamados para o MongoDB.
     * Este método salva individualmente os chamados recebidos no objeto {@link ChamadosDTO} na coleção "chamados-payer".
     *
     * @param chamadosDTOResponse o objeto {@link ChamadosDTO} contendo os dados a serem salvos.
     */
    @Override
    public void upload(ChamadosDTO chamadosDTOResponse) {
        if (chamadosDTOResponse != null && chamadosDTOResponse.getData() != null) {
            for (ChamadoDTO chamadoDTO : chamadosDTOResponse.getData()) {
                mongoTemplate.save(chamadoDTO, "<your_collection>");
            }
        }
    }

    /**
     * Atualiza os chamados existentes ou adiciona novos no MongoDB.
     * Este método verifica se os chamados recebidos no objeto {@link ChamadosDTO} já existem na coleção "chamados-payer".
     * Se existir, ele atualiza as informações; caso contrário, adiciona um novo documento.
     *
     * @param chamadosDTOResponse o objeto {@link ChamadosDTO} contendo os dados a serem processados.
     */
    @Override
    public void update(ChamadosDTO chamadosDTOResponse) {
        try {
            if (chamadosDTOResponse != null && chamadosDTOResponse.getData() != null) {
                for (ChamadoDTO chamadoDTO : chamadosDTOResponse.getData()) {
                    ChamadoDTO existingChamado = mongoTemplate.findById(chamadoDTO.getId(), ChamadoDTO.class, "<your_collection>");
                    if (existingChamado != null) {
                        // Compare the apply dates to check if an update is needed
                        if (!existingChamado.getSituation().getApply_date().equals(chamadoDTO.getSituation().getApply_date())
                                || !existingChamado.getSituation().getDescription().equals(chamadoDTO.getSituation().getDescription())) {
                            existingChamado.setSituation(chamadoDTO.getSituation());
                            mongoTemplate.save(existingChamado, "<your_collection>");
                        }
                    } else {
                        // If the chamado doesn't exist, add it as a new one
                        mongoTemplate.save(chamadoDTO, "<your_collection>");
                    }
                }
            } else {
                String warnMessage = "Nenhum dado encontrado no objeto.";
                logger.warn(warnMessage);
            }
        } catch (Exception e) {
            String errorMessage = "Failed to update chamados. Verify Log";
            logger.error(errorMessage, e);
        }
    }

    /**
     * Encontra um chamado pelo ID no MongoDB.
     * Este método busca um chamado na coleção de {@link ChamadosDTO} com base no ID fornecido.
     *
     * @param id o ID do chamado a ser buscado.
     * @return um {@link Optional} contendo o {@link ChamadosDTO} se encontrado, ou vazio se não encontrado.
     */
    @Override
    public Optional<ChamadosDTO> findById(String id) {
        return Optional.ofNullable(mongoTemplate.findById(id, ChamadosDTO.class));
    }

    /**
     * Deleta um chamado pelo ID no MongoDB.
     * Este método remove o chamado da coleção "chamados-payer" com base no ID fornecido.
     *
     * @param id o ID do chamado a ser deletado.
     * @return um objeto {@link UploadsResponse} informando o resultado da operação.
     */
    @Override
    public UploadsResponse deleteById(String id) {
        UploadsResponse uploadsResponse = new UploadsResponse();
        ChamadosDTO chamados = mongoTemplate.findById(id, ChamadosDTO.class);

        if (chamados != null) {
            mongoTemplate.remove(chamados, "<your_collection>");
            uploadsResponse.setSuccess(true);
            uploadsResponse.setMessage("Successfully deleted");
            return uploadsResponse;
        }

        uploadsResponse.setSuccess(false);
        uploadsResponse.setMessage("Failed to delete");
        return uploadsResponse;
    }

    /**
     * Verifica se um chamado existe pelo ID no MongoDB.
     * Este método retorna um booleano indicando a existência de um chamado com o ID fornecido.
     *
     * @param id o ID do chamado a ser verificado.
     * @return true se o chamado existir, false caso contrário.
     */
    @Override
    public boolean existsById(String id) {
        return mongoTemplate.exists(query(where("_id").is(id)), ChamadosDTO.class);
    }

    /**
     * Salva um chamado no MongoDB.
     * Este método armazena o chamado fornecido na coleção "chamados-payer".
     *
     * @param chamado o objeto {@link ChamadoDTO} a ser salvo.
     */
    @Override
    public void save(ChamadoDTO chamado) {
        mongoTemplate.save(chamado, "<your_collection>");
    }
}