package io.github.com.campeonato.entities;

import io.github.com.campeonato.entities.enums.Time;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TimeJogadores {

    private Long id;

    private Time time;

    private Set<Jogador> jogadores = new HashSet<>();

    public TimeJogadores() {
    }

    public TimeJogadores(Long id, Time time) {
        this.id = id;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Set<Jogador> getJogadores() {
        return jogadores;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        TimeJogadores that = (TimeJogadores) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
