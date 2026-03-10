package io.github.com.campeonato.dtos;

import io.github.com.campeonato.entities.Estadio;

public record EstadioDTO(
        Long id,
        String nome,
        EnderecoDTO endereco
) {
    public EstadioDTO(Estadio entity) {
        this(
                entity.getId(),
                entity.getNome(),
                entity.getEndereco() != null ? new EnderecoDTO(entity.getEndereco()) : null
        );
    }
}