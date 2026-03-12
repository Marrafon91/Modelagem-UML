package io.github.com.campeonato.dtos;

import io.github.com.campeonato.entities.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record EnderecoDTO(
        Long id,

        @NotBlank(message = "Logradouro não pode ser vazio")
        @Size(min = 3, max = 50, message = "Logradouro deve ter entre 3 e 50 caracteres")
        String logradouro,

        @NotNull(message = "Número não pode ser nulo")
        Integer numero,

        @NotBlank(message = "Complemento não pode ser vazio")
        @Size(min = 10, max = 100, message = "Complemento deve ter entre 10 e 100 caracteres")
        String complemento,

        @NotBlank(message = "Bairro não pode ser vazio")
        @Size(min = 3, max = 50, message = "Bairro deve ter entre 3 e 50 caracteres")
        String bairro,

        @NotBlank(message = "Cidade não pode ser vazia")
        @Size(min = 3, max = 50, message = "Cidade deve ter entre 3 e 50 caracteres")
        String cidade,

        @NotBlank(message = "Estado não pode ser vazio")
        @Size(min = 2, max = 2, message = "Estado deve ter exatamente 2 caracteres")
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