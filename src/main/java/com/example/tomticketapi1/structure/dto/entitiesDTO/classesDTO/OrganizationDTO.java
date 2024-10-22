package com.example.tomticketapi1.structure.dto.entitiesDTO.classesDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * A classe OrganizationDTO representa uma organização com um identificador e um nome.
 */
@Getter
@Setter
public class OrganizationDTO {

    /** O identificador único da organização. */
    private String id;

    /** O nome da organização. */
    private String nome;
}