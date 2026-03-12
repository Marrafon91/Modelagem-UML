package io.github.com.campeonato.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.com.campeonato.entities.enums.Time;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_partida")
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @JsonFormat( pattern = "yyyy-MM-dd")
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private Time mandante;

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private Time visitante;

    @Column(name = "pontuacao_mandante")
    private Integer pontuacaoMandante;

    @Column(name = "pontuacao_visitante")
    private Integer pontuacaoVisitante;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "campeonato_id")
    private Campeonato campeonato;

    @ManyToOne
    @JoinColumn(name = "estadio_id", nullable = false)
    private Estadio estadio;

    @ManyToMany(mappedBy = "partidas")
    private Set<Jogador> jogadores = new HashSet<>();

    public Partida() {
    }

    public Partida(Long id, LocalDate data, Time mandante, Time visitante, Integer pontuacaoMandante, Integer pontuacaoVisitante, Campeonato campeonato, Estadio estadio, Set<Jogador> jogadores) {
        this.id = id;
        this.data = data;
        this.mandante = mandante;
        this.visitante = visitante;
        this.pontuacaoMandante = pontuacaoMandante;
        this.pontuacaoVisitante = pontuacaoVisitante;
        this.campeonato = campeonato;
        this.estadio = estadio;
        this.jogadores = jogadores;
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

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
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

    public void addJogador(Jogador jogador) {
        jogadores.add(jogador);
        jogador.getPartidas().add(this);
    }

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
