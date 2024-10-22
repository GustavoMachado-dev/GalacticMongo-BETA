package com.example.tomticketapi1.structure.domain.entities.chamados.subentities;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe que representa uma avaliação de um chamado ou serviço.
 *
 * Esta classe contém informações sobre a solução do problema,
 * a nota dada pelo cliente e um comentário adicional.
 */
@Getter
@Setter
public class Evaluation {

    /**
     * Indica se o problema foi solucionado.
     */
    private boolean problem_solved;

    /**
     * Nota atribuída ao serviço, em uma escala de 1 a 10.
     */
    private int grade;

    /**
     * Comentário adicional do cliente sobre a avaliação.
     */
    private String comment;
}
