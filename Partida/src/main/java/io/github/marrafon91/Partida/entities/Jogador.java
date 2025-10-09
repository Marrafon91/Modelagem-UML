package io.github.marrafon91.Partida.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "jogador")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "O campo 'nome' é obrigatório.")
    private String nome;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "O campo 'posicao' é obrigatório.")
    private String posicao;

    @Column(name = "numero_camisa", nullable = false)
    @NotNull(message = "O campo 'numeroCamisa' é obrigatório.")
    private Integer numeroCamisa;

    @Column(nullable = false)
    @NotNull(message = "O campo 'nascimento' é obrigatório.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    private LocalDate nascimento;

    @Column(nullable = false)
    @NotNull(message = "O campo 'genero' é obrigatório.")
    private Character genero;

    @Column(nullable = false)
    @NotNull(message = "O campo 'altura' é obrigatório.")
    private Double altura;

    @ManyToOne
    @JoinColumn(name = "time_id", nullable = false)
    @NotNull(message = "O campo 'time' é obrigatório.")
    private TimeJogadores time;

    @ManyToMany
    @JoinTable(
            name = "jogador_partida",
            joinColumns = @JoinColumn(name = "jogador_id"),
            inverseJoinColumns = @JoinColumn(name = "partida_id")
    )
    private List<Partida> partidas = new ArrayList<>();
}
