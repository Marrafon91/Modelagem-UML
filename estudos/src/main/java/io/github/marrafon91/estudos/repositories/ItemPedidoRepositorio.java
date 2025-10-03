package io.github.marrafon91.estudos.repositories;

import io.github.marrafon91.estudos.entities.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemPedidoRepositorio extends JpaRepository<ItemPedido, UUID> {
}
