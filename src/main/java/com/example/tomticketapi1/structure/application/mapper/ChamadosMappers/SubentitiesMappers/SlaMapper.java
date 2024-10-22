package com.example.tomticketapi1.structure.application.mapper.ChamadosMappers.SubentitiesMappers;

import com.example.tomticketapi1.structure.application.mapper.ClassesMappers.SubclassesMappers.DeadlineMapper;
import com.example.tomticketapi1.structure.application.mapper.ClassesMappers.SubclassesMappers.StartupMapper;
import com.example.tomticketapi1.structure.domain.entities.chamados.subentities.Sla;
import com.example.tomticketapi1.structure.dto.entitiesDTO.chamadosDTO.subentities.SlaDTO;

/**
 * Classe responsável por mapear entre o objeto de domínio {@link Sla}
 * e o objeto de transferência de dados {@link SlaDTO}.
 * Contém métodos para converter do DTO para o domínio.
 */
public class SlaMapper {
    /**
     * Converte um {@link SlaDTO} para um objeto do domínio {@link Sla}.
     * Se o {@code slaDTO} fornecido for nulo, o método retorna {@code null}.
     * @param slaDTO Objeto de transferência de dados (DTO) que será convertido para a entidade de domínio.
     * @return Um objeto {@link Sla} com os valores mapeados do {@code slaDTO}, ou {@code null} se o DTO for nulo.
     */
    public static Sla toDomain(SlaDTO slaDTO) {
        if (slaDTO == null) {
            return null;
        }
        Sla sla = new Sla();
        sla.setStartup(StartupMapper.toDomain(slaDTO.getStartupDTO()));  // Mapeia StartupDTO para Startup
        sla.setDeadline(DeadlineMapper.toDomain(slaDTO.getDeadlineDTO()));  // Mapeia DeadlineDTO para Deadline
        return sla;
    }
}
