package io.github.marrafon91.estudos.controller;

import io.github.marrafon91.estudos.entities.Categoria;
import io.github.marrafon91.estudos.repositories.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @PostMapping
    public ResponseEntity<Void> criar(@RequestBody Categoria categoria) {
        Categoria salvar = categoriaRepositorio.save(categoria);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(salvar.getId())
                .toUri();
        return ResponseEntity.created(location).build();

    }

    @GetMapping("{id}")
    public ResponseEntity<Categoria> obterPorId(@PathVariable("id") String id) {
        var categoriaId = UUID.fromString(id);
        return categoriaRepositorio.findById(categoriaId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> bascarTodos() {
        List<Categoria> lista = categoriaRepositorio.findAll();
        return ResponseEntity.ok(lista);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") String id) {
        var catId = UUID.fromString(id);

        if (!categoriaRepositorio.existsById(catId)) {
            return ResponseEntity.notFound().build();
        }

        categoriaRepositorio.deleteById(catId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Categoria> atualizar(
            @PathVariable("id")
            String id,
            @RequestBody Categoria categoria) {

        var catId = UUID.fromString(id);
        Optional<Categoria> attId = categoriaRepositorio.findById(catId);

        if (attId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var idExistente = attId.get();
        idExistente.setNome(categoria.getNome());

        categoriaRepositorio.save(idExistente);
        return ResponseEntity.ok().body(idExistente);
    }
}
