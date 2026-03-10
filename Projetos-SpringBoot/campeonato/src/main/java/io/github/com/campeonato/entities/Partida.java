package io.github.com.campeonato.entities;

import io.github.com.campeonato.entities.enums.Time;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Partida {
    private Long id;
    private LocalDate data;
    private Time mandante;
    private Time visitante;

    private Integer pontuacaoMandante;
    private Integer pontuacaoVisitante;

    private Estadio estadio;

    private Set<Jogador> jogadores = new HashSet<>();
}
