package io.github.marrafon91.estudos.repositories;

import io.github.marrafon91.estudos.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnderecoRepositorio extends JpaRepository<Endereco, UUID> {
}
