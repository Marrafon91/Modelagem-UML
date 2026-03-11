package io.github.com.campeonato.repositories;

import io.github.com.campeonato.entities.Estadio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EstadioRepository extends JpaRepository<Estadio, Long> {

    // Buscar estádio pelo nome
    @Query("SELECT e FROM Estadio e WHERE LOWER(e.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    Estadio findByNome(@Param("nome") String nome);
}