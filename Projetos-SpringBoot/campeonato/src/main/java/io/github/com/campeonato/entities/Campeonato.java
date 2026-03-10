package io.github.com.campeonato.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Campeonato {

    private Long id;
    private Integer ano;
    private String nome;

    private Set<Partida> partidas = new HashSet<>();

    public Campeonato() {
    }

    public Campeonato(Long id, Integer ano, String nome) {
        this.id = id;
        this.ano = ano;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Partida> getPartidas() {
        return partidas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Campeonato that = (Campeonato) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
