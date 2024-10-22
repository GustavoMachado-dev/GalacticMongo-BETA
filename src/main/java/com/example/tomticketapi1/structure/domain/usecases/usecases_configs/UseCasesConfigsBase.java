package com.example.tomticketapi1.structure.domain.usecases.usecases_configs;

import com.example.tomticketapi1.structure.domain.repositories.ChamadosRepository;
import com.example.tomticketapi1.structure.domain.services.ChamadosServices;
import com.example.tomticketapi1.structure.dto.entitiesDTO.formatsDTO.UploadsResponseDTO;
import com.example.tomticketapi1.structure.logs.logservices.WriteInTxtLoggerDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A classe abstrata UseCasesConfigsBase serve como base para os casos de uso relacionados ao sistema de chamados.
 * Ela fornece acesso ao repositório de chamados, serviços de chamados e um logger para registrar atividades.
 */
public abstract class UseCasesConfigsBase {
    protected final ChamadosRepository chamadosRepository;
    protected final ChamadosServices chamadosServices;
    protected final WriteInTxtLoggerDocument loggDocument;

    // Modificador de acesso alterado para protected para permitir acesso nas classes filhas
    protected static final Logger logger = LoggerFactory.getLogger(UseCasesConfigsBase.class);

    /**
     * Construtor da classe UseCasesConfigsBase.
     *
     * @param chamadosRepository O repositório de chamados, utilizado para operações de persistência.
     * @param chamadosServices O serviço de chamados, utilizado para interações com a API e lógica de negócios.
     * @param loggDocument O logger utilizado para registrar eventos e informações.
     */
    public UseCasesConfigsBase(ChamadosRepository chamadosRepository, ChamadosServices chamadosServices, WriteInTxtLoggerDocument loggDocument) {
        this.chamadosRepository = chamadosRepository;
        this.chamadosServices = chamadosServices;
        this.loggDocument = loggDocument;
    }

    /**
     * Cria uma resposta de upload com o resultado da operação.
     *
     * @param success Indica se a operação foi bem-sucedida ou não.
     * @param message Mensagem adicional sobre o resultado da operação.
     * @return Um objeto UploadsResponseDTO contendo o status e a mensagem.
     */
    protected UploadsResponseDTO createUploadResponse(boolean success, String message) {
        loggDocument.logMessage("[METHOD CALLED] : createUploadResponse() with status: " + (success ? "SUCCESS" : "FAILURE") + ".");

        UploadsResponseDTO uploadsResponse = new UploadsResponseDTO();
        uploadsResponse.setSuccess(success);
        uploadsResponse.setMessage(message);
        return uploadsResponse;
    }
}