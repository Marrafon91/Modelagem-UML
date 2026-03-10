package io.github.com.campeonato.entities;

import io.github.com.campeonato.entities.enums.Time;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
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

    public Partida() {
    }

    public Partida(Long id, LocalDate data, Time mandante, Time visitante, Integer pontuacaoMandante, Integer pontuacaoVisitante, Estadio estadio) {
        this.id = id;
        this.data = data;
        this.mandante = mandante;
        this.visitante = visitante;
        this.pontuacaoMandante = pontuacaoMandante;
        this.pontuacaoVisitante = pontuacaoVisitante;
        this.estadio = estadio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Time getMandante() {
        return mandante;
    }

    public void setMandante(Time mandante) {
        this.mandante = mandante;
    }

    public Time getVisitante() {
        return visitante;
    }

    public void setVisitante(Time visitante) {
        this.visitante = visitante;
    }

    public Integer getPontuacaoMandante() {
        return pontuacaoMandante;
    }

    public void setPontuacaoMandante(Integer pontuacaoMandante) {
        this.pontuacaoMandante = pontuacaoMandante;
    }

    public Integer getPontuacaoVisitante() {
        return pontuacaoVisitante;
    }

    public void setPontuacaoVisitante(Integer pontuacaoVisitante) {
        this.pontuacaoVisitante = pontuacaoVisitante;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public Set<Jogador> getJogadores() {
        return jogadores;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Partida partida = (Partida) o;
        return Objects.equals(id, partida.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
