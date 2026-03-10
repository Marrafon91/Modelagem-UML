package io.github.com.campeonato.dtos;

import io.github.com.campeonato.entities.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record EnderecoDTO(
        Long id,

        @NotBlank(message = "Campo logradouro deve ter entre 3 e 50 caracteres")
        @Size(min = 3, max = 50)
        String logradouro,

        @NotNull(message = "Numero não pode ser nulo")
        Integer numero,

        @NotBlank(message = "Campo logradouro deve ter entre 10 e 100 caracteres")
        @Size(min = 10, max = 100)
        String complemento,

        @NotBlank(message = "Campo bairro deve ter entre 3 e 50 caracteres")
        @Size(min = 3, max = 50)
        String bairro,

        @NotBlank(message = "Campo cidade deve ter entre 3 e 50 caracteres")
        @Size(min = 3, max = 50)
        String cidade,

        @NotBlank(message = "Campo estado deve ter entre 2")
        @Size(min = 2, max = 2)
        String estado
) {
    public EnderecoDTO(Endereco entity) {
        this(
                entity.getId(),
                entity.getLogradouro(),
                entity.getNumero(),
                entity.getComplemento(),
                entity.getBairro(),
                entity.getCidade(),
                entity.getEstado()
        );
    }
}