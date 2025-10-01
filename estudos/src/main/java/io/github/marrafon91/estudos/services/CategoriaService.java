package io.github.marrafon91.estudos.services;

import io.github.marrafon91.estudos.entities.Categoria;
import io.github.marrafon91.estudos.repositories.CategoriaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepositorio repositorio;

    public Optional<Categoria> obterPorId(UUID id) {
        return repositorio.findById(id);
    }
}
