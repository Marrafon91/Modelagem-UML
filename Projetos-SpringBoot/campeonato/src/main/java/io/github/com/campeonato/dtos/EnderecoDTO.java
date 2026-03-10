package io.github.com.campeonato.dtos;

import io.github.com.campeonato.entities.Endereco;

public record EnderecoDTO(
        Long id,
        String logradouro,
        Integer numero,
        String complemento,
        String bairro,
        String cidade,
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