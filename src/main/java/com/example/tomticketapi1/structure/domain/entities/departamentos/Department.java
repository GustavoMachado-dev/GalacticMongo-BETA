package com.example.tomticketapi1.structure.domain.entities.departamentos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * A classe Department representa um departamento armazenado na coleção "departments" no MongoDB.
 * Esta classe usa anotações do Lombok para gerar métodos getters e setters automaticamente.
 */
@Setter
@Getter
public class Department {

    /**
     * Identificador único do departamento.
     */
    private String id;

    /**
     * Nome do departamento.
     */
    private String name;

    /**
     * Lista de categorias associadas ao departamento.
     */
    private List<Category> categories;

    /**
     * Lista de status que o departamento pode ter.
     */
    private List<Status> status;

    /**
     * Lista de operadores associados ao departamento.
     */
    private List<Operator> operators;
}