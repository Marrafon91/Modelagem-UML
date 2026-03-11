package io.github.com.campeonato.controllers;

import io.github.com.campeonato.dtos.EstadioDTO;
import io.github.com.campeonato.services.EstadioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estadio")
public class EstadioController {

    @Autowired
    private EstadioService service;

    @GetMapping
    public ResponseEntity<List<EstadioDTO>> findAll() {
        List<EstadioDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadioDTO> findById(@PathVariable Long id) {
        EstadioDTO estadio = service.findById(id);
        return ResponseEntity.ok().body(estadio);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<EstadioDTO> findByNome(@PathVariable String nome) {
        EstadioDTO estadio = service.findByNome(nome);
        return ResponseEntity.ok().body(estadio);
    }

    @PostMapping
    public ResponseEntity<EstadioDTO> save(@Valid @RequestBody EstadioDTO dto) {
        EstadioDTO savedEstadio = service.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEstadio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadioDTO> update(@PathVariable Long id, @Valid @RequestBody EstadioDTO dto) {
        EstadioDTO updatedEstadio = service.update(id, dto);
        return ResponseEntity.ok().body(updatedEstadio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

