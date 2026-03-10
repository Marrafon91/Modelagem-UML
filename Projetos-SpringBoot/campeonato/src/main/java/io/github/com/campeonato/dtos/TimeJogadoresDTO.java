package io.github.com.campeonato.dtos;

import io.github.com.campeonato.entities.TimeJogadores;
import jakarta.validation.constraints.NotBlank;

public record TimeJogadoresDTO(
        Long id,
        @NotBlank(message = "Não pode ser um nome nulo")
        String nome
) {
    public TimeJogadoresDTO(TimeJogadores entity) {
        this(
                entity.getId(),
                entity.getNome()
        );
    }
}