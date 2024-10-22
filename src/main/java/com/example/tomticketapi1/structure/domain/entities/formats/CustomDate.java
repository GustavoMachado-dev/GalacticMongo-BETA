package com.example.tomticketapi1.structure.domain.entities.formats;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * A classe CustomDate representa uma data personalizada com funcionalidades
 * para manipulação de datas e formatação.
 *
 * Esta classe permite obter a data atual, a data de dois anos atrás e
 * formata a data no padrão desejado com um ajuste de fuso horário.
 */
@SuppressWarnings("unused")
@Getter
@Setter
public class CustomDate {

    /**
     * Data e hora atual.
     */
    private LocalDateTime dateTime;

    /**
     * Data e hora de dois anos atrás.
     */
    private LocalDateTime dateTimeTwoYearsAgo;

    /**
     * Fuso horário utilizado para formatação de data.
     */
    private ZoneOffset offset;

    /**
     * Formato utilizado para a data.
     */
    private DateTimeFormatter formatter;

    /**
     * Data formatada no padrão especificado.
     */
    private String formattedDate;

    /**
     * Construtor da classe CustomDate.
     *
     * Inicializa a data atual, a data de dois anos atrás e formata
     * a data de acordo com o fuso horário especificado.
     *
     * @param yearsToSearch Número de anos para subtrair da data atual
     *                      ao calcular dateTimeTwoYearsAgo.
     */
    public CustomDate(int yearsToSearch) {
        this.dateTime = LocalDateTime.now();
        this.dateTimeTwoYearsAgo = dateTime.minusYears(yearsToSearch);
        this.offset = ZoneOffset.of("-03:00");
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssZ");
        this.formattedDate = dateTimeTwoYearsAgo.atOffset(offset).format(formatter);
    }
}