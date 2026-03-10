package io.github.com.campeonato.entities;

import io.github.com.campeonato.entities.enums.Time;

import java.util.HashSet;
import java.util.Set;

public class TimeJogadores {

    private Long id;

    private Time time;

    private Set<Jogador> jogadores = new HashSet<>();
}
