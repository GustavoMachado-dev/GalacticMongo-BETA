package com.example.tomticketapi1.structure.dto.entitiesDTO.departamentosDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * A classe OperatorDTO representa um operador com um identificador,
 * um nome e um hash de e-mail. Esta classe usa anotações do Lombok
 * para gerar métodos getters e setters automaticamente.
 */
@Getter
@Setter
public class OperatorDTO {

    /** O identificador único do operador. */
    private String id;

    /** O nome do operador. */
    private String name;

    /** O hash do e-mail do operador. */
    private String mail_hash;
}