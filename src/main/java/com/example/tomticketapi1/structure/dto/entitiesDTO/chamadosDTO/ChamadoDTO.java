package com.example.tomticketapi1.structure.dto.entitiesDTO.chamadosDTO;

import com.example.tomticketapi1.structure.dto.entitiesDTO.chamadosDTO.subentities.*;
import com.example.tomticketapi1.structure.dto.entitiesDTO.departamentosDTO.CategoryDTO;
import com.example.tomticketapi1.structure.dto.entitiesDTO.departamentosDTO.DepartmentDTO;
import com.example.tomticketapi1.structure.dto.entitiesDTO.departamentosDTO.OperatorDTO;
import com.example.tomticketapi1.structure.dto.entitiesDTO.departamentosDTO.StatusDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * A classe ChamadoDTO representa os detalhes de um chamado no sistema.
 * Contém informações relevantes sobre o chamado, como dados do cliente,
 * prioridade, status, e detalhes relacionados ao SLA e custo.
 */
@Getter
@Setter
public class ChamadoDTO {

    /** O identificador único do chamado. */
    private String id;

    /** O número do protocolo do chamado. */
    private int protocol;

    /** O assunto do chamado. */
    private String subject;

    /** A mensagem descritiva do chamado. */
    private String message;

    /** O tipo MIME da mensagem. */
    private String mimetype;

    /** As informações do cliente associadas ao chamado. */
    private CostumerDTO costumer;

    /** A prioridade do chamado. */
    private int priority;

    /** O tipo de ticket (chamado). */
    private String ticketType;

    /** O tempo de trabalho estimado para resolução do chamado. */
    private int work_time;

    /** O tempo decorrido desde a abertura do chamado. */
    private int elapsed_time;

    /** A data de criação do chamado. */
    private String creation_date;

    /** As informações de SLA do chamado. */
    private SlaDTO sla;

    /** Os custos associados ao chamado. */
    private CostDTO cost;

    /** A avaliação do chamado, se aplicável. */
    private EvaluationDTO evaluation;

    /** A data da primeira resposta ao chamado. */
    private String first_reply_date;

    /** A data de encerramento do chamado. */
    private String end_date;

    /** A situação atual do chamado. */
    private SituationDTO situation;

    /** A categoria do chamado. */
    private CategoryDTO category;

    /** O departamento responsável pelo chamado. */
    private DepartmentDTO department;

    /** O operador que está lidando com o chamado. */
    private OperatorDTO operator;

    /** O status atual do chamado. */
    private StatusDTO status;

    /** O ID do ticket pai, se for um chamado filho. */
    private String parent_ticket_id;

    /** A data agendada para o atendimento do chamado. */
    private String schedule_date;
}