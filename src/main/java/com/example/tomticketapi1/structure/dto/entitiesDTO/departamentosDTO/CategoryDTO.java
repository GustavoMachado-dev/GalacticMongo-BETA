package com.example.tomticketapi1.structure.dto.entitiesDTO.departamentosDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * A classe CategoryDTO representa uma categoria com um identificador e um nome.
 */
@Getter
@Setter
public class CategoryDTO {

    /** O identificador único da categoria. */
    private String id;

    /** O nome da categoria. */
    private String name;
}