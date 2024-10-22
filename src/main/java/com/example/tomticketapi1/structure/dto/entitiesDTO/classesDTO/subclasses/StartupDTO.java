package com.example.tomticketapi1.structure.dto.entitiesDTO.classesDTO.subclasses;

import lombok.Getter;
import lombok.Setter;

/**
 * A classe StartupDTO representa o início associado a uma tarefa ou chamado.
 * Ela contém informações sobre a data de início e se o início foi ou não realizado.
 */
@Getter
@Setter
public class StartupDTO {

    /** A data de início em formato de string. */
    private String date;

    /** Indica se o início foi realizado. */
    private boolean accomplished;
}