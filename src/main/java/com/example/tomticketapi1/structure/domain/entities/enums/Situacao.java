package com.example.tomticketapi1.structure.domain.entities.enums;

/**
 * A enumeração Situacao representa os diferentes estados que um item
 * ou chamado pode ter no sistema.
 */
@SuppressWarnings("unused")
public enum Situacao {

    /**
     * Representa a situação em que o chamado foi aceito pelo atendente.
     */
    ACEITO_PELO_ATENDENTE,

    /**
     * Representa a situação em que o chamado foi respondido pelo atendente.
     */
    RESPONDIDO_PELO_ATENDENTE,

    /**
     * Representa a situação em que o chamado foi respondido pelo cliente.
     */
    RESPONDIDO_PELO_CLIENTE,

    /**
     * Representa a situação em que o chamado foi cancelado.
     */
    CANCELADO,

    /**
     * Representa a situação em que o chamado foi finalizado.
     */
    FINALIZADO,

    /**
     * Representa a situação em que ocorreu uma troca de atendente.
     */
    TROCA_DE_ATENDENTE,

    /**
     * Representa a situação em que o chamado foi enviado ao suporte.
     */
    ENVIADO_AO_SUPORTE
}