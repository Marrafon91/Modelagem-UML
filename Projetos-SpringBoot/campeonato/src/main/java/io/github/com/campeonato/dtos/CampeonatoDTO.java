package io.github.com.campeonato.dtos;

import io.github.com.campeonato.entities.Campeonato;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;
import java.util.stream.Collectors;

public record CampeonatoDTO(
        Long id,
        @NotNull(message = "Ano não pode ser nulo")
        Integer ano,

        @NotBlank(message = "Campo nome deve ter entre 3 e 50 caracteres")
        @Size(min = 3, max = 50)
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