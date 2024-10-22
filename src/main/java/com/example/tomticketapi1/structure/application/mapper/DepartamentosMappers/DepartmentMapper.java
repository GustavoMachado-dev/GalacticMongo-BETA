package com.example.tomticketapi1.structure.application.mapper.DepartamentosMappers;

import com.example.tomticketapi1.structure.domain.entities.departamentos.Department;
import com.example.tomticketapi1.structure.dto.entitiesDTO.departamentosDTO.DepartmentDTO;

import java.util.stream.Collectors;

/**
 * Classe responsável por mapear entre {@link DepartmentDTO} e {@link Department}.
 */
public class DepartmentMapper {

    /**
     * Converte um {@link DepartmentDTO} para um objeto {@link Department}.
     * Este método verifica se o {@code departmentDTO} é nulo antes de criar
     * e retornar uma nova instância de {@link Department}. Além disso, mapeia
     * as listas de categorias, status e operadores utilizando seus respectivos
     * mapeadores.
     *
     * @param departmentDTO Objeto de transferência de dados (DTO) que contém os dados do departamento.
     * @return Um objeto {@link Department} representando os dados do departamento,
     * ou {@code null} se o DTO for nulo.
     */
    public static Department toDomain(DepartmentDTO departmentDTO) {
        if (departmentDTO == null) {
            return null;
        }

        Department department = new Department();
        department.setId(departmentDTO.getId());
        department.setName(departmentDTO.getName());

        // Converter a lista de CategoryDTO para Category (entidade de domínio)
        department.setCategories(
                departmentDTO.getCategories() != null ?
                        departmentDTO.getCategories().stream()
                                .map(CategoryMapper::toDomain)
                                .collect(Collectors.toList()) : null
        );

        // Converter a lista de StatusDTO para Status (entidade de domínio)
        department.setStatus(
                departmentDTO.getStatusDTOS() != null ?
                        departmentDTO.getStatusDTOS().stream()
                                .map(StatusMapper::toDomain)
                                .collect(Collectors.toList()) : null
        );

        // Converter a lista de OperatorDTO para Operator (entidade de domínio)
        department.setOperators(
                departmentDTO.getOperatorDTOS() != null ?
                        departmentDTO.getOperatorDTOS().stream()
                                .map(OperatorMapper::toDomain)
                                .collect(Collectors.toList()) : null
        );

        return department;
    }

    /**
     * Converte um objeto {@link Department} para {@link DepartmentDTO}.
     * Este método cria um novo {@code DepartmentDTO} e mapeia os atributos
     * do objeto de domínio {@code department}. Além disso, converte as listas
     * de categorias, status e operadores de volta para DTOs utilizando seus respectivos
     * mapeadores.
     *
     * @param department Objeto de domínio que será convertido para o DTO.
     * @return Um objeto {@link DepartmentDTO} com os valores mapeados,
     * ou {@code null} se o objeto de domínio for nulo.
     */
    public static DepartmentDTO toDTO(Department department) {
        if (department == null) {
            return null;
        }

        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(department.getId());
        departmentDTO.setName(department.getName());

        // Converter a lista de Category para CategoryDTO
        departmentDTO.setCategories(
                department.getCategories() != null ?
                        department.getCategories().stream()
                                .map(CategoryMapper::toDTO)
                                .collect(Collectors.toList()) : null
        );

        // Converter a lista de Status para StatusDTO
        departmentDTO.setStatusDTOS(
                department.getStatus() != null ?
                        department.getStatus().stream()
                                .map(StatusMapper::toDTO)
                                .collect(Collectors.toList()) : null
        );

        // Converter a lista de Operator para OperatorDTO
        departmentDTO.setOperatorDTOS(
                department.getOperators() != null ?
                        department.getOperators().stream()
                                .map(OperatorMapper::toDTO)
                                .collect(Collectors.toList()) : null
        );

        return departmentDTO;
    }
}