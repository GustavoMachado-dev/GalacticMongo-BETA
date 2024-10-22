package com.example.tomticketapi1.structure.domain.entities.classes;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * Classe que representa uma data personalizada com funcionalidades de formatação
 * e manipulação de datas.
 *
 * Esta classe permite calcular uma data a partir do momento atual e formatá-la
 * de acordo com um fuso horário específico.
 */
@SuppressWarnings("all")
public class CustomDate {

    /**
     * Data e hora atual.
     */
    LocalDateTime dateTime;

    /**
     * Data e hora correspondente a dois anos atrás.
     */
    LocalDateTime dateTimeTwoYearsAgo;

    /**
     * Deslocamento de fuso horário.
     */
    ZoneOffset offset;

    /**
     * Formato para a data.
     */
    DateTimeFormatter formatter;

    /**
     * Data formatada como uma string.
     */
    String formattedDate;

    /**
     * Construtor que inicializa a data atual e calcula a data de dois anos atrás,
     * além de configurar o fuso horário e o formato da data.
     *
     * @param yearsToSearch número de anos a serem subtraídos da data atual para
     *                      calcular a data antiga.
     */
    public CustomDate(int yearsToSearch) {
        this.dateTime = LocalDateTime.now();
        this.dateTimeTwoYearsAgo = dateTime.minusYears(yearsToSearch);
        this.offset = ZoneOffset.of("-03:00");
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssZ");
        this.formattedDate = dateTimeTwoYearsAgo.atOffset(offset).format(formatter);
    }

    /**
     * Obtém a data e hora atual.
     *
     * @return a data e hora atual.
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Define a data e hora atual.
     *
     * @param dateTime a nova data e hora a serem definidas.
     */
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Obtém a data e hora correspondente a dois anos atrás.
     *
     * @return a data e hora de dois anos atrás.
     */
    public LocalDateTime getDateTimeTwoYearsAgo() {
        return dateTimeTwoYearsAgo;
    }

    /**
     * Define a data e hora correspondente a dois anos atrás.
     *
     * @param dateTimeTwoYearsAgo a nova data e hora a serem definidas.
     */
    public void setDateTimeTwoYearsAgo(LocalDateTime dateTimeTwoYearsAgo) {
        this.dateTimeTwoYearsAgo = dateTimeTwoYearsAgo;
    }

    /**
     * Obtém o deslocamento de fuso horário.
     *
     * @return o deslocamento de fuso horário.
     */
    public ZoneOffset getOffset() {
        return offset;
    }

    /**
     * Define o deslocamento de fuso horário.
     *
     * @param offset o novo deslocamento de fuso horário a ser definido.
     */
    public void setOffset(ZoneOffset offset) {
        this.offset = offset;
    }

    /**
     * Obtém o formato de data.
     *
     * @return o formato de data.
     */
    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    /**
     * Define o formato de data.
     *
     * @param formatter o novo formato de data a ser definido.
     */
    public void setFormatter(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    /**
     * Obtém a data formatada como uma string.
     *
     * @return a data formatada.
     */
    public String getFormattedDate() {
        return formattedDate;
    }

    /**
     * Define a data formatada como uma string.
     *
     * @param formattedDate a nova data formatada a ser definida.
     */
    public void setFormattedDate(String formattedDate) {
        this.formattedDate = formattedDate;
    }
}