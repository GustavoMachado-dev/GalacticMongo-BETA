package com.example.tomticketapi1.structure.dto.entitiesDTO.classesDTO.subclasses;

import lombok.Getter;
import lombok.Setter;

/**
 * A classe DeadlineDTO representa um prazo associado a uma tarefa ou chamado.
 * Ela contém informações sobre a data do prazo e se foi ou não cumprido.
 */
@Getter
@Setter
public class DeadlineDTO {

    /** A data do prazo em formato de string. */
    private String date;

    /** Indica se o prazo foi cumprido. */
    private boolean accomplished;
}