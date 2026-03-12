package io.github.com.campeonato.dtos;

import io.github.com.campeonato.entities.Campeonato;

// DTO simplificado para evitar ciclo infinito de referências
public record CampeonatoMinDTO(
        Long id,
        Integer ano,
        String nome
) {
    public CampeonatoMinDTO(Campeonato entity) {
        this(
                entity.getId(),
                entity.getAno(),
                entity.getNome()
        );
    }
}
