package com.example.tomticketapi1.structure.application.mapper.ClassesMappers;


import com.example.tomticketapi1.structure.domain.entities.classes.Organization;
import com.example.tomticketapi1.structure.dto.entitiesDTO.classesDTO.OrganizationDTO;

/**
 * Classe responsável por mapear entre {@link OrganizationDTO} e {@link Organization}.
 */
public class OrganizationMapper {

    /**
     * Converte um {@link OrganizationDTO} para um objeto {@link Organization}.
     * Este método verifica se o {@code organizationDTO} é nulo antes de criar
     * e retornar uma nova instância de {@link Organization}.
     *
     * @param organizationDTO Objeto de transferência de dados (DTO) que contém os dados da organização.
     * @return Um objeto {@link Organization} representando a organização, ou {@code null} se o DTO for nulo.
     */
    public static Organization toDomain(OrganizationDTO organizationDTO) {
        if (organizationDTO == null) {
            return null;
        }
        Organization organization = new Organization();

        organization.setId(organizationDTO.getId());
        organization.setNome(organizationDTO.getNome());

        return organization;
    }

    /**
     * Converte um objeto {@link Organization} para {@link OrganizationDTO}.
     * Este método cria um novo {@code OrganizationDTO} e mapeia os atributos
     * do objeto de domínio {@code organization}.
     *
     * @param organization Objeto de domínio que será convertido para o DTO.
     * @return Um objeto {@link OrganizationDTO} com os valores mapeados da organização,
     * ou {@code null} se a organização for nula.
     */
    public static OrganizationDTO toDTO(Organization organization) {
        if (organization == null) {
            return null;
        }
        OrganizationDTO organizationDTO = new OrganizationDTO();
        organizationDTO.setId(organization.getId());
        organizationDTO.setNome(organization.getNome());

        return organizationDTO;
    }
}
