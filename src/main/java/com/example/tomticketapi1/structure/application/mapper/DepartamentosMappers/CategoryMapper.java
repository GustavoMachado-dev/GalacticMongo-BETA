package com.example.tomticketapi1.structure.application.mapper.DepartamentosMappers;

import com.example.tomticketapi1.structure.domain.entities.departamentos.Category;
import com.example.tomticketapi1.structure.dto.entitiesDTO.departamentosDTO.CategoryDTO;

/**
 * Classe responsável por mapear entre {@link CategoryDTO} e {@link Category}.
 */
public class CategoryMapper {

    /**
     * Converte um {@link CategoryDTO} para um objeto {@link Category}.
     * Este método verifica se o {@code categoryDTO} é nulo antes de criar
     * e retornar uma nova instância de {@link Category}.
     *
     * @param categoryDTO Objeto de transferência de dados (DTO) que contém os dados da categoria.
     * @return Um objeto {@link Category} representando a categoria, ou {@code null} se o DTO for nulo.
     */
    public static Category toDomain(CategoryDTO categoryDTO) {
        if (categoryDTO == null) {
            return null;
        }

        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());

        return category;
    }

    /**
     * Converte um objeto {@link Category} para {@link CategoryDTO}.
     * Este método cria um novo {@code CategoryDTO} e mapeia os atributos
     * do objeto de domínio {@code category}.
     *
     * @param category Objeto de domínio que será convertido para o DTO.
     * @return Um objeto {@link CategoryDTO} com os valores mapeados da categoria,
     * ou {@code null} se a categoria for nula.
     */
    public static CategoryDTO toDTO(Category category) {
        if (category == null) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());

        return categoryDTO;
    }
}

