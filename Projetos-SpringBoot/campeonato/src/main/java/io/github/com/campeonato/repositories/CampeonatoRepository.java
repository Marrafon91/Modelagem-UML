package io.github.com.campeonato.repositories;

import io.github.com.campeonato.entities.Campeonato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampeonatoRepository extends JpaRepository<Campeonato,Long> {
}
