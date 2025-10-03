package io.github.marrafon91.estudos.controller;

import io.github.marrafon91.estudos.entities.Pedido;
import io.github.marrafon91.estudos.repositories.PedidoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoRepositorio pedidoRepositorio;

    @PostMapping
    public ResponseEntity<Void> criarPedido(@RequestBody Pedido pedido) {
        if (pedido.getInstante() == null) {
            pedido.setInstante(java.time.Instant.now());
        }

        Pedido salvarPedido = pedidoRepositorio.save(pedido);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(salvarPedido.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> buscarPedidos() {
        List<Pedido> listaPedidos = pedidoRepositorio.findAll();
        return ResponseEntity.ok(listaPedidos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Pedido> pedidosPorId(@PathVariable("id") UUID id) {
       return pedidoRepositorio.findById(id)
               .map(ResponseEntity::ok)
               .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable("id") UUID id) {

        if (!pedidoRepositorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        pedidoRepositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Pedido> attPedido(
            @PathVariable("id") UUID id,
            @RequestBody Pedido pedido) {

        return pedidoRepositorio.findById(id)
                .map(pedidoEncontrado -> {
                    pedidoEncontrado.setPagamento(pedido.getPagamento());
                    pedidoEncontrado.setCliente(pedido.getCliente());
                    pedidoEncontrado.setEnderecoDeEntrega(pedido.getEnderecoDeEntrega());
                    pedidoEncontrado.setItens(pedido.getItens());
                    Pedido atualizado = pedidoRepositorio.save(pedidoEncontrado);
                    return ResponseEntity.ok(atualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
