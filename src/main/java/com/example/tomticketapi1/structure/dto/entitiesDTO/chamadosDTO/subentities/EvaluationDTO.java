package com.example.tomticketapi1.structure.dto.entitiesDTO.chamadosDTO.subentities;

import lombok.Getter;
import lombok.Setter;

/**
 * A classe EvaluationDTO representa uma avaliação de um chamado no sistema.
 * Ela contém informações sobre se o problema foi resolvido, a nota dada e comentários adicionais.
 */
@Getter
@Setter
public class EvaluationDTO {

    /** Indica se o problema foi resolvido. */
    private boolean problem_solved;

    /** A nota dada à solução do problema (de 1 a 5, por exemplo). */
    private int grade;

    /** Comentários adicionais sobre a avaliação. */
    private String comment;
}