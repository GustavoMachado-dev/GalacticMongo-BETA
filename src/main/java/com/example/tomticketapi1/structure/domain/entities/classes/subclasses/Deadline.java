package com.example.tomticketapi1.structure.domain.entities.classes.subclasses;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe que representa um prazo relacionado a um chamado ou tarefa.
 * Esta classe contém informações sobre a data do prazo e se o prazo
 * foi cumprido ou não.
 */
@Getter
@Setter
public class Deadline {

    /**
     * Data do prazo a ser cumprido.
     */
    private String date;

    /**
     * Indica se o prazo foi cumprido.
     */
    private boolean accomplished;
}