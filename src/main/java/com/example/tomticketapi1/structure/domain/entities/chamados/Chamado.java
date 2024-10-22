package com.example.tomticketapi1.structure.domain.entities.chamados;

import com.example.tomticketapi1.structure.domain.entities.chamados.subentities.*;
import com.example.tomticketapi1.structure.domain.entities.departamentos.Category;
import com.example.tomticketapi1.structure.domain.entities.departamentos.Department;
import com.example.tomticketapi1.structure.domain.entities.departamentos.Operator;
import com.example.tomticketapi1.structure.domain.entities.departamentos.Status;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe que representa um chamado no sistema.
 *
 * Esta classe contém todas as informações relevantes sobre o chamado,
 * incluindo dados do cliente, prioridade, tipo de ticket, tempo de trabalho,
 * datas de criação e encerramento, além de outros detalhes.
 */
@Getter
@Setter
public class Chamado {

    /**
     * Identificador único do chamado.
     */
    private String id;

    /**
     * Número do protocolo associado ao chamado.
     */
    private int protocol;

    /**
     * Assunto do chamado.
     */
    private String subject;

    /**
     * Mensagem ou descrição do chamado.
     */
    private String message;

    /**
     * Tipo MIME da mensagem.
     */
    private String mimetype;

    /**
     * Cliente associado ao chamado.
     */
    private Costumer costumer;

    /**
     * Prioridade do chamado.
     */
    private int priority;

    /**
     * Tipo do ticket (ex: incidente, solicitação).
     */
    private String ticketType;

    /**
     * Tempo de trabalho estimado para resolver o chamado.
     */
    private int work_time;

    /**
     * Tempo já decorrido desde a abertura do chamado.
     */
    private int elapsed_time;

    /**
     * Data de criação do chamado.
     */
    private String creation_date;

    /**
     * Acordo de Nível de Serviço (SLA) associado ao chamado.
     */
    private Sla sla;

    /**
     * Custos associados ao chamado.
     */
    private Cost cost;

    /**
     * Avaliação do chamado realizada pelo cliente.
     */
    private Evaluation evaluation;

    /**
     * Data da primeira resposta ao chamado.
     */
    private String first_reply_date;

    /**
     * Data de encerramento do chamado.
     */
    private String end_date;

    /**
     * Situação atual do chamado.
     */
    private Situation situation;

    /**
     * Categoria do chamado.
     */
    private Category category;

    /**
     * Departamento responsável pelo chamado.
     */
    private Department department;

    /**
     * Operador que está lidando com o chamado.
     */
    private Operator operator;

    /**
     * Status atual do chamado.
     */
    private Status status;

    /**
     * Identificador do chamado pai, se aplicável.
     */
    private String parent_ticket_id;

    /**
     * Data agendada para atendimento do chamado.
     */
    private String schedule_date;
}