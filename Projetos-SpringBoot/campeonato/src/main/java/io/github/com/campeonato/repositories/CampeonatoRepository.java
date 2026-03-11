package io.github.com.campeonato.repositories;

import io.github.com.campeonato.entities.Campeonato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CampeonatoRepository extends JpaRepository<Campeonato, Long> {

    // Buscar campeonato por nome (contendo algo)
    @Query("SELECT c FROM Campeonato c WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Campeonato> findByNomeContaining(@Param("nome") String nome);

    // Buscar campeonatos a partir de um ano específico
    @Query("SELECT c FROM Campeonato c WHERE c.ano >= :ano")
    List<Campeonato> findByAnoGreaterThanEqual(@Param("ano") Integer ano);

    // Buscar campeonato com suas partidas (fetch join)
    @Query("SELECT c FROM Campeonato c LEFT JOIN FETCH c.partidas WHERE c.id = :id")
    Campeonato findByIdWithPartidas(@Param("id") Long id);
}