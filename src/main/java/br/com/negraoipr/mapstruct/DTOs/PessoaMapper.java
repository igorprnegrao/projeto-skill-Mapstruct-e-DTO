package br.com.negraoipr.mapstruct.DTOs;

import br.com.negraoipr.mapstruct.entities.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapeador responsável por converter entre a entidade Pessoa
 * e seus respectivos DTOs (Data Transfer Objects)
 */
@Mapper(componentModel = "spring")
public interface PessoaMapper {

    /* Converte um PessoaRequestDTO para a entidade Pessoa */
    @Mapping(target = "id", ignore = true)
    Pessoa toEntity(PessoaRequestDTO dto);

    /* Converte uma entidade Pessoa para PessoaResponseDTO */
    PessoaResponseDTO toDTO(Pessoa pessoa);
}
