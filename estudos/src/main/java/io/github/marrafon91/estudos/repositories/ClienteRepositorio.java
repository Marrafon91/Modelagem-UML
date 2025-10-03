package io.github.marrafon91.estudos.repositories;

import io.github.marrafon91.estudos.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepositorio extends JpaRepository<Cliente, UUID> {
}
