package com.example.tomticketapi1.structure.domain.entities.chamados.subentities;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe que representa a situação de um chamado ou serviço.
 *
 * Esta classe contém informações sobre a data de aplicação da situação,
 * a descrição e um identificador único.
 */
@Getter
@Setter
public class Situation {

    /**
     * Identificador único da situação.
     */
    private int id;

    /**
     * Data em que a situação foi aplicada.
     */
    private String apply_date;

    /**
     * Descrição da situação.
     */
    private String description;
}