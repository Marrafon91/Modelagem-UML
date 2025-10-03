package io.github.marrafon91.estudos.entities;

import io.github.marrafon91.estudos.entities.enums.EstadoPagamento;
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
@Table(name = "pagamento")
public class Pagamento {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @EqualsAndHashCode.Include
    private UUID id;

    private EstadoPagamento estado;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    @MapsId
    private Pedido pedido;
}
