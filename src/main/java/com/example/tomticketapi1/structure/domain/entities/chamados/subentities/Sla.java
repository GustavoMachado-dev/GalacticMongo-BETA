package com.example.tomticketapi1.structure.domain.entities.chamados.subentities;

import com.example.tomticketapi1.structure.domain.entities.classes.subclasses.Deadline;
import com.example.tomticketapi1.structure.domain.entities.classes.subclasses.Startup;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe que representa o Acordo de Nível de Serviço (SLA) de um chamado.
 * Esta classe contém informações sobre a startup e o prazo
 * relacionado ao SLA.
 */
@Getter
@Setter
public class Sla {

    /**
     * Startup associada ao SLA.
     */
    private Startup startup;

    /**
     * Prazo relacionado ao SLA.
     */
    private Deadline deadline;
}