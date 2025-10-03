package io.github.marrafon91.estudos.services;

import io.github.marrafon91.estudos.entities.Cliente;
import io.github.marrafon91.estudos.repositories.ClienteRepositorio;
import io.github.marrafon91.estudos.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepositorio repositorio;

    public Cliente obterPorId(UUID id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(
                        "Objeto não encontrado Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }
}
