package com.example.tomticketapi1.structure.domain.services;

import com.example.tomticketapi1.structure.application.gateway.TomTicketChamadosApiGateway;
import com.example.tomticketapi1.structure.dto.entitiesDTO.chamadosDTO.ChamadosDTO;
import com.example.tomticketapi1.structure.dto.entitiesDTO.classesDTO.CustomDateDTO;
import com.example.tomticketapi1.structure.infraestructure.config.TomToken;
import com.example.tomticketapi1.structure.logs.logservices.WriteInTxtLoggerDocument;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * A classe ChamadosServices implementa a interface TomTicketChamadosApiGateway e é responsável
 * por interagir com a API TomTicket para gerenciar operações relacionadas a chamados.
 * Esta classe utiliza o RestTemplate para realizar chamadas HTTP e o WriteInTxtLoggerDocument
 * para registrar logs das operações realizadas.
 */
@Service
public class ChamadosServices implements TomTicketChamadosApiGateway {

    private final RestTemplate restTemplate;
    private final String accessKey = new TomToken().getApiKey();
    private final WriteInTxtLoggerDocument loggerTxtWriter = new WriteInTxtLoggerDocument();

    /**
     * Construtor da classe ChamadosServices.
     *
     * @param restTemplate O RestTemplate utilizado para realizar chamadas HTTP.
     */
    public ChamadosServices(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Obtém a primeira página de chamados da API TomTicket.
     *
     * @return Um objeto ChamadosDTO contendo a lista de chamados obtidos.
     * @throws RuntimeException Se a chamada à API falhar.
     */
    @Override
    public ChamadosDTO getChamadosAPIFirstPage() {
        String url = "https://api.tomticket.com/v2.0/ticket/list";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        loggerTxtWriter.logMessage("[METHOD CALLED] : getChamadosAPIFirstPage() called.");

        ResponseEntity<ChamadosDTO> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                ChamadosDTO.class
        );

        ChamadosDTO responseBody = response.getBody();
        if (response.getStatusCode() == HttpStatus.OK && responseBody != null) {
            loggerTxtWriter.logMessage("[SUCCESS] : getChamadosAPIFirstPage() successfully retrieved data.");
            return responseBody;
        } else {
            String logMessage = "[ERROR] : getChamadosAPIFirstPage() failed with status " + response.getStatusCode();
            loggerTxtWriter.logMessage(logMessage);
            throw new RuntimeException("Falha ao obter os dados da API: " + response.getStatusCode());
        }
    }

    /**
     * Obtém chamados filtrados pela data.
     *
     * @return Um objeto ChamadosDTO contendo a lista de chamados filtrados.
     */
    @Override
    public ChamadosDTO getChamadosByData() {
        return processChamadosPages(new CustomDateDTO(2));
    }

    /**
     * Atualiza os chamados filtrando pela data atual.
     *
     * @return Um objeto ChamadosDTO contendo a lista de chamados atualizados.
     */
    @Override
    public ChamadosDTO updateChamados() {
        return processChamadosPages(new CustomDateDTO(1));
    }

    /**
     * Processa as páginas de chamados a partir de uma data formatada.
     *
     * @param customDateDTOFormatedRequest O objeto CustomDateDTO contendo a data para filtrar os chamados.
     * @return Um objeto ChamadosDTO contendo a lista de chamados processados.
     * @throws RuntimeException Se ocorrer um erro ao obter as páginas da API.
     */
    private ChamadosDTO processChamadosPages(CustomDateDTO customDateDTOFormatedRequest) {
        String urlAux = "https://api.tomticket.com/v2.0/ticket/list";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ChamadosDTO chamadosDTOList = new ChamadosDTO();

        loggerTxtWriter.logMessage("[METHOD CALLED] : processChamadosPages() called with date filter.");

        ResponseEntity<ChamadosDTO> response = restTemplate.exchange(
                urlAux.concat("?creation_date_ge=" + customDateDTOFormatedRequest.getFormattedDate()),
                HttpMethod.GET,
                entity,
                ChamadosDTO.class
        );

        ChamadosDTO responseBody = response.getBody();
        if (responseBody == null || responseBody.getPages() == 0) {
            loggerTxtWriter.logMessage("[ERROR] : Response body or pages is null.");
            throw new RuntimeException("Falha ao obter as páginas da API.");
        }

        int pagesToUploadRequest = responseBody.getPages();
        loggerTxtWriter.logMessage("[INFO] : Found " + pagesToUploadRequest + " pages to process.");

        for (int i = 1; i <= pagesToUploadRequest; i++) {
            try {
                ResponseEntity<ChamadosDTO> responseAux_Page = restTemplate.exchange(
                        urlAux.concat("?page=" + i),
                        HttpMethod.GET,
                        entity,
                        ChamadosDTO.class
                );

                if (responseAux_Page.getBody() != null && responseAux_Page.getBody().getData() != null) {
                    chamadosDTOList.getData().addAll(responseAux_Page.getBody().getData());
                }
                Thread.sleep(200);  // Pausa para evitar sobrecarga de requisições
            } catch (InterruptedException e) {
                loggerTxtWriter.logMessage("[ERROR] : Thread interrupted during page " + i + " processing.");
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread interrupted", e);
            }
        }

        loggerTxtWriter.logMessage("[SUCCESS] : processChamadosPages() successfully retrieved and processed all pages.");
        return chamadosDTOList;
    }

    /**
     * Atualiza rapidamente os chamados, limitando a quantidade de páginas processadas.
     *
     * @return Um objeto ChamadosDTO contendo a lista de chamados atualizados.
     */
    @Override
    public ChamadosDTO fastUpdateChamados() {
        final int pagesUpdateFixed = 20;
        String urlAux = "https://api.tomticket.com/v2.0/ticket/list";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ChamadosDTO chamadosDTOList = new ChamadosDTO();

        loggerTxtWriter.logMessage("[METHOD CALLED] : fastUpdateChamados() called with date filter.");

        for (int i = 1; i <= pagesUpdateFixed; i++) {
            try {
                ResponseEntity<ChamadosDTO> responseAux_Page = restTemplate.exchange(
                        urlAux.concat("?page=" + i),
                        HttpMethod.GET,
                        entity,
                        ChamadosDTO.class
                );

                if (responseAux_Page.getBody() != null && responseAux_Page.getBody().getData() != null) {
                    chamadosDTOList.getData().addAll(responseAux_Page.getBody().getData());
                }
                Thread.sleep(200);  // Pausa para evitar sobrecarga de requisições
            } catch (InterruptedException e) {
                loggerTxtWriter.logMessage("[ERROR] : Thread interrupted during page " + i + " processing.");
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread interrupted", e);
            }
        }

        loggerTxtWriter.logMessage("[SUCCESS] : processChamadosPages() successfully retrieved and processed all pages.");
        return chamadosDTOList;
    }
}