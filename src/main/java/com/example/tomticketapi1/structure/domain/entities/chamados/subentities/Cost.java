package com.example.tomticketapi1.structure.domain.entities.chamados.subentities;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe que representa a estrutura de custos de uma tarefa ou serviço.
 *
 * Esta classe inclui informações sobre custos por hora, horas extras e cálculos totais.
 */
@Getter
@Setter
public class Cost {

    /**
     * Custo por hora do serviço.
     */
    private float hourly;

    /**
     * Custo por hora extra.
     */
    private float overtime;

    /**
     * Custo total final após todos os cálculos,
     * incluindo horas regulares e horas extras.
     */
    private float total_final;

    /**
     * Custo total de horas extras.
     */
    private float total_overtime;

    /**
     * Custo bruto total antes de quaisquer deduções ou cobranças adicionais.
     */
    private float total_gross;
}
