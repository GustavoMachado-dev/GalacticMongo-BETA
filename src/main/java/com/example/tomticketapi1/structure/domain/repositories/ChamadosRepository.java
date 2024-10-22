package com.example.tomticketapi1.structure.domain.repositories;

import com.example.tomticketapi1.structure.domain.entities.formats.UploadsResponse;
import com.example.tomticketapi1.structure.dto.entitiesDTO.chamadosDTO.ChamadoDTO;
import com.example.tomticketapi1.structure.dto.entitiesDTO.chamadosDTO.ChamadosDTO;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * A interface ChamadosRepository define as operações de persistência
 * para gerenciar chamados no sistema. Esta interface utiliza
 * a abordagem Spring Data para abstrair a lógica de acesso a dados.
 */
@SuppressWarnings("unused")
@Repository
public interface ChamadosRepository {

    /**
     * Realiza o upload de um conjunto de chamados.
     *
     * @param chamadosDTO Objeto contendo os dados dos chamados a serem
     *                    enviados para o sistema.
     */
    void upload(ChamadosDTO chamadosDTO);

    /**
     * Atualiza um conjunto de chamados existentes no sistema.
     *
     * @param chamadosDTO Objeto contendo os dados atualizados dos chamados.
     */
    void update(ChamadosDTO chamadosDTO);

    /**
     * Busca um chamado pelo seu identificador único.
     *
     * @param id Identificador único do chamado.
     * @return Um objeto Optional contendo o ChamadosDTO correspondente,
     *         ou vazio se o chamado não for encontrado.
     */
    Optional<ChamadosDTO> findById(String id);

    /**
     * Exclui um chamado pelo seu identificador único.
     *
     * @param id Identificador único do chamado a ser excluído.
     * @return Um objeto UploadsResponse contendo o resultado da operação
     *         de exclusão.
     */
    UploadsResponse deleteById(String id);

    /**
     * Verifica se um chamado existe com base no seu identificador único.
     *
     * @param id Identificador único do chamado.
     * @return true se o chamado existir, false caso contrário.
     */
    boolean existsById(String id);

    /**
     * Salva um novo chamado no sistema.
     *
     * @param chamado Objeto contendo os dados do chamado a serem salvos.
     */
    void save(ChamadoDTO chamado);
}