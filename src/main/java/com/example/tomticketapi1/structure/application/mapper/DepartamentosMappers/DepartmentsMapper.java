package com.example.tomticketapi1.structure.application.mapper.DepartamentosMappers;

import com.example.tomticketapi1.structure.domain.entities.departamentos.Departments;
import com.example.tomticketapi1.structure.dto.entitiesDTO.departamentosDTO.DepartmentsDTO;

import java.util.stream.Collectors;

/**
 * Classe responsável por mapear entre {@link DepartmentsDTO} e {@link Departments}.
 */
@SuppressWarnings("unused")
public class DepartmentsMapper {

    /**
     * Converte um {@link DepartmentsDTO} para um objeto {@link Departments}.
     * Este método cria uma nova instância de {@link Departments} e mapeia
     * a lista de {@link DepartmentsDTO} para objetos {@link Departments} utilizando
     * o mapeador {@link DepartmentMapper}.
     *
     * @param departmentsDTO Objeto de transferência de dados (DTO) que contém a lista de departamentos.
     * @return Um objeto {@link Departments} representando a lista de departamentos,
     * ou {@code null} se o DTO for nulo.
     */
    public static Departments toDomain(DepartmentsDTO departmentsDTO) {
        Departments departments = new Departments();
        departments.setData(
                departmentsDTO.getData() != null ?
                        departmentsDTO.getData().stream()
                                .map(DepartmentMapper::toDomain)
                                .collect(Collectors.toList()) : null
        );
        return departments;
    }

    /**
     * Converte um objeto {@link Departments} para {@link DepartmentsDTO}.
     * Este método cria um novo {@code DepartmentsDTO} e mapeia a lista de
     * objetos {@link Departments} de volta para DTOs utilizando o mapeador
     * {@link DepartmentMapper}.
     *
     * @param departments Objeto que representa a lista de departamentos.
     * @return Um objeto {@link DepartmentsDTO} com os valores mapeados,
     * ou {@code null} se o objeto de domínio for nulo.
     */
    public static DepartmentsDTO toDTO(Departments departments) {
        DepartmentsDTO departmentsDTO = new DepartmentsDTO();
        departmentsDTO.setData(
                departments.getData() != null ?
                        departments.getData().stream()
                                .map(DepartmentMapper::toDTO)
                                .collect(Collectors.toList()) : null
        );
        return departmentsDTO;
    }
}

