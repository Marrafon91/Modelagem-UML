package io.github.marrafon91.estudos.repositories;

import io.github.marrafon91.estudos.entities.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EstadoRepositorio extends JpaRepository<Estado, UUID> {
}
