package com.example.tomticketapi1.structure.dto.entitiesDTO.departamentosDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * A classe CustomDTO representa uma estrutura personalizada que contém
 * informações sobre tickets e chats.
 */
@SuppressWarnings("unused")
@Getter
@Setter
public class CustomDTO {

    /** Um array de objetos representando os tickets. */
    private Object[] tickets;

    /** Um array de objetos representando os chats. */
    private Object[] chat;
}