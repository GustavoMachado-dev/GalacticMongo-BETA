package com.example.tomticketapi1.structure.domain.entities.departamentos;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe que representa uma categoria de departamento.
 * Esta classe contém informações básicas sobre uma categoria, incluindo
 * um identificador e o nome da categoria.
 */
@Getter
@Setter
public class Category {

    /**
     * Identificador único da categoria.
     */
    private String id;

    /**
     * Nome da categoria.
     */
    private String name;
}
