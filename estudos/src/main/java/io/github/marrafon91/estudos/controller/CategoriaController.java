package io.github.marrafon91.estudos.controller;

import io.github.marrafon91.estudos.entities.Categoria;
import io.github.marrafon91.estudos.repository.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @PostMapping
    public ResponseEntity<Categoria> criar(@RequestBody Categoria categoria) {
        Categoria salvar = categoriaRepositorio.save(categoria);
        return ResponseEntity.ok(salvar);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listar() {
        List<Categoria> lista = categoriaRepositorio.findAll();
        return ResponseEntity.ok(lista);
    }

}
