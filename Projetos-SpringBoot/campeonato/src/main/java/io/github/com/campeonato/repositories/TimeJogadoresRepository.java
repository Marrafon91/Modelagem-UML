package io.github.com.campeonato.repositories;

import io.github.com.campeonato.entities.TimeJogadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TimeJogadoresRepository extends JpaRepository<TimeJogadores, Long> {

    // Buscar todos os times com jogadores carregados (evita N+1)
    @Query("SELECT DISTINCT t FROM TimeJogadores t LEFT JOIN FETCH t.jogadores")
    List<TimeJogadores> findAllWithJogadores();

    // Buscar time por nome com jogadores carregados (evita N+1)
    @Query("SELECT t FROM TimeJogadores t LEFT JOIN FETCH t.jogadores WHERE LOWER(t.nome) = LOWER(:nome)")
    Optional<TimeJogadores> findByNome(@Param("nome") String nome);

    // Buscar time por ID com jogadores carregados (evita N+1)
    @Query("SELECT t FROM TimeJogadores t LEFT JOIN FETCH t.jogadores WHERE t.id = :id")
    Optional<TimeJogadores> findByIdWithJogadores(@Param("id") Long id);
}