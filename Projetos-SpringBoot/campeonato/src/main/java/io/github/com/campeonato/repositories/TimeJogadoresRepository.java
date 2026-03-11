package io.github.com.campeonato.repositories;

import io.github.com.campeonato.entities.TimeJogadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TimeJogadoresRepository extends JpaRepository<TimeJogadores, Long> {

    // Buscar time pelo nome
    @Query("SELECT t FROM TimeJogadores t WHERE LOWER(t.nome) = LOWER(:nome)")
    TimeJogadores findByNome(@Param("nome") String nome);
}