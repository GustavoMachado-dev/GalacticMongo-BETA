package com.example.tomticketapi1.structure.dto.entitiesDTO.chamadosDTO.subentities;

import com.example.tomticketapi1.structure.dto.entitiesDTO.classesDTO.subclasses.DeadlineDTO;
import com.example.tomticketapi1.structure.dto.entitiesDTO.classesDTO.subclasses.StartupDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * A classe SlaDTO representa o Acordo de Nível de Serviço (SLA) de um chamado no sistema.
 * Ela contém informações sobre a startup associada e o prazo estabelecido para o atendimento do chamado.
 */
@Getter
@Setter
public class SlaDTO {

    /** A startup associada ao chamado. */
    private StartupDTO startupDTO;

    /** O prazo para a resolução do chamado. */
    private DeadlineDTO deadlineDTO;
}