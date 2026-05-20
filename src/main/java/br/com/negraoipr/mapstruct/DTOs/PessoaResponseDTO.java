package br.com.negraoipr.mapstruct.DTOs;

public record PessoaResponseDTO(
        String id,
        String nome,
        String sobrenome,
        String email
) {
}
