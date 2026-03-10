package io.github.com.campeonato.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Jogador {

    private Long id;
    private String nome;
    private String posicao;
    private Integer numeroCamisa;
    private LocalDate nascimento;
    private Character genero;
    private Double altura;

    private TimeJogadores time;

    public Jogador() {
    }

    public Jogador(Long id, String nome, String posicao, Integer numeroCamisa, LocalDate nascimento, Character genero, Double altura, TimeJogadores time) {
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Jogador jogador = (Jogador) o;
        return Objects.equals(id, jogador.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
