package com.example.tomticketapi1.structure.domain.usecases.upload_cases;

import com.example.tomticketapi1.structure.domain.repositories.ChamadosRepository;
import com.example.tomticketapi1.structure.domain.services.ChamadosServices;
import com.example.tomticketapi1.structure.domain.usecases.usecases_configs.UseCasesConfigsBase;
import com.example.tomticketapi1.structure.dto.entitiesDTO.chamadosDTO.ChamadosDTO;
import com.example.tomticketapi1.structure.dto.entitiesDTO.formatsDTO.UploadsResponseDTO;
import com.example.tomticketapi1.structure.logs.logservices.WriteInTxtLoggerDocument;
import org.springframework.stereotype.Component;

/**
 * A classe UploadFirstPageOfChamadosUseCase é um caso de uso responsável por
 * realizar o upload da primeira página de chamados obtidos de uma API.
 */
@Component
public class UploadFirstPageOfChamadosUseCase extends UseCasesConfigsBase {

    /**
     * Construtor da classe UploadFirstPageOfChamadosUseCase.
     *
     * @param chamadosRepository O repositório utilizado para interagir com os dados dos chamados.
     * @param chamadosServices O serviço responsável por gerenciar operações relacionadas aos chamados.
     * @param loggDocument O serviço de log utilizado para registrar as operações realizadas.
     */
    public UploadFirstPageOfChamadosUseCase(ChamadosRepository chamadosRepository, ChamadosServices chamadosServices, WriteInTxtLoggerDocument loggDocument) {
        super(chamadosRepository, chamadosServices, loggDocument);
    }

    /**
     * Executa o upload da primeira página de chamados.
     *
     * @return Um objeto UploadsResponseDTO contendo o resultado da operação de upload.
     */
    public UploadsResponseDTO run() {
        loggDocument.logMessage("[METHOD CALLED] : uploadFirstPage() called.");

        // Verificação do retorno da API
        ChamadosDTO chamadosDTOResponseFromService = chamadosServices.getChamadosAPIFirstPage();
        if (chamadosDTOResponseFromService == null || chamadosDTOResponseFromService.getData() == null) {
            String logNullMessage = "[ERROR] : uploadFirstPage() failed. No data returned.";
            loggDocument.logMessage(logNullMessage);
            logger.warn(logNullMessage);
            return createUploadResponse(false, logNullMessage);
        }

        // Sucesso no upload
        chamadosRepository.upload(chamadosDTOResponseFromService);
        String logSucessMessage = "[SUCCESS] : uploadFirstPage() processed successfully.";
        loggDocument.logMessage(logSucessMessage);
        logger.info(logSucessMessage);
        return createUploadResponse(true, "Upload completed successfully");
    }
}
