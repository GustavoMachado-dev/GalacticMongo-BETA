package com.example.tomticketapi1.structure.application.mapper.DepartamentosMappers;

import com.example.tomticketapi1.structure.domain.entities.departamentos.Custom;
import com.example.tomticketapi1.structure.dto.entitiesDTO.departamentosDTO.CustomDTO;

/**
 * Classe responsável por mapear entre {@link CustomDTO} e {@link Custom}.
 */
@SuppressWarnings("unused")
public class CustomMapper {
    /**
     * Converte um {@link CustomDTO} para um objeto {@link Custom}.
     * Este método verifica se o {@code customDTO} é nulo antes de criar
     * e retornar uma nova instância de {@link Custom}.
     *
     * @param customDTO Objeto de transferência de dados (DTO) que contém os dados personalizados.
     * @return Um objeto {@link Custom} representando os dados personalizados,
     * ou {@code null} se o DTO for nulo.
     */
    public static Custom toDomain(CustomDTO customDTO) {
        if (customDTO == null) {
            return null;
        }

        Custom custom = new Custom();
        custom.setTickets(customDTO.getTickets());
        custom.setChat(customDTO.getChat());

        return custom;
    }

    /**
     * Converte um objeto {@link Custom} para {@link CustomDTO}.
     * Este método cria um novo {@code CustomDTO} e mapeia os atributos
     * do objeto de domínio {@code custom}.
     *
     * @param custom Objeto de domínio que será convertido para o DTO.
     * @return Um objeto {@link CustomDTO} com os valores mapeados,
     * ou {@code null} se o objeto de domínio for nulo.
     */
    public static CustomDTO toDTO(Custom custom) {
        if (custom == null) {
            return null;
        }

        CustomDTO customDTO = new CustomDTO();
        customDTO.setTickets(custom.getTickets());
        customDTO.setChat(custom.getChat());

        return customDTO;
    }
}
