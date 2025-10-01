package io.github.marrafon91.estudos.repositories;

import io.github.marrafon91.estudos.entities.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CidadeRepositorio extends JpaRepository<Cidade, UUID> {
}
