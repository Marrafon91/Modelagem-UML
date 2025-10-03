package io.github.marrafon91.estudos.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    @EqualsAndHashCode.Include
    private UUID id;
    private Date instante;

    private Pagamento pagamento;

    private Cliente cliente;

    private Endereco enderecoDeEntrega;
}
