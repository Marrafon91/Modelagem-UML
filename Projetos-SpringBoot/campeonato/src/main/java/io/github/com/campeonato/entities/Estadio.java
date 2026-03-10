package io.github.com.campeonato.entities;

import java.util.Objects;

public class Estadio {

    private Long id;

    private String nome;
    private Endereco endereco;

    public Estadio() {
    }

    public Estadio(Long id, String nome, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Estadio estadio = (Estadio) o;
        return Objects.equals(id, estadio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
