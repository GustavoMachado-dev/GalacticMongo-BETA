package com.example.tomticketapi1.structure.domain.entities.formats;

import lombok.Getter;
import lombok.Setter;

/**
 * A classe UploadsResponse representa a resposta de uma operação de upload.
 * Esta classe contém informações sobre o sucesso da operação, uma mensagem
 * descritiva e o número de chamados adicionados.
 */
@Getter
@Setter
public class UploadsResponse {

    /**
     * Indica se a operação de upload foi bem-sucedida.
     */
    private boolean success;

    /**
     * Mensagem descritiva relacionada ao resultado da operação.
     */
    private String message;

    /**
     * Número de chamados adicionados durante a operação de upload.
     */
    private int addChamados;

    /**
     * Construtor padrão da classe UploadsResponse.
     */
    public UploadsResponse() {}
}