package com.example.tomticketapi1.structure.application.gateway;

import com.example.tomticketapi1.structure.dto.entitiesDTO.chamadosDTO.ChamadosDTO;

/**
 * Interface que define o contrato para a integração com a API de chamados do Tom Ticket.
 * Esta interface contém os métodos necessários para capturar a primeira página de chamados,
 * obter chamados por data e realizar atualizações de chamados.
 *
 * @see ChamadosDTO
 */
public interface TomTicketChamadosApiGateway {

    /**
     * Obtém a primeira página de chamados da API do Tom Ticket.
     *
     * @return ChamadosDTO contendo os dados da primeira página de chamados.
     */
    ChamadosDTO getChamadosAPIFirstPage();

    /**
     * Obtém os chamados criados em um intervalo de datas específico a partir da API.
     *
     * @return ChamadosDTO contendo os dados dos chamados capturados por data.
     */
    ChamadosDTO getChamadosByData();

    /**
     * Atualiza os chamados armazenados a partir da API do Tom Ticket.
     *
     * @return ChamadosDTO contendo os dados atualizados dos chamados.
     */
    ChamadosDTO updateChamados();

    ChamadosDTO fastUpdateChamados();
}