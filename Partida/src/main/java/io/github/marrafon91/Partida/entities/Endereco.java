package io.github.marrafon91.Partida.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "endereco")
public class Endereco {

    @Id
    @SequenceGenerator(name = "endereco_seq", sequenceName = "endereco_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(name = "logradouro", length = 150, nullable = false)
    @NotBlank
    @Size(max = 150)
    private String logradouro;

    @Column(name = "numero", nullable = false)
    @NotNull
    private Integer numero;

    @Column(name = "complemento", length = 100)
    @NotBlank
    @Size(max = 100)
    private String complemento;

    @Column(name = "bairro", length = 100, nullable = false)
    @NotBlank
    @Size(max = 100)
    private String bairro;

    @Column(name = "cidade", length = 100, nullable = false)
    @NotBlank
    @Size(max = 100)
    private String cidade;

    @Column(name = "estado", length = 2, nullable = false)
    @NotBlank
    @Size(max = 2, min = 2)
    private String estado;

    @OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
    private Estadio estadio;
}
