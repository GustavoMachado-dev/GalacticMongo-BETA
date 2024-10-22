package com.example.tomticketapi1.structure.dto.entitiesDTO.departamentosDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * A classe StatusDTO representa o status de um chamado com um identificador,
 * uma descrição e uma data de aplicação. Esta classe usa anotações do Lombok
 * para gerar métodos getters e setters automaticamente.
 */
@Getter
@Setter
public class StatusDTO {

    /** O identificador único do status. */
    private String id;

    /** A descrição do status. */
    private String description;

    /** A data em que o status foi aplicado. */
    private String apply_date;
}