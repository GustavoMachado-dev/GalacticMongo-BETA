package com.example.tomticketapi1.structure.domain.entities.departamentos;

import lombok.Getter;
import lombok.Setter;

/**
 * A classe Operator representa um operador associado a um departamento.
 * Esta classe contém informações básicas sobre o operador, incluindo
 * um identificador, nome e hash do e-mail.
 */
@Getter
@Setter
public class Operator {

    /**
     * Identificador único do operador.
     */
    private String id;

    /**
     * Nome do operador.
     */
    private String name;

    /**
     * Hash do e-mail do operador, utilizado para segurança e privacidade.
     */
    private String mail_hash;
}
