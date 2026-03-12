package io.github.com.campeonato.dtos;

import io.github.com.campeonato.entities.Partida;
import io.github.com.campeonato.entities.enums.Time;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public record PartidaDTOSemJogadores(
        Long id,

        @FutureOrPresent(message = "Data deve ser uma data futura ou presente")
        LocalDate data,

        @NotNull(message = "Mandante não pode ser nulo")
        Time mandante,
        @NotNull(message = "Visitante não pode ser nulo")
        Time visitante,
        @NotNull(message = "Pontuação do mandante não pode ser nula")
        @PositiveOrZero(message = "Pontuação do mandante deve ser um valor positivo ou zero")
        Integer pontuacaoMandante,
        @NotNull(message = "Pontuação do visitante não pode ser nula")
        @PositiveOrZero(message = "Pontuação do visitante deve ser um valor positivo ou zero")
        Integer pontuacaoVisitante,

        CampeonatoDTOSimplified campeonato,

        EstadioDTO estadio
) {
    public PartidaDTOSemJogadores(Partida entity) {
        this(
                entity.getId(),
                entity.getData(),
                entity.getMandante(),
                entity.getVisitante(),
                entity.getPontuacaoMandante(),
                entity.getPontuacaoVisitante(),
                entity.getCampeonato() != null ? new CampeonatoDTOSimplified(entity.getCampeonato()) : null,
                entity.getEstadio() != null ? new EstadioDTO(entity.getEstadio()) : null
        );
    }
}

