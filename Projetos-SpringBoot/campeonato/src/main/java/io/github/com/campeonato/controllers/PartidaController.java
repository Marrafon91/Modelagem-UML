package io.github.com.campeonato.controllers;

import io.github.com.campeonato.dtos.PartidaDTO;
import io.github.com.campeonato.dtos.PartidaInsertDTO;
import io.github.com.campeonato.dtos.PartidaMinDTO;
import io.github.com.campeonato.services.PartidaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/partidas")
public class PartidaController {

    @Autowired
    private PartidaService service;

    @GetMapping
    public ResponseEntity<List<PartidaMinDTO>> findAll(){
        List<PartidaMinDTO> result = service.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartidaMinDTO> findById(@PathVariable Long id){
        PartidaMinDTO result = service.findById(id);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping
    public ResponseEntity<PartidaInsertDTO> insert(@Valid @RequestBody PartidaInsertDTO dto) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.id())
                .toUri();
        PartidaInsertDTO result = service.insert(dto);
        return ResponseEntity.created(location).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartidaMinDTO> update(@PathVariable Long id, @Valid @RequestBody PartidaMinDTO dto) {
        PartidaMinDTO result = service.update(id, dto);
        return ResponseEntity.ok().body(result);
    }
}
