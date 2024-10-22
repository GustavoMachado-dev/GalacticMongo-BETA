package com.example.tomticketapi1.structure.dto.entitiesDTO.chamadosDTO.subentities;

import lombok.Getter;
import lombok.Setter;

/**
 * A classe CostDTO representa os custos associados a um chamado.
 * Ela contém informações sobre as taxas horárias, horas extras e totais financeiros.
 */
@Getter
@Setter
public class CostDTO {
    /** O custo por hora de trabalho. */
    private float hourly;

    /** O custo por horas extras trabalhadas. */
    private float overtime;

    /** O custo total final do chamado. */
    private float total_final;

    /** O total de horas extras. */
    private float total_overtime;

    /** O total bruto acumulado. */
    private float total_gross;
}