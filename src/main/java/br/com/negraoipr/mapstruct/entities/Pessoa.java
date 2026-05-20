package br.com.negraoipr.mapstruct.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "pessoa")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "sobrenome", nullable = false)
    private String sobrenome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Pessoa pessoa)) return false;

        return getId().equals(pessoa.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
