package com.example.tomticketapi1.structure.domain.repositories;

import com.example.tomticketapi1.structure.domain.entities.chamados.Chamado;
import org.springframework.http.ResponseEntity;

/**
 * A interface ExternalApiClient define as operações para interagir
 * com uma API externa para obter dados de chamados.
 */
@SuppressWarnings("unused")
public interface ExternalApiClient {

    /**
     * Busca um conjunto de chamados a partir de uma API externa.
     *
     * @param page Número da página a ser buscada, usado para
     *             a paginação dos resultados.
     * @return Um objeto ResponseEntity contendo um array de chamados
     *         e o status da resposta da API.
     */
    ResponseEntity<Chamado[]> fetchChamados(int page);
}