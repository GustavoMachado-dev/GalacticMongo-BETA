package com.example.tomticketapi1.structure.dto.entitiesDTO.formatsDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * A classe UploadsResponseDTO representa a resposta de uma operação de upload.
 */
@Setter
@Getter
public class UploadsResponseDTO {
    private boolean success; // Indica se a operação foi bem-sucedida
    private String message; // Mensagem associada à operação

    /**
     * Construtor padrão que inicializa um UploadsResponseDTO vazio.
     */
    public UploadsResponseDTO() {}
}