package io.github.com.campeonato.dtos;

import io.github.com.campeonato.entities.Jogador;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record JogadorDTO(
        Long id,

        @NotBlank(message = "Campo nome deve ter entre 3 e 50 caracteres")
        @Size(min = 3, max = 50)
        String nome,

        @NotBlank(message = "Campo posicao deve ter entre 3 e 50 caracteres")
        @Size(min = 3, max = 50)
        String posicao,

        @NotNull(message = "Numero da camisa não pode ser nulo")
        @Positive(message = "Não pode ser numero negativo")
        @Size(min = 1, max = 2)
        Integer numeroCamisa,

        @Past(message = "Data deve ser passada")
        LocalDate nascimento,
        @Size(min = 1, max = 1,message = "Apenas 1 Caractere")
        Character genero,

        @NotNull(message = "Altura invalida")
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