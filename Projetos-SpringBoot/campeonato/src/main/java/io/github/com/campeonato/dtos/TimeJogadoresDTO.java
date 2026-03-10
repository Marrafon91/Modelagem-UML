package io.github.com.campeonato.dtos;

import io.github.com.campeonato.entities.TimeJogadores;

public record TimeJogadoresDTO(
        Long id,
        String nome
) {
    public TimeJogadoresDTO(TimeJogadores entity) {
        this(
                entity.getId(),
                entity.getNome()
        );
    }
}