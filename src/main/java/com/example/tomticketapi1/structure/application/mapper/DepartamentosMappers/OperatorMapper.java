package com.example.tomticketapi1.structure.application.mapper.DepartamentosMappers;

import com.example.tomticketapi1.structure.domain.entities.departamentos.Operator;
import com.example.tomticketapi1.structure.dto.entitiesDTO.departamentosDTO.OperatorDTO;

/**
 * Classe responsável por mapear entre {@link OperatorDTO} e {@link Operator}.
 */
public class OperatorMapper {

    /**
     * Converte um {@link OperatorDTO} para um objeto {@link Operator}.
     * Este método cria uma nova instância de {@link Operator} e mapeia
     * os campos do DTO correspondentes.
     *
     * @param operatorDTO Objeto de transferência de dados (DTO) que contém as informações do operador.
     * @return Um objeto {@link Operator} representando o operador,
     * ou {@code null} se o DTO for nulo.
     */
    public static Operator toDomain(OperatorDTO operatorDTO) {
        if (operatorDTO == null) {
            return null;
        }

        Operator operator = new Operator();
        operator.setId(operatorDTO.getId());
        operator.setName(operatorDTO.getName());
        operator.setMail_hash(operatorDTO.getMail_hash());

        return operator;
    }

    /**
     * Converte um objeto {@link Operator} para {@link OperatorDTO}.
     * Este método cria um novo {@code OperatorDTO} e mapeia
     * os campos do objeto de domínio correspondentes.
     *
     * @param operator Objeto que representa o operador.
     * @return Um objeto {@link OperatorDTO} com os valores mapeados,
     * ou {@code null} se o objeto de domínio for nulo.
     */
    public static OperatorDTO toDTO(Operator operator) {
        if (operator == null) {
            return null;
        }

        OperatorDTO operatorDTO = new OperatorDTO();
        operatorDTO.setId(operator.getId());
        operatorDTO.setName(operator.getName());
        operatorDTO.setMail_hash(operator.getMail_hash());

        return operatorDTO;
    }
}

