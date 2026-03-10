package io.github.com.campeonato.dtos;

import io.github.com.campeonato.entities.Partida;
import io.github.com.campeonato.entities.enums.Time;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public record PartidaDTO(
        Long id,
        LocalDate data,
        Time mandante,
        Time visitante,
        Integer pontuacaoMandante,
        Integer pontuacaoVisitante,
        CampeonatoDTO campeonato,
        EstadioDTO estadio,
        Set<JogadorDTO> jogadores
) {
    public PartidaDTO(Partida entity) {
        this(
                entity.getId(),
                entity.getData(),
                entity.getMandante(),
                entity.getVisitante(),
                entity.getPontuacaoMandante(),
                entity.getPontuacaoVisitante(),
                entity.getCampeonato() != null ? new CampeonatoDTO(entity.getCampeonato()) : null,
                entity.getEstadio() != null ? new EstadioDTO(entity.getEstadio()) : null,
                entity.getJogadores()
                        .stream()
                        .map(JogadorDTO::new)
                        .collect(Collectors.toSet())
        );
    }
}