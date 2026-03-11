package io.github.com.campeonato.repositories;

import io.github.com.campeonato.entities.Partida;
import io.github.com.campeonato.entities.enums.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PartidaRepository extends JpaRepository<Partida, Long> {

    // Buscar partidas por time mandante
    @Query("SELECT p FROM Partida p WHERE p.mandante = :time")
    List<Partida> findByMandante(@Param("time") Time time);

    // Buscar partidas por time visitante
    @Query("SELECT p FROM Partida p WHERE p.visitante = :time")
    List<Partida> findByVisitante(@Param("time") Time time);

    // Buscar partidas por campeonato
    @Query("SELECT p FROM Partida p WHERE p.campeonato.id = :campeonatoId")
    List<Partida> findByCampeonato(@Param("campeonatoId") Long campeonatoId);

    // Buscar partidas com fetch do estádio
    @Query("SELECT p FROM Partida p JOIN FETCH p.estadio WHERE p.id = :id")
    Partida findByIdWithEstadio(@Param("id") Long id);
}