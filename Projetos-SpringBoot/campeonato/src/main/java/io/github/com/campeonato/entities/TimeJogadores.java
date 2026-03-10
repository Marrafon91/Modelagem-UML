package io.github.com.campeonato.entities;

import io.github.com.campeonato.entities.enums.Time;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_time_jogadores")
public class TimeJogadores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "time")
    private Set<Jogador> jogadores = new HashSet<>();

    public TimeJogadores() {
    }

    public TimeJogadores(Long id, String nome, Set<Jogador> jogadores) {
        this.id = id;
        this.nome = nome;
        this.jogadores = jogadores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
