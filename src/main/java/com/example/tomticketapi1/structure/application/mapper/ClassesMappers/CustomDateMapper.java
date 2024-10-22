package com.example.tomticketapi1.structure.application.mapper.ClassesMappers;

import com.example.tomticketapi1.structure.dto.entitiesDTO.classesDTO.CustomDateDTO;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
/**
 * Classe responsável por mapear entre {@link CustomDateDTO} e {@link LocalDateTime}.
 */
@SuppressWarnings("unused")
public class CustomDateMapper {

    /**
     * Converte um {@link CustomDateDTO} para um objeto {@link LocalDateTime}.
     * Este método verifica se o {@code customDateDTO} é nulo antes de retornar
     * a data correspondente de dois anos atrás no formato {@link LocalDateTime}.
     *
     * @param customDateDTO Objeto de transferência de dados (DTO) que contém a data a ser convertida.
     * @return Um objeto {@link LocalDateTime} representando a data correspondente de dois anos atrás,
     * ou {@code null} se o DTO for nulo.
     */
    public static LocalDateTime toDomain(CustomDateDTO customDateDTO) {
        if (customDateDTO == null) {
            return null;
        }

        return customDateDTO.getDateTimeTwoYearsAgo();
    }

    /**
     * Converte um objeto {@link LocalDateTime} para {@link CustomDateDTO}.
     * Este método cria um novo {@code CustomDateDTO}, define a data fornecida e calcula
     * a data correspondente de anos atrás. Além disso, define o offset e o formato da data.
     *
     * @param dateTime      Objeto {@link LocalDateTime} que será convertido para o DTO.
     * @param yearsToSearch O número de anos para retroceder a partir da data fornecida.
     * @return Um objeto {@link CustomDateDTO} com os valores mapeados do {@code dateTime},
     * ou {@code null} se a data for nula.
     */
    public static CustomDateDTO toDTO(LocalDateTime dateTime, int yearsToSearch) {
        if (dateTime == null) {
            return null;
        }

        CustomDateDTO customDateDTO = new CustomDateDTO(yearsToSearch);
        customDateDTO.setDateTime(dateTime);
        customDateDTO.setDateTimeTwoYearsAgo(dateTime.minusYears(yearsToSearch));
        customDateDTO.setOffset(ZoneOffset.of("-03:00"));
        customDateDTO.setFormattedDate(dateTime.minusYears(yearsToSearch)
                .atOffset(customDateDTO.getOffset())
                .format(customDateDTO.getFormatter()));

        return customDateDTO;
    }
}

