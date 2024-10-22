package com.example.tomticketapi1.structure.dto.entitiesDTO.classesDTO;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * A classe CustomDateDTO é utilizada para gerenciar e formatar datas.
 * Ela contém a data atual e a data correspondente a dois anos atrás,
 * além de um offset de fuso horário e um formatador para formatar a data.
 */
@SuppressWarnings("all")
public class CustomDateDTO {

    /** A data e hora atual. */
    private LocalDateTime dateTime;

    /** A data e hora correspondente a dois anos atrás. */
    private LocalDateTime dateTimeTwoYearsAgo;

    /** O offset de fuso horário utilizado para formatação de datas. */
    private ZoneOffset offset;

    /** O formatador de data utilizado para formatar as datas. */
    private DateTimeFormatter formatter;

    /** A data formatada como uma string. */
    private String formattedDate;

    /**
     * Construtor da classe CustomDateDTO.
     * Inicializa a data atual e a data correspondente ao número de anos
     * especificado atrás.
     *
     * @param yearsToSearch o número de anos para retroceder a partir da data atual.
     */
    public CustomDateDTO(int yearsToSearch) {
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
     * @param dateTime a nova data e hora atual a ser definida.
     */
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Obtém a data e hora correspondente a dois anos atrás.
     *
     * @return a data e hora correspondente a dois anos atrás.
     */
    public LocalDateTime getDateTimeTwoYearsAgo() {
        return dateTimeTwoYearsAgo;
    }

    /**
     * Define a data e hora correspondente a dois anos atrás.
     *
     * @param dateTimeTwoYearsAgo a nova data e hora correspondente a dois anos atrás a ser definida.
     */
    public void setDateTimeTwoYearsAgo(LocalDateTime dateTimeTwoYearsAgo) {
        this.dateTimeTwoYearsAgo = dateTimeTwoYearsAgo;
    }

    /**
     * Obtém o offset de fuso horário utilizado para formatação de datas.
     *
     * @return o offset de fuso horário.
     */
    public ZoneOffset getOffset() {
        return offset;
    }

    /**
     * Define o offset de fuso horário utilizado para formatação de datas.
     *
     * @param offset o novo offset de fuso horário a ser definido.
     */
    public void setOffset(ZoneOffset offset) {
        this.offset = offset;
    }

    /**
     * Obtém o formatador de data utilizado para formatar as datas.
     *
     * @return o formatador de data.
     */
    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    /**
     * Define o formatador de data utilizado para formatar as datas.
     *
     * @param formatter o novo formatador de data a ser definido.
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