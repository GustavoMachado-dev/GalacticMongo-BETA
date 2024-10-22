package com.example.tomticketapi1.structure.application.mapper.ClassesMappers.SubclassesMappers;

import com.example.tomticketapi1.structure.domain.entities.classes.subclasses.Startup;
import com.example.tomticketapi1.structure.dto.entitiesDTO.classesDTO.subclasses.StartupDTO;

/**
 * Classe responsável por mapear entre o objeto de transferência de dados {@link StartupDTO}
 * e a entidade de domínio {@link Startup}.
 */
public class StartupMapper {

    /**
     * Converte um {@link StartupDTO} para um objeto do domínio {@link Startup}.
     * Este método verifica se o {@code startupDTO} é nulo antes de realizar o mapeamento
     * e define a data da entidade {@link Startup} com base no DTO.
     *
     * @param startupDTO Objeto de transferência de dados (DTO) que será convertido para a entidade de domínio.
     * @return Um objeto {@link Startup} com os valores mapeados do {@code startupDTO} ou {@code null} se o DTO for nulo.
     */
    public static Startup toDomain(StartupDTO startupDTO) {
        if (startupDTO == null) {
            return null;
        }

        Startup startup = new Startup();
        startup.setDate(startupDTO.getDate());

        return startup;
    }
}


