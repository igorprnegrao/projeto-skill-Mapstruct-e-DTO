package br.com.negraoipr.mapstruct.services;

import br.com.negraoipr.mapstruct.DTOs.PessoaMapper;
import br.com.negraoipr.mapstruct.DTOs.PessoaRequestDTO;
import br.com.negraoipr.mapstruct.DTOs.PessoaResponseDTO;
import br.com.negraoipr.mapstruct.entities.Pessoa;
import br.com.negraoipr.mapstruct.repositories.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository repository;
    private final PessoaMapper mapper;

    public PessoaResponseDTO salvar(PessoaRequestDTO dto){
        Pessoa pessoa = mapper.toEntity(dto);
        pessoa = repository.save(pessoa);
        return mapper.toDTO(pessoa);
    }

    /* Método para listar todas as pessoas */
    public List<PessoaResponseDTO> listar(){
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public PessoaResponseDTO atualizar(UUID id, PessoaRequestDTO dto){
        Pessoa pessoa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        Optional.ofNullable(dto.nome()).ifPresent(pessoa::setNome);
        Optional.ofNullable(dto.sobrenome()).ifPresent(pessoa::setSobrenome);
        Optional.ofNullable(dto.email()).ifPresent(pessoa::setEmail);
        Optional.ofNullable(dto.senha()).ifPresent(pessoa::setSenha);

        Pessoa pessoaSalva = repository.save(pessoa);

        return mapper.toDTO(pessoaSalva);
    }

    /* Método para deletar uma pessoa por ID */
    public void deletar(UUID id){
        Pessoa pessoa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com ID: " + id));

        repository.delete(pessoa);
    }
}
