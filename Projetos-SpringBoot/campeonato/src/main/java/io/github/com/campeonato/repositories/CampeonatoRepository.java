package io.github.com.campeonato.repositories;

import io.github.com.campeonato.entities.Campeonato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CampeonatoRepository extends JpaRepository<Campeonato, Long> {

    // Buscar todos os campeonatos com partidas carregadas (evita N+1)
    @Query("SELECT DISTINCT c FROM Campeonato c LEFT JOIN FETCH c.partidas p LEFT JOIN FETCH p.estadio e LEFT JOIN FETCH e.endereco LEFT JOIN FETCH p.jogadores")
    List<Campeonato> findAllWithPartidas();

    // Buscar campeonato por nome com partidas carregadas (evita N+1)
    @Query("SELECT DISTINCT c FROM Campeonato c LEFT JOIN FETCH c.partidas p LEFT JOIN FETCH p.estadio e LEFT JOIN FETCH e.endereco LEFT JOIN FETCH p.jogadores WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    Page<Campeonato> findByNomeContaining(@Param("nome") String nome,  Pageable pageable);

    // Buscar campeonatos a partir de um ano com partidas carregadas (evita N+1)
    @Query("SELECT DISTINCT c FROM Campeonato c LEFT JOIN FETCH c.partidas p LEFT JOIN FETCH p.estadio e LEFT JOIN FETCH e.endereco LEFT JOIN FETCH p.jogadores WHERE c.ano >= :ano")
    List<Campeonato> findByAnoGreaterThanEqual(@Param("ano") Integer ano);

    // Buscar campeonato por ID com suas partidas (fetch join)
    @Query("SELECT c FROM Campeonato c LEFT JOIN FETCH c.partidas p LEFT JOIN FETCH p.estadio e LEFT JOIN FETCH e.endereco LEFT JOIN FETCH p.jogadores WHERE c.id = :id")
    Optional<Campeonato> findByIdWithPartidas(@Param("id") Long id);

    // Buscar partidas paginadas de um campeonato com estadio carregado (evita N+1)
    @Query("SELECT DISTINCT p FROM Partida p LEFT JOIN FETCH p.estadio e LEFT JOIN FETCH e.endereco WHERE LOWER(p.campeonato.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    Page<io.github.com.campeonato.entities.Partida> findPartidasByCampeonatoNomeContaining(@Param("nome") String nome, Pageable pageable);
}