package com.example.tomticketapi1.structure.application.mapper.ChamadosMappers.SubentitiesMappers;

import com.example.tomticketapi1.structure.domain.entities.chamados.subentities.Evaluation;
import com.example.tomticketapi1.structure.dto.entitiesDTO.chamadosDTO.subentities.EvaluationDTO;

/**
 * Classe responsável por mapear entre o objeto de domínio {@link Evaluation}
 * e o objeto de transferência de dados {@link EvaluationDTO}.
 * Contém métodos para converter do DTO para o domínio e vice-versa.
 */
public class EvaluationMapper {

    /**
     * Converte um {@link EvaluationDTO} para um objeto do domínio {@link Evaluation}.
     * Se o {@code evaluationDTO} fornecido for nulo, o método retorna {@code null}.
     *
     * @param evaluationDTO Objeto de transferência de dados (DTO) que será convertido para a entidade de domínio.
     * @return Um objeto {@link Evaluation} com os valores mapeados do {@code evaluationDTO}, ou {@code null} se o DTO for nulo.
     */
    public static Evaluation toDomain(EvaluationDTO evaluationDTO) {
        if (evaluationDTO == null) {
            return null;
        }

        Evaluation evaluation = new Evaluation();
        evaluation.setProblem_solved(evaluationDTO.isProblem_solved());
        evaluation.setGrade(evaluationDTO.getGrade());
        evaluation.setComment(evaluationDTO.getComment());

        return evaluation;
    }

    /**
     * Converte um objeto de domínio {@link Evaluation} para um {@link EvaluationDTO}.
     * Se o {@code evaluation} fornecido for nulo, o método retorna {@code null}.
     *
     * @param evaluation Objeto de domínio que será convertido para DTO.
     * @return Um objeto {@link EvaluationDTO} com os valores mapeados do {@code evaluation}, ou {@code null} se o domínio for nulo.
     */
    public static EvaluationDTO toDTO(Evaluation evaluation) {
        if (evaluation == null) {
            return null;
        }

        EvaluationDTO evaluationDTO = new EvaluationDTO();
        evaluationDTO.setProblem_solved(evaluation.isProblem_solved());
        evaluationDTO.setGrade(evaluation.getGrade());
        evaluationDTO.setComment(evaluation.getComment());

        return evaluationDTO;
    }
}
