package io.github.marrafon91.estudos.services;

import io.github.marrafon91.estudos.entities.Pedido;
import io.github.marrafon91.estudos.repositories.PedidoRepositorio;
import io.github.marrafon91.estudos.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepositorio repositorio;

    public Pedido obterPorId(UUID id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(
                        "Objeto não encontrado Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }
}
