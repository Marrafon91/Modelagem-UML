package io.github.marrafon91.estudos.repositories;

import io.github.marrafon91.estudos.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepositorio extends JpaRepository<Produto, UUID> {
}
