package com.example.tomticketapi1.structure.domain.entities.departamentos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * A classe Departments representa uma coleção de departamentos
 * obtida de uma API. Esta classe usa anotações do Lombok para
 * gerar métodos getters e setters automaticamente.
 */
@Setter
@Getter
public class Departments {

    /**
     * Lista de departamentos obtidos da API.
     */
    private List<Department> data;
}