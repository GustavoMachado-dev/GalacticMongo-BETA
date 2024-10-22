package com.example.tomticketapi1.structure.application.mapper.ChamadosMappers.SubentitiesMappers;

import com.example.tomticketapi1.structure.domain.entities.chamados.subentities.Situation;
import com.example.tomticketapi1.structure.dto.entitiesDTO.chamadosDTO.subentities.SituationDTO;

/**
 * Classe responsável por mapear entre o objeto de domínio {@link Situation}
 * e o objeto de transferência de dados {@link SituationDTO}.
 * Contém métodos para converter do DTO para o domínio e vice-versa.
 */
public class SituationMapper {

    /**
     * Converte um {@link SituationDTO} para um objeto do domínio {@link Situation}.
     * Se o {@code situationDTO} fornecido for nulo, o método retorna {@code null}.
     *
     * @param situationDTO Objeto de transferência de dados (DTO) que será convertido para a entidade de domínio.
     * @return Um objeto {@link Situation} com os valores mapeados do {@code situationDTO}, ou {@code null} se o DTO for nulo.
     */
    public static Situation toDomain(SituationDTO situationDTO) {
        if (situationDTO == null) {
            return null;
        }

        Situation situation = new Situation();
        situation.setId(situationDTO.getId());
        situation.setApply_date(situationDTO.getApply_date());
        situation.setDescription(situationDTO.getDescription());

        return situation;
    }

    /**
     * Converte um objeto de domínio {@link Situation} para um {@link SituationDTO}.
     * Se o {@code situation} fornecido for nulo, o método retorna {@code null}.
     *
     * @param situation Objeto de domínio que será convertido para DTO.
     * @return Um objeto {@link SituationDTO} com os valores mapeados do {@code situation}, ou {@code null} se o domínio for nulo.
     */
    public static SituationDTO toDTO(Situation situation) {
        if (situation == null) {
            return null;
        }

        SituationDTO situationDTO = new SituationDTO();
        situationDTO.setId(situation.getId());
        situationDTO.setApply_date(situation.getApply_date());
        situationDTO.setDescription(situation.getDescription());

        return situationDTO;
    }
}
