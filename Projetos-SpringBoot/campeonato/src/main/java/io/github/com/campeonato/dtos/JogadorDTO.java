package io.github.com.campeonato.dtos;

import io.github.com.campeonato.entities.Jogador;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record JogadorDTO(
        Long id,

        @NotBlank(message = "Nome não pode ser vazio")
        @Size(min = 3, max = 50, message = "Nome deve ter entre 3 e 50 caracteres")
        String nome,

        @NotBlank(message = "Posição não pode ser vazia")
        @Size(min = 3, max = 50, message = "Posição deve ter entre 3 e 50 caracteres")
        String posicao,

        @NotNull(message = "Número da camisa não pode ser nulo")
        @Min(value = 1, message = "Número da camisa deve ser no mínimo 1")
        @Max(value = 99, message = "Número da camisa deve ser no máximo 99")
        Integer numeroCamisa,

        @NotNull(message = "Data de nascimento não pode ser nula")
        @Past(message = "Data de nascimento deve ser no passado")
        LocalDate nascimento,

        @NotNull(message = "Gênero não pode ser nulo")
        @Size(min = 1, max = 1, message = "Gênero deve ter exatamente 1 caractere")
        Character genero,

        @NotNull(message = "Altura não pode ser nula")
        @Positive(message = "Altura deve ser um valor positivo")
        Double altura,

        TimeJogadoresDTO time
) {
    public JogadorDTO(Jogador entity) {
        this(
                entity.getId(),
                entity.getNome(),
                entity.getPosicao(),
                entity.getNumeroCamisa(),
                entity.getNascimento(),
                entity.getGenero(),
                entity.getAltura(),
                entity.getTime() != null ? new TimeJogadoresDTO(entity.getTime()) : null
        );
    }
}