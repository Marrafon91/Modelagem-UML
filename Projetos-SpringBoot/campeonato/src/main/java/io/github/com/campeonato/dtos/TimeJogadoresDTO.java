package io.github.com.campeonato.dtos;

import io.github.com.campeonato.entities.TimeJogadores;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TimeJogadoresDTO(
        Long id,
        @NotBlank(message = "Nome não pode ser vazio")
        @Size(min = 3, max = 50, message = "Nome deve ter entre 3 e 50 caracteres")
        String nome
) {
    public TimeJogadoresDTO(TimeJogadores entity) {
        this(
                entity.getId(),
                entity.getNome()
        );
    }
}