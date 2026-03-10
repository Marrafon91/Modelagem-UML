package io.github.com.campeonato.dtos;

import io.github.com.campeonato.entities.Jogador;

import java.time.LocalDate;

public record JogadorDTO(
        Long id,
        String nome,
        String posicao,
        Integer numeroCamisa,
        LocalDate nascimento,
        Character genero,
        Double altura,
        TimeJogadoresDTO time
) {
    public JogadorDTO(Jogador entity) {
        this(
                entity.getId(),
                entity.getNome(),
                entity.getPosicao(),
                entity.getNumeroCamisa(),
                entity.getNascimento(),
                entity.getGenero(),
                entity.getAltura(),
                entity.getTime() != null ? new TimeJogadoresDTO(entity.getTime()) : null
        );
    }
}