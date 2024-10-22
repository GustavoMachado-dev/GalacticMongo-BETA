package com.example.tomticketapi1.structure.dto.entitiesDTO.formatsDTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * A classe CustomDateDTO é responsável por armazenar e formatar datas personalizadas.
 * Ela contém a data atual e a data correspondente a um número especificado de anos no passado.
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class CustomDateDTO {
    LocalDateTime dateTime; // A data e hora atual
    LocalDateTime dateTimeTwoYearsAgo; // A data e hora correspondente a dois anos atrás
    ZoneOffset offset; // O offset de fuso horário

    /*
     *  Formata a data no padrão correto, ajustando o timezone sem ":".
     */
    DateTimeFormatter formatter; // O formatador de data
    String formattedDate; // A data formatada como uma String

    /**
     * Constrói um CustomDateDTO com a data atual e a data correspondente a um número específico de anos no passado.
     *
     * @param yearsToSearch O número de anos a serem subtraídos da data atual.
     */
    public CustomDateDTO(int yearsToSearch) {
        this.dateTime = LocalDateTime.now();
        this.dateTimeTwoYearsAgo = dateTime.minusYears(yearsToSearch);
        this.offset = ZoneOffset.of("-03:00");
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssZ");
        this.formattedDate = dateTimeTwoYearsAgo.atOffset(offset).format(formatter);
    }
}