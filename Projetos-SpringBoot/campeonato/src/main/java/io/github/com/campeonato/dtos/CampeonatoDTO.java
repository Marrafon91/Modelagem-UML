package io.github.com.campeonato.dtos;

import io.github.com.campeonato.entities.Campeonato;

import java.util.Set;
import java.util.stream.Collectors;

public record CampeonatoDTO(
        Long id,
        Integer ano,
        String nome,
        Set<PartidaDTO> partidas
) {
    public CampeonatoDTO(Campeonato entity) {
        this(
                entity.getId(),
                entity.getAno(),
                entity.getNome(),
                entity.getPartidas()
                        .stream()
                        .map(PartidaDTO::new)
                        .collect(Collectors.toSet())
        );
    }
}