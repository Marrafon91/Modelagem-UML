package io.github.com.campeonato.dtos;

import io.github.com.campeonato.entities.Partida;

import java.util.List;

public record CampeonatoDTO(
        Long id,
        Integer ano,
        String nome,
        List<Partida> partidas) {
}
