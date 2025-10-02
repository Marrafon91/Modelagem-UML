package io.github.marrafon91.estudos.controller;

import io.github.marrafon91.estudos.entities.Produto;
import io.github.marrafon91.estudos.repositories.ProdutoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoRepositorio produtoRepositorio;

    @PostMapping
    public ResponseEntity<Void> criarProduto(@RequestBody Produto produto) {
        Produto salvarProduto = produtoRepositorio.save(produto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(salvarProduto.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<Produto>> buscarProdutos() {
        List<Produto> listaProdutos = produtoRepositorio.findAll();
        return ResponseEntity.ok(listaProdutos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Produto> produtosPorId(@PathVariable("id") UUID id) {
       return produtoRepositorio.findById(id)
               .map(ResponseEntity::ok)
               .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable("id") UUID id) {

        if (!produtoRepositorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        produtoRepositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Produto> attProduto(
            @PathVariable("id") UUID id,
            @RequestBody Produto produto) {

        return produtoRepositorio.findById(id)
                .map(produtoEncontrado -> {
                    produtoEncontrado.setNome(produto.getNome());
                    produtoEncontrado.setPreco(produto.getPreco());
                    Produto atualizado = produtoRepositorio.save(produtoEncontrado);
                    return ResponseEntity.ok(atualizado);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
