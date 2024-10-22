package com.example.tomticketapi1.structure.domain.usecases.upload_cases;

import com.example.tomticketapi1.structure.domain.repositories.ChamadosRepository;
import com.example.tomticketapi1.structure.domain.services.ChamadosServices;
import com.example.tomticketapi1.structure.domain.usecases.usecases_configs.UseCasesConfigsBase;
import com.example.tomticketapi1.structure.dto.entitiesDTO.chamadosDTO.ChamadosDTO;
import com.example.tomticketapi1.structure.dto.entitiesDTO.formatsDTO.UploadsResponseDTO;
import com.example.tomticketapi1.structure.logs.logservices.WriteInTxtLoggerDocument;
import org.springframework.stereotype.Component;

/**
 * A classe UploadLastTwoYearsUseCase é um caso de uso responsável por
 * realizar o upload dos chamados dos últimos dois anos obtidos de uma API.
 */
@Component
public class UploadLastTwoYearsUseCase extends UseCasesConfigsBase {

    /**
     * Construtor da classe UploadLastTwoYearsUseCase.
     *
     * @param chamadosRepository O repositório utilizado para interagir com os dados dos chamados.
     * @param chamadosServices O serviço responsável por gerenciar operações relacionadas aos chamados.
     * @param loggDocument O serviço de log utilizado para registrar as operações realizadas.
     */
    public UploadLastTwoYearsUseCase(ChamadosRepository chamadosRepository, ChamadosServices chamadosServices, WriteInTxtLoggerDocument loggDocument) {
        super(chamadosRepository, chamadosServices, loggDocument);
    }

    /**
     * Executa o upload dos chamados dos últimos dois anos.
     *
     * @return Um objeto UploadsResponseDTO contendo o resultado da operação de upload.
     */
    public UploadsResponseDTO run() {
        loggDocument.logMessage("[METHOD CALLED] : uploadLastTwoYears() called.");

        ChamadosDTO chamadosDTOResponseFromService = chamadosServices.getChamadosByData();
        chamadosRepository.upload(chamadosDTOResponseFromService);

        String logSuccessMessage = "[SUCCESS] : uploadLastTwoYears() processed successfully.";
        loggDocument.logMessage(logSuccessMessage);
        logger.info(logSuccessMessage);

        return createUploadResponse(true, "Upload completed successfully");
    }
}