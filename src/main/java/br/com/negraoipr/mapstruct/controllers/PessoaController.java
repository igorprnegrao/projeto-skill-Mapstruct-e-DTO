package br.com.negraoipr.mapstruct.controllers;

import br.com.negraoipr.mapstruct.DTOs.PessoaRequestDTO;
import br.com.negraoipr.mapstruct.DTOs.PessoaResponseDTO;
import br.com.negraoipr.mapstruct.services.PessoaService;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pessoas")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService service;

    @PostMapping
    ResponseEntity<PessoaResponseDTO> criar(@Valid @RequestBody PessoaRequestDTO data){
        PessoaResponseDTO response = service.salvar(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    ResponseEntity<List<PessoaResponseDTO>> listar(){
        List<PessoaResponseDTO> response = service.listar();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    ResponseEntity<PessoaResponseDTO> atualizar(@PathVariable UUID id, @RequestBody PessoaRequestDTO data){
        PessoaResponseDTO response = service.atualizar(id, data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletar(@PathVariable UUID id){
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
