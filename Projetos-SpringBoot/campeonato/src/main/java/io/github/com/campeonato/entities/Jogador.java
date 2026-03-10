package io.github.com.campeonato.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_jogador")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 50)
    private String posicao;

    @Column(name = "numero_camisa")
    private Integer numeroCamisa;

    @Column(nullable = false)
    private LocalDate nascimento;

    @Column(length = 1)
    private Character genero;

    private Double altura;

    @ManyToOne
    @JoinColumn(name = "time_id", nullable = false)
    private TimeJogadores time;

    @ManyToMany
    @JoinTable(
            name = "jogador_partida",
            joinColumns = @JoinColumn(name = "jogador_id"),
            inverseJoinColumns = @JoinColumn(name = "partida_id")
    )
    private Set<Partida> partidas = new HashSet<>();

    public Jogador() {
    }

    public Jogador(Long id, String nome, String posicao, Integer numeroCamisa, LocalDate nascimento,
                   Character genero, Double altura, TimeJogadores time) {
        this.id = id;
        this.nome = nome;
        this.posicao = posicao;
        this.numeroCamisa = numeroCamisa;
        this.nascimento = nascimento;
        this.genero = genero;
        this.altura = altura;
        this.time = time;
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

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public Integer getNumeroCamisa() {
        return numeroCamisa;
    }

    public void setNumeroCamisa(Integer numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public TimeJogadores getTime() {
        return time;
    }

    public void setTime(TimeJogadores time) {
        this.time = time;
    }

    public Set<Partida> getPartidas() {
        return partidas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogador jogador = (Jogador) o;
        return Objects.equals(id, jogador.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}