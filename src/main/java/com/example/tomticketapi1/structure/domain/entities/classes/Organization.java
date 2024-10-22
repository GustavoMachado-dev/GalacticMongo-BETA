package com.example.tomticketapi1.structure.domain.entities.classes;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe que representa uma organização.
 * Esta classe contém informações básicas sobre uma organização, incluindo
 * um identificador e o nome da organização.
 */
@Getter
@Setter
public class Organization {

    /**
     * Identificador único da organização.
     */
    private String id;

    /**
     * Nome da organização.
     */
    private String nome;
}
