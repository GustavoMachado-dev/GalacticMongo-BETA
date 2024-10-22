package com.example.tomticketapi1.structure.application.mapper.ChamadosMappers;

import com.example.tomticketapi1.structure.application.mapper.ChamadosMappers.SubentitiesMappers.*;
import com.example.tomticketapi1.structure.application.mapper.DepartamentosMappers.CategoryMapper;
import com.example.tomticketapi1.structure.application.mapper.DepartamentosMappers.DepartmentMapper;
import com.example.tomticketapi1.structure.application.mapper.DepartamentosMappers.OperatorMapper;
import com.example.tomticketapi1.structure.application.mapper.DepartamentosMappers.StatusMapper;
import com.example.tomticketapi1.structure.domain.entities.chamados.Chamado;
import com.example.tomticketapi1.structure.dto.entitiesDTO.chamadosDTO.ChamadoDTO;

/**
 * Classe responsável por mapear entre o objeto de transferência de dados {@link ChamadoDTO}
 * e a entidade de domínio {@link Chamado}.
 */
public class ChamadoMapper {
    /**
     * Converte um {@link ChamadoDTO} para um objeto do domínio {@link Chamado}.
     * O método mapeia todos os campos do DTO para a entidade de domínio, incluindo
     * a conversão de subobjetos usando outros mapeadores.
     *
     * @param chamadoDTO Objeto de transferência de dados (DTO) que será convertido para a entidade de domínio.
     * @return Um objeto {@link Chamado} com os valores mapeados do {@code chamadoDTO}.
     */
    public static Chamado toDomain(ChamadoDTO chamadoDTO) {
        Chamado chamadoDomain = new Chamado();
        chamadoDomain.setId(chamadoDTO.getId());
        chamadoDomain.setProtocol(chamadoDTO.getProtocol());
        chamadoDomain.setSubject(chamadoDTO.getSubject());
        chamadoDomain.setMessage(chamadoDTO.getMessage());
        chamadoDomain.setMimetype(chamadoDTO.getMimetype());
        chamadoDomain.setPriority(chamadoDTO.getPriority());
        chamadoDomain.setTicketType(chamadoDTO.getTicketType());
        chamadoDomain.setWork_time(chamadoDTO.getWork_time());
        chamadoDomain.setElapsed_time(chamadoDTO.getElapsed_time());
        chamadoDomain.setCreation_date(chamadoDTO.getCreation_date());
        chamadoDomain.setFirst_reply_date(chamadoDTO.getFirst_reply_date());
        chamadoDomain.setEnd_date(chamadoDTO.getEnd_date());
        chamadoDomain.setParent_ticket_id(chamadoDTO.getParent_ticket_id());
        chamadoDomain.setSchedule_date(chamadoDTO.getSchedule_date());
        chamadoDomain.setCostumer(CostumerMapper.toDomain(chamadoDTO.getCostumer()));
        chamadoDomain.setSla(SlaMapper.toDomain(chamadoDTO.getSla()));
        chamadoDomain.setCost(CostMapper.toDomain(chamadoDTO.getCost()));
        chamadoDomain.setEvaluation(EvaluationMapper.toDomain(chamadoDTO.getEvaluation()));
        chamadoDomain.setSituation(SituationMapper.toDomain(chamadoDTO.getSituation()));
        chamadoDomain.setCategory(CategoryMapper.toDomain(chamadoDTO.getCategory()));
        chamadoDomain.setDepartment(DepartmentMapper.toDomain(chamadoDTO.getDepartment()));
        chamadoDomain.setOperator(OperatorMapper.toDomain(chamadoDTO.getOperator()));
        chamadoDomain.setStatus(StatusMapper.toDomain(chamadoDTO.getStatus()));
        return chamadoDomain;
    }
}
