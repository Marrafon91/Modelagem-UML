package io.github.marrafon91.Partida.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.marrafon91.Partida.entities.enums.Time;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Table(name = "partida")
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    @Column(nullable = false, unique = true)
    private Long id;

    @NotNull(message = "O campo 'data' é obrigatório.")
    @Column(name = "data", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    private LocalDate data;

    @NotNull(message = "O campo 'mandante' é obrigatório.")
    @Enumerated(EnumType.STRING)
    @Column(name = "mandante", length = 50, nullable = false)
    private Time mandante;

    @NotNull(message = "O campo 'visitante' é obrigatório.")
    @Enumerated(EnumType.STRING)
    @Column(name = "visitante", length = 50, nullable = false)
    private Time visitante;

    @Column(name = "pontuacao_mandante")
    private Integer pontuacaoMandante;

    @Column(name = "pontuacao_visitante")
    private Integer pontuacaoVisitante;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "campeonato_id")
    private  Campeonato campeonato;
}
