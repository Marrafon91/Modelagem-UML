package io.github.com.campeonato.repositories;

import io.github.com.campeonato.entities.Estadio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EstadioRepository extends JpaRepository<Estadio, Long> {

    // Buscar todos os estádios com endereco carregado (evita N+1)
    @Query("SELECT DISTINCT e FROM Estadio e JOIN FETCH e.endereco")
    List<Estadio> findAllWithEndereco();

    // Buscar estádio por ID com endereco carregado
    @Query("SELECT e FROM Estadio e JOIN FETCH e.endereco WHERE e.id = :id")
    Optional<Estadio> findByIdWithEndereco(@Param("id") Long id);

    // Buscar estádio pelo nome
    @Query("SELECT e FROM Estadio e WHERE LOWER(e.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    Estadio findByNome(@Param("nome") String nome);
}