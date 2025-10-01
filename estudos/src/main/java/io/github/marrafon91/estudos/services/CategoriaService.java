package io.github.marrafon91.estudos.services;

import io.github.marrafon91.estudos.entities.Categoria;
import io.github.marrafon91.estudos.repositories.CategoriaRepositorio;
import io.github.marrafon91.estudos.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepositorio repositorio;

    public Categoria obterPorId(UUID id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(
                        "Objeto não encontrado Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }
}
