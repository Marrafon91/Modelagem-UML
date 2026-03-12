package io.github.com.campeonato.dtos;

import io.github.com.campeonato.entities.Campeonato;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.domain.Page;

public record CampeonatoComPartidasPageDTO(
        Long id,
        @NotNull(message = "Ano não pode ser nulo")
        Integer ano,

        @NotBlank(message = "Nome não pode ser vazio")
        @Size(min = 3, max = 50, message = "Nome deve ter entre 3 e 50 caracteres")
        String nome,
        Page<PartidaMinDTO> partidas
) {
    public CampeonatoComPartidasPageDTO(Campeonato entity, Page<PartidaMinDTO> partidas) {
        this(
                entity.getId(),
                entity.getAno(),
                entity.getNome(),
                partidas
        );
    }
}



