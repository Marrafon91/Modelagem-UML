package io.github.marrafon91.estudos.repositories;

import io.github.marrafon91.estudos.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriaRepositorio  extends JpaRepository<Categoria, UUID> {
}
