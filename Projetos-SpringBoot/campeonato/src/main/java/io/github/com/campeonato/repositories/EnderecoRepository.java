package io.github.com.campeonato.repositories;

import io.github.com.campeonato.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    // Buscar endereço por logradouro
    @Query("SELECT e FROM Endereco e WHERE LOWER(e.logradouro) LIKE LOWER(CONCAT('%', :logradouro, '%'))")
    List<Endereco> findByLogradouro(@Param("logradouro") String logradouro);

    // Buscar endereço por cidade (unnacent nao funciona no H2 apenas no PostgreSQL)
    @Query("SELECT e FROM Endereco e WHERE LOWER(e.cidade) LIKE LOWER(CONCAT('%', :cidade, '%'))")
    List<Endereco> findByCidade(@Param("cidade") String cidade);

    // Buscar endereço por bairro
    @Query("SELECT e FROM Endereco e WHERE LOWER(e.bairro) LIKE LOWER(CONCAT('%', :bairro, '%'))")
    List<Endereco> findByBairro(@Param("bairro") String bairro);
}