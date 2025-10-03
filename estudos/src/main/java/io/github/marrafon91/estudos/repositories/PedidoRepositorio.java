package io.github.marrafon91.estudos.repositories;

import io.github.marrafon91.estudos.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidoRepositorio extends JpaRepository<Pedido, UUID> {
}
