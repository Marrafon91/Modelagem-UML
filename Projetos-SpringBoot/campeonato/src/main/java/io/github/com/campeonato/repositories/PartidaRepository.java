package io.github.com.campeonato.repositories;

import io.github.com.campeonato.entities.Partida;
import io.github.com.campeonato.entities.enums.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PartidaRepository extends JpaRepository<Partida, Long> {

    // Buscar todas as partidas com estadio carregado (evita N+1)
    @Query("SELECT DISTINCT p FROM Partida p JOIN FETCH p.estadio")
    List<Partida> findAllWithEstadio();

    // Buscar partidas por time mandante com estadio carregado (evita N+1)
    @Query("SELECT p FROM Partida p JOIN FETCH p.estadio WHERE p.mandante = :time")
    List<Partida> findByMandante(@Param("time") Time time);

    // Buscar partidas por time visitante com estadio carregado (evita N+1)
    @Query("SELECT p FROM Partida p JOIN FETCH p.estadio WHERE p.visitante = :time")
    List<Partida> findByVisitante(@Param("time") Time time);

    // Buscar partidas por campeonato com estadio carregado (evita N+1)
    @Query("SELECT p FROM Partida p JOIN FETCH p.estadio WHERE p.campeonato.id = :campeonatoId")
    List<Partida> findByCampeonato(@Param("campeonatoId") Long campeonatoId);

    // Buscar partida por ID com estadio e campeonato carregados (evita N+1)
    @Query("SELECT p FROM Partida p JOIN FETCH p.estadio LEFT JOIN FETCH p.campeonato WHERE p.id = :id")
    Optional<Partida> findByIdWithEstadio(@Param("id") Long id);
}