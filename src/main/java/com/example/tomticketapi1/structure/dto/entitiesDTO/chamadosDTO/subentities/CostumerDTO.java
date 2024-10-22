package com.example.tomticketapi1.structure.dto.entitiesDTO.chamadosDTO.subentities;

import com.example.tomticketapi1.structure.dto.entitiesDTO.classesDTO.OrganizationDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * A classe CostumerDTO representa um cliente no sistema de chamados.
 * Ela contém informações relevantes sobre o cliente, como nome, email e organização.
 */
@Getter
@Setter
public class CostumerDTO {

    /** O nome do cliente. */
    private String nome;

    /** O email do cliente. */
    private String email;

    /** O identificador interno do cliente. */
    private String internal_id;

    /** Informações sobre a organização associada ao cliente. */
    private OrganizationDTO organizationDTO;
}