package io.github.com.campeonato.controllers;

import io.github.com.campeonato.dtos.EstadioDTO;
import io.github.com.campeonato.services.EstadioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<EstadioDTO> insert(
            @Valid @RequestBody EstadioDTO dto) {

        EstadioDTO newDto = service.insert(dto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newDto.id())
                .toUri();

        return ResponseEntity.created(uri).body(newDto);
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

