package com.example.tomticketapi1.structure.domain.entities.chamados.subentities;

import com.example.tomticketapi1.structure.domain.entities.classes.Organization;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe que representa um cliente no sistema.
 *
 * Esta classe contém informações básicas sobre o cliente, incluindo
 * seu nome, e-mail, identificador interno e a organização a qual pertence.
 */
@Getter
@Setter
public class Costumer {

    /**
     * Nome do cliente.
     */
    private String nome;

    /**
     * E-mail do cliente.
     */
    private String email;

    /**
     * Identificador interno do cliente.
     */
    private String internal_id;

    /**
     * Organização a qual o cliente pertence.
     */
    private Organization organization;
}