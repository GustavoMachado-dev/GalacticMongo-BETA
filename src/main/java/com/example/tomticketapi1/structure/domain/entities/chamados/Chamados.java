package com.example.tomticketapi1.structure.domain.entities.chamados;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Classe que representa uma coleção de chamados.
 * Esta classe contém uma lista de chamados, além de informações sobre o tamanho
 * da lista e o número de páginas disponíveis.
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class Chamados {

    /**
     * Lista de chamados.
     */
    private List<Chamado> data;

    /**
     * Tamanho da lista de chamados.
     */
    private int size;

    /**
     * Número total de páginas disponíveis para a lista de chamados.
     */
    private int pages;

    /**
     * Verifica se a lista de chamados está vazia.
     *
     * @return true se a lista estiver vazia ou nula, caso contrário false.
     */
    public boolean isEmpty() {
        return data == null || data.isEmpty();
    }
}