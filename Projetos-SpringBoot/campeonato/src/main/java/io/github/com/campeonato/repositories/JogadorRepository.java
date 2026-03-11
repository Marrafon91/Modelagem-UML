package io.github.com.campeonato.repositories;

import io.github.com.campeonato.entities.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {

    // Buscar jogadores por nome
    @Query("SELECT j FROM Jogador j WHERE LOWER(j.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Jogador> findByNome(@Param("nome") String nome);

    // Buscar jogadores por time
    @Query("SELECT j FROM Jogador j WHERE j.time.nome = :time")
    List<Jogador> findByTime(@Param("time") String time);
}