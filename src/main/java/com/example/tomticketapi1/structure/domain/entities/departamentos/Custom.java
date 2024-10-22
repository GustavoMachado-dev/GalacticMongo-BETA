package com.example.tomticketapi1.structure.domain.entities.departamentos;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe que representa uma estrutura personalizada para armazenar
 * informações relacionadas a tickets e chat.
 * Esta classe contém arrays de objetos que podem ser utilizados para
 * armazenar tickets e mensagens de chat.
 */
@SuppressWarnings("unused")
@Getter
@Setter
public class Custom {

    /**
     * Array de tickets relacionados à organização ou sistema.
     */
    private Object[] tickets;

    /**
     * Array de mensagens de chat relacionadas à organização ou sistema.
     */
    private Object[] chat;
}