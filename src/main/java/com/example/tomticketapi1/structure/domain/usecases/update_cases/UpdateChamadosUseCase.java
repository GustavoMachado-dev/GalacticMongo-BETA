package com.example.tomticketapi1.structure.domain.usecases.update_cases;

import com.example.tomticketapi1.structure.domain.repositories.ChamadosRepository;
import com.example.tomticketapi1.structure.domain.services.ChamadosServices;
import com.example.tomticketapi1.structure.domain.usecases.usecases_configs.UseCasesConfigsBase;
import com.example.tomticketapi1.structure.dto.entitiesDTO.chamadosDTO.ChamadosDTO;
import com.example.tomticketapi1.structure.dto.entitiesDTO.formatsDTO.UploadsResponseDTO;
import com.example.tomticketapi1.structure.logs.logservices.WriteInTxtLoggerDocument;
import org.springframework.stereotype.Component;

/**
 * A classe UpdateChamadosUseCase é um caso de uso responsável por
 * atualizar os chamados. Ela utiliza os serviços e repositórios necessários
 * para obter e atualizar os dados dos chamados.
 */
@Component
public class UpdateChamadosUseCase extends UseCasesConfigsBase {

    /**
     * Construtor da classe UpdateChamadosUseCase.
     *
     * @param chamadosRepository O repositório utilizado para interagir com os dados dos chamados.
     * @param chamadosServices O serviço responsável por gerenciar operações relacionadas aos chamados.
     * @param loggDocument O serviço de log utilizado para registrar as operações realizadas.
     */
    public UpdateChamadosUseCase(ChamadosRepository chamadosRepository, ChamadosServices chamadosServices, WriteInTxtLoggerDocument loggDocument) {
        super(chamadosRepository, chamadosServices, loggDocument);
    }

    /**
     * Executa a atualização dos chamados.
     *
     * @return Um objeto UploadsResponseDTO contendo o resultado da operação de atualização.
     */
    public UploadsResponseDTO run() {
        loggDocument.logMessage("[METHOD CALLED] : updateChamados() called.");

        ChamadosDTO chamadosDTOResponseFromService = chamadosServices.updateChamados();
        chamadosRepository.update(chamadosDTOResponseFromService);

        String logSucessMessage = "[SUCCESS] : updateChamados() completed successfully.";
        loggDocument.logMessage(logSucessMessage);
        logger.info(logSucessMessage);
        return createUploadResponse(true, "Update completed successfully");
    }
}