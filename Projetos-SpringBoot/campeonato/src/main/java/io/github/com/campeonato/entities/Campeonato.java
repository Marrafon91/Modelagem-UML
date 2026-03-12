package io.github.com.campeonato.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_campeonato")
public class Campeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ano", nullable = false)
    private Integer ano;

    @Column(name = "nome_do_campeonato", nullable = false, length = 100)
    private String nome;

    @OneToMany(mappedBy = "campeonato", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Partida> partidas = new HashSet<>();

    public Campeonato() {
    }

    public Campeonato(Long id, Integer ano, String nome, Set<Partida> partidas) {
        this.id = id;
        this.ano = ano;
        this.nome = nome;
        this.partidas = partidas;
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

    public void addPartida(Partida partida) {
        partidas.add(partida);
        partida.setCampeonato(this);
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
