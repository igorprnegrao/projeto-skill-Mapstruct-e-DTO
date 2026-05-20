package br.com.negraoipr.mapstruct.DTOs;

import jakarta.validation.constraints.NotBlank;

public record PessoaRequestDTO(
        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotBlank(message = "Sobrenome é obrigatório")
        String sobrenome,

        @NotBlank(message = "Email é obrigatório")
        String email,

        @NotBlank(message = "Senha é obrigatória")
        String senha

) {
}
