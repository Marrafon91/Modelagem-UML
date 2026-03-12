package io.github.com.campeonato.dtos;

import io.github.com.campeonato.entities.Estadio;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record EstadioDTO(
        Long id,

        @NotBlank(message = "Nome não pode ser vazio")
        @Size(min = 3, max = 50, message = "Nome deve ter entre 3 e 50 caracteres")
        String nome,

        @NotNull(message = "Endereço não pode ser nulo")
        EnderecoDTO endereco
) {
    public EstadioDTO(Estadio entity) {
        this(
                entity.getId(),
                entity.getNome(),
                entity.getEndereco() != null ? new EnderecoDTO(entity.getEndereco()) : null
        );
    }
}