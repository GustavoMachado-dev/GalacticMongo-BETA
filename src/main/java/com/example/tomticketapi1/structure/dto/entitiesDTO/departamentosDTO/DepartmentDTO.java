package com.example.tomticketapi1.structure.dto.entitiesDTO.departamentosDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * A classe DepartmentDTO representa um departamento armazenado na coleção "departments" no MongoDB.
 * Esta classe usa anotações do Lombok para gerar métodos getters e setters automaticamente.
 */
@Setter
@Getter
public class DepartmentDTO {

    /** O identificador único do departamento. */
    private String id;

    /** O nome do departamento. */
    private String name;

    /** A lista de categorias associadas a este departamento. */
    private List<CategoryDTO> categories;

    /** A lista de status associados a este departamento. */
    private List<StatusDTO> statusDTOS;

    /** A lista de operadores associados a este departamento. */
    private List<OperatorDTO> operatorDTOS;
}