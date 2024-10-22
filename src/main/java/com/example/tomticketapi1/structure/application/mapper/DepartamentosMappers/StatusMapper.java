package com.example.tomticketapi1.structure.application.mapper.DepartamentosMappers;

import com.example.tomticketapi1.structure.domain.entities.departamentos.Status;
import com.example.tomticketapi1.structure.dto.entitiesDTO.departamentosDTO.StatusDTO;

/**
 * Classe responsável por mapear entre {@link StatusDTO} e {@link Status}.
 */
public class StatusMapper {

    /**
     * Converte um {@link StatusDTO} para um objeto {@link Status}.
     * Este método cria uma nova instância de {@link Status} e mapeia
     * os campos do DTO correspondentes.
     *
     * @param statusDTO Objeto de transferência de dados (DTO) que contém as informações do status.
     * @return Um objeto {@link Status} representando o status,
     * ou {@code null} se o DTO for nulo.
     */
    public static Status toDomain(StatusDTO statusDTO) {
        if (statusDTO == null) {
            return null;
        }

        Status status = new Status();
        status.setId(statusDTO.getId());
        status.setDescription(statusDTO.getDescription());
        status.setApply_date(statusDTO.getApply_date());

        return status;
    }

    /**
     * Converte um objeto {@link Status} para {@link StatusDTO}.
     * Este método cria um novo {@code StatusDTO} e mapeia
     * os campos do objeto de domínio correspondentes.
     *
     * @param status Objeto que representa o status.
     * @return Um objeto {@link StatusDTO} com os valores mapeados,
     * ou {@code null} se o objeto de domínio for nulo.
     */
    public static StatusDTO toDTO(Status status) {
        if (status == null) {
            return null;
        }

        StatusDTO statusDTO = new StatusDTO();
        statusDTO.setId(status.getId());
        statusDTO.setDescription(status.getDescription());
        statusDTO.setApply_date(status.getApply_date()); // Corrigido para usar status.getApply_date()

        return statusDTO;
    }
}
