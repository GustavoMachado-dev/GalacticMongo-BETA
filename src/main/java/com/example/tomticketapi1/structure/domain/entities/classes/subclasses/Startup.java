package com.example.tomticketapi1.structure.domain.entities.classes.subclasses;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe que representa o início de um chamado ou tarefa.
 * Esta classe contém informações sobre a data de início e se o início
 * foi realizado ou não.
 */
@Getter
@Setter
public class Startup {

    /**
     * Data em que o chamado ou tarefa foi iniciado.
     */
    private String date;

    /**
     * Indica se o início foi realizado.
     */
    private boolean accomplished;
}