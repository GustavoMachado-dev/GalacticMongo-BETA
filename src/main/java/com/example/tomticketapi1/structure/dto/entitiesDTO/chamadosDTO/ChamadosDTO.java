package com.example.tomticketapi1.structure.dto.entitiesDTO.chamadosDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.ArrayList;

/**
 * A classe ChamadosDTO representa uma coleção de chamados.
 * Ela contém uma lista de chamados e informações relacionadas à
 * quantidade total de chamados e páginas.
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class ChamadosDTO {

    /** A lista de chamados contidos nesta instância. */
    private List<ChamadoDTO> data;

    /** O número total de chamados na coleção. */
    private int size;

    /** O número total de páginas disponíveis. */
    private int pages;

    /**
     * Construtor da classe ChamadosDTO.
     * Inicializa a lista de chamados para garantir que nunca seja nula.
     */
    public ChamadosDTO() {
        this.data = new ArrayList<>(); // Garante que 'data' nunca será nulo
    }

    /**
     * Verifica se a lista de chamados está vazia.
     *
     * @return true se a lista estiver vazia ou nula, caso contrário, false.
     */
    public boolean isEmpty() {
        return data == null || data.isEmpty();
    }

    /**
     * Adiciona um chamado à lista de chamados.
     *
     * @param chamadoDTO o chamado a ser adicionado.
     */
    public void addChamado(ChamadoDTO chamadoDTO) {
        data.add(chamadoDTO);
    }
}