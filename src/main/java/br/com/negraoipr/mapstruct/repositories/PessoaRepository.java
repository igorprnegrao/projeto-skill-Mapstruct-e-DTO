package br.com.negraoipr.mapstruct.repositories;

import br.com.negraoipr.mapstruct.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {
}
