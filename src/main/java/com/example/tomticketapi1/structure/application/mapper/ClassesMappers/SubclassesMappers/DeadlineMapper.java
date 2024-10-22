package com.example.tomticketapi1.structure.application.mapper.ClassesMappers.SubclassesMappers;

import com.example.tomticketapi1.structure.domain.entities.classes.subclasses.Deadline;
import com.example.tomticketapi1.structure.dto.entitiesDTO.classesDTO.subclasses.DeadlineDTO;

/**
 * Classe responsável por mapear entre o objeto de transferência de dados {@link DeadlineDTO}
 * e a entidade de domínio {@link Deadline}.
 */
public class DeadlineMapper {

    /**
     * Converte um {@link DeadlineDTO} para um objeto do domínio {@link Deadline}.
     * Este método verifica se o {@code deadlineDTO} é nulo antes de realizar o mapeamento
     * e define a data da entidade {@link Deadline} com base no DTO.
     *
     * @param deadlineDTO Objeto de transferência de dados (DTO) que será convertido para a entidade de domínio.
     * @return Um objeto {@link Deadline} com os valores mapeados do {@code deadlineDTO} ou {@code null} se o DTO for nulo.
     */
    public static Deadline toDomain(DeadlineDTO deadlineDTO) {
        if (deadlineDTO == null) {
            return null;
        }

        Deadline deadline = new Deadline();
        deadline.setDate(deadlineDTO.getDate());

        return deadline;
    }
}
