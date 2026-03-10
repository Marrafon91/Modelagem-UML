package io.github.com.campeonato.repositories;

import io.github.com.campeonato.entities.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador,Long> {
}
