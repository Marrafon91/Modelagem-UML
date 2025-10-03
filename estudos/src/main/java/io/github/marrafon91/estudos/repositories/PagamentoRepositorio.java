package io.github.marrafon91.estudos.repositories;

import io.github.marrafon91.estudos.entities.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PagamentoRepositorio extends JpaRepository<Pagamento, UUID> {
}
