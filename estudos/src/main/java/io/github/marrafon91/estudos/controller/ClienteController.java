package io.github.marrafon91.estudos.controller;

import io.github.marrafon91.estudos.entities.Cliente;
import io.github.marrafon91.estudos.repositories.ClienteRepositorio;
import io.github.marrafon91.estudos.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteRepositorio clienteRepositorio;

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = clienteRepositorio.save(cliente);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clienteSalvo.getId())
                .toUri();

        return ResponseEntity.created(location).body(clienteSalvo);
    }


    @GetMapping("{id}")
    public ResponseEntity<Cliente> obterPorId(@PathVariable("id") String id) {
        var clienteId = UUID.fromString(id);

        Cliente cliente = clienteService.obterPorId(clienteId);

        return ResponseEntity.ok(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> buscarTodos() {
        List<Cliente> lista = clienteRepositorio.findAll();
        return ResponseEntity.ok(lista);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") String id) {
        var catId = UUID.fromString(id);

        if (!clienteRepositorio.existsById(catId)) {
            return ResponseEntity.notFound().build();
        }

        clienteRepositorio.deleteById(catId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Cliente> atualizar(
            @PathVariable("id") UUID id,
            @RequestBody Cliente cliente) {

        return clienteRepositorio.findById(id)
                .map(clienteEncontrado -> {
                    clienteEncontrado.setNome(cliente.getNome());
                    clienteEncontrado.setEmail(cliente.getEmail());
                    clienteEncontrado.setCpfOuCnpj(cliente.getCpfOuCnpj());
                    clienteEncontrado.setTipo(cliente.getTipo());

                    clienteEncontrado.getTelefones().clear();
                    clienteEncontrado.getTelefones().addAll(cliente.getTelefones());

                    clienteEncontrado.getEnderecos().clear();
                    clienteEncontrado.getEnderecos().addAll(cliente.getEnderecos());

                    Cliente atualizado = clienteRepositorio.save(clienteEncontrado);
                    return ResponseEntity.ok(atualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
