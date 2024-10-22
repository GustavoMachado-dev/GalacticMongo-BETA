package com.example.tomticketapi1.structure.domain.entities.departamentos;

import lombok.Getter;
import lombok.Setter;

/**
 * A classe Status representa o estado de um item em um departamento.
 * Esta classe contém informações sobre o status, incluindo
 * um identificador, uma descrição e a data em que o status foi aplicado.
 */
@Getter
@Setter
public class Status {

    /**
     * Identificador único do status.
     */
    private String id;

    /**
     * Descrição do status, que indica sua finalidade ou condição.
     */
    private String description;

    /**
     * Data em que o status foi aplicado.
     */
    private String apply_date;
}
