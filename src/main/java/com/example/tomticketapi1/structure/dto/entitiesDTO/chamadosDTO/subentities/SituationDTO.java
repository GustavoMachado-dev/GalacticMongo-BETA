package com.example.tomticketapi1.structure.dto.entitiesDTO.chamadosDTO.subentities;

import lombok.Getter;
import lombok.Setter;

/**
 * A classe SituationDTO representa a situação de um chamado no sistema.
 * Ela contém informações sobre o ID da situação, a data de aplicação e uma descrição da situação.
 */
@Getter
@Setter
public class SituationDTO {

    /** O identificador da situação. */
    private int id;

    /** A data em que a situação foi aplicada. */
    private String apply_date;

    /** Uma descrição detalhada da situação. */
    private String description;
}