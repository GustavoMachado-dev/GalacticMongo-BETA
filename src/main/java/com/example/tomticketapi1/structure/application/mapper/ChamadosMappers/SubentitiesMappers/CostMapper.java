package com.example.tomticketapi1.structure.application.mapper.ChamadosMappers.SubentitiesMappers;

import com.example.tomticketapi1.structure.domain.entities.chamados.subentities.Cost;
import com.example.tomticketapi1.structure.dto.entitiesDTO.chamadosDTO.subentities.CostDTO;
/**
 * Classe responsável por mapear o objeto {@link CostDTO} para a entidade de domínio {@link Cost}. *
 * A conversão é realizada por meio do método estático {@code toDomain}, que recebe um
 * objeto {@code CostDTO} e retorna a entidade correspondente {@code Cost}.
 */
public class CostMapper {

    /**
     * Converte um {@link CostDTO} para um objeto do domínio {@link Cost}.     *
     * Se o {@code costDTO} fornecido for nulo, o método retorna {@code null}.
     *
     * @param costDTO Objeto de transferência de dados (DTO) que será convertido para a entidade de domínio.
     * @return Um objeto {@link Cost} com os valores mapeados do {@code costDTO}, ou {@code null} se o DTO for nulo.
     */
    public static Cost toDomain(CostDTO costDTO) {
        if (costDTO == null) {
            return null;
        }
        Cost cost = new Cost();
        cost.setHourly(costDTO.getHourly());
        cost.setOvertime(costDTO.getOvertime());
        cost.setTotal_final(costDTO.getTotal_final());
        cost.setTotal_overtime(costDTO.getTotal_overtime());
        cost.setTotal_gross(costDTO.getTotal_gross());
        return cost;
    }
}