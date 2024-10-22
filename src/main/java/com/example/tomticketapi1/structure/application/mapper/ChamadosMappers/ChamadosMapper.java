package com.example.tomticketapi1.structure.application.mapper.ChamadosMappers;

import com.example.tomticketapi1.structure.domain.entities.chamados.*;
import com.example.tomticketapi1.structure.dto.entitiesDTO.chamadosDTO.*;

import java.util.stream.Collectors;
/**
 * Classe responsável por mapear entre o objeto de transferência de dados {@link ChamadosDTO}
 * e a entidade de domínio {@link Chamados}.
 */
@SuppressWarnings("unused")
public class ChamadosMapper {
    /**
     * Converte um {@link ChamadosDTO} para um objeto do domínio {@link Chamados}.
     * O método mapeia os campos do DTO, incluindo o tamanho e o número de páginas,
     * além de converter a lista de {@link ChamadoDTO} para a lista de {@link Chamado}
     * usando o {@link ChamadoMapper}.
     *
     * @param chamadosDTO Objeto de transferência de dados (DTO) que será convertido para a entidade de domínio.
     * @return Um objeto {@link Chamados} com os valores mapeados do {@code chamadosDTO}.
     */
    public static Chamados toDomain(ChamadosDTO chamadosDTO) {
        Chamados chamadosDomain = new Chamados();
        chamadosDomain.setSize(chamadosDTO.getSize());
        chamadosDomain.setPages(chamadosDTO.getPages());

        // Mapeia a lista de ChamadoDTO para Chamado
        if (chamadosDTO.getData() != null) {
            chamadosDomain.setData(
                    chamadosDTO.getData().stream()
                            .map(ChamadoMapper::toDomain)  // Usa o ChamadoMapper para mapear cada ChamadoDTO
                            .collect(Collectors.toList())
            );
        }

        return chamadosDomain;
    }
}
