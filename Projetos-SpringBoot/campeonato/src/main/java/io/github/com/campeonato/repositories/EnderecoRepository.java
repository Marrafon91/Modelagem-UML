package io.github.com.campeonato.repositories;

import io.github.com.campeonato.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco,Long> {
}
