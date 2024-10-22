package com.example.tomticketapi1.structure.dto.entitiesDTO.enumsDTO;

/**
 * A enumeração SituacaoDTO representa os diferentes status de um chamado.
 * Cada constante indica uma fase ou condição do chamado durante o seu processamento.
 */
@SuppressWarnings("unused")
public enum SituacaoDTO {
    ACEITO_PELO_ATENDENTE,   // O chamado foi aceito pelo atendente
    RESPONDIDO_PELO_ATENDENTE, // O atendente respondeu ao chamado
    RESPONDIDO_PELO_CLIENTE, // O cliente respondeu ao chamado
    CANCELADO,                // O chamado foi cancelado
    FINALIZADO,               // O chamado foi finalizado
    TROCA_DE_ATENDENTE,       // Houve uma troca de atendente no chamado
    ENVIADO_AO_SUPORTE       // O chamado foi enviado ao suporte
}