package com.example.tomticketapi1.structure.dto.entitiesDTO.departamentosDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * A classe DepartmentsDTO representa uma coleção de departamentos
 * obtida de uma API. Esta classe usa anotações do Lombok para
 * gerar métodos getters e setters automaticamente.
 */
@Setter
@Getter
public class DepartmentsDTO {

    /** A lista de departamentos. */
    private List<DepartmentDTO> data;
}
