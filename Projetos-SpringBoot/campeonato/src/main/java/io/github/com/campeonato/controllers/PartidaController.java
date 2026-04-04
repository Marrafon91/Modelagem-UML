package io.github.com.campeonato.controllers;

import io.github.com.campeonato.dtos.PartidaInsertDTO;
import io.github.com.campeonato.dtos.PartidaMinDTO;
import io.github.com.campeonato.services.PartidaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/partidas")
@Tag(name = "Partidas", description = "Controle de Partidas")
public class PartidaController {

    @Autowired
    private PartidaService service;

    @Operation(description = "Todas as Partidas", summary = "Lista de todas as  Partidas", responses = {
            @ApiResponse(description = "OK", responseCode = "200")
    })
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<PartidaMinDTO>> findAll(){
        List<PartidaMinDTO> result = service.findAll();
        return ResponseEntity.ok().body(result);
    }

    @Operation(description = "Partidas por ID", summary = "Encontre as Partidas por ID", responses = {
            @ApiResponse(description = "OK", responseCode = "200"),
            @ApiResponse(description = "Not Found", responseCode = "404")
    })
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<PartidaMinDTO> findById(@PathVariable Long id){
        PartidaMinDTO result = service.findById(id);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping
    public ResponseEntity<PartidaInsertDTO> insert(@Valid @RequestBody PartidaInsertDTO dto) {
        PartidaInsertDTO result = service.insert(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.id())
                .toUri();
        return ResponseEntity.created(location).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PartidaMinDTO> update(@PathVariable Long id, @Valid @RequestBody PartidaMinDTO dto) {
        PartidaMinDTO result = service.update(id, dto);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
