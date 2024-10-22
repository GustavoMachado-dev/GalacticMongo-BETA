package com.example.tomticketapi1.structure.application.mapper.ChamadosMappers.SubentitiesMappers;

import com.example.tomticketapi1.structure.application.mapper.ClassesMappers.OrganizationMapper;
import com.example.tomticketapi1.structure.domain.entities.chamados.subentities.Costumer;
import com.example.tomticketapi1.structure.dto.entitiesDTO.chamadosDTO.subentities.CostumerDTO;

/**
 * Classe responsável por mapear entre o objeto de domínio {@link Costumer}
 * e o objeto de transferência de dados {@link CostumerDTO}.
 * Contém métodos para converter do DTO para o domínio e vice-versa.
 */
public class CostumerMapper {

    /**
     * Converte um {@link CostumerDTO} para um objeto do domínio {@link Costumer}.
     * Se o {@code costumerDTO} fornecido for nulo, o método retorna {@code null}.
     *
     * @param costumerDTO Objeto de transferência de dados (DTO) que será convertido para a entidade de domínio.
     * @return Um objeto {@link Costumer} com os valores mapeados do {@code costumerDTO}, ou {@code null} se o DTO for nulo.
     */
    public static Costumer toDomain(CostumerDTO costumerDTO) {
        if (costumerDTO == null) {
            return null;
        }

        Costumer costumer = new Costumer();
        costumer.setNome(costumerDTO.getNome());
        costumer.setEmail(costumerDTO.getEmail());
        costumer.setInternal_id(costumerDTO.getInternal_id());
        costumer.setOrganization(OrganizationMapper.toDomain(costumerDTO.getOrganizationDTO()));

        return costumer;
    }

    /**
     * Converte um objeto de domínio {@link Costumer} para um {@link CostumerDTO}.
     * Se o {@code costumer} fornecido for nulo, o método retorna {@code null}.
     *
     * @param costumer Objeto de domínio que será convertido para DTO.
     * @return Um objeto {@link CostumerDTO} com os valores mapeados do {@code costumer}, ou {@code null} se o domínio for nulo.
     */
    public static CostumerDTO toDTO(Costumer costumer) {
        if (costumer == null) {
            return null;
        }

        CostumerDTO costumerDTO = new CostumerDTO();
        costumerDTO.setNome(costumer.getNome());
        costumerDTO.setEmail(costumer.getEmail());
        costumerDTO.setInternal_id(costumer.getInternal_id());
        costumerDTO.setOrganizationDTO(OrganizationMapper.toDTO(costumer.getOrganization()));

        return costumerDTO;
    }
}
