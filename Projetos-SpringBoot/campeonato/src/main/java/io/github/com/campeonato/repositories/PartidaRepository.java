package io.github.com.campeonato.repositories;

import io.github.com.campeonato.entities.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidaRepository extends JpaRepository<Partida,Long> {
}
