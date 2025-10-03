package io.github.marrafon91.estudos.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Table(name = "tb_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tb_id", unique = true, nullable = false)
    @EqualsAndHashCode.Include
    private UUID id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;

    private Cidade cidade;

    private Cliente cliente;
}
