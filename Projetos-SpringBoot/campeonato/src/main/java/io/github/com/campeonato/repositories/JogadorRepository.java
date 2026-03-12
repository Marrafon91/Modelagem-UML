package io.github.com.campeonato.repositories;

import io.github.com.campeonato.entities.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {

    // Buscar todos os jogadores com time carregado (evita N+1)
    @Query("SELECT DISTINCT j FROM Jogador j JOIN FETCH j.time")
    List<Jogador> findAllWithTime();

    // Buscar jogadores por nome com time carregado (evita N+1)
    @Query("SELECT j FROM Jogador j JOIN FETCH j.time WHERE LOWER(j.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Jogador> findByNome(@Param("nome") String nome);

    // Buscar jogadores por time com time carregado (evita N+1)
    @Query("SELECT j FROM Jogador j JOIN FETCH j.time WHERE LOWER(j.time.nome) = LOWER(:time)")
    List<Jogador> findByTime(@Param("time") String time);

    // Buscar jogador por ID com time carregado (evita N+1)
    @Query("SELECT j FROM Jogador j JOIN FETCH j.time WHERE j.id = :id")
    Optional<Jogador> findByIdWithTime(@Param("id") Long id);
}