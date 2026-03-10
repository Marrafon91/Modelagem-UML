package io.github.com.campeonato.entities;

import java.time.LocalDate;

public class Jogador {

    private Long id;
    private String nome;
    private String posicao;
    private Integer numeroCamisa;
    private LocalDate nascimento;
    private Character genero;
    private Double altura;

    private TimeJogadores time;
}
