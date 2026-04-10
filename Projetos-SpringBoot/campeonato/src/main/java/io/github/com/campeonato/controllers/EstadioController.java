package io.github.com.campeonato.controllers;

import io.github.com.campeonato.dtos.EstadioDTO;
import io.github.com.campeonato.services.EstadioService;
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
@RequestMapping("/estadio")
@Tag(name = "Estadio", description = "Estadio das partidas")
public class EstadioController {

    @Autowired
    private EstadioService service;

    @Operation(description = "Estadios", summary = "Todos os Estadios", responses = {
            @ApiResponse(description = "Ok", responseCode = "200")
    })
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<EstadioDTO>> findAll() {
        List<EstadioDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @Operation(description = "Estadios", summary = "Estadios por ID", responses = {
            @ApiResponse(description = "Ok", responseCode = "200"),
            @ApiResponse(description = "Not Found", responseCode = "404")
    })
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<EstadioDTO> findById(@PathVariable Long id) {
        EstadioDTO estadio = service.findById(id);
        return ResponseEntity.ok().body(estadio);
    }

    @Operation(description = "Estadios", summary = "Estadios por Nome", responses = {
            @ApiResponse(description = "Ok", responseCode = "200"),
            @ApiResponse(description = "Not Found", responseCode = "404")
    })
    @GetMapping(value = "/nome", produces = "application/json")
    public ResponseEntity<EstadioDTO> findByNome(
            @RequestParam(required = false) String nome) {

        EstadioDTO estadio = service.findByNome(nome);
        return ResponseEntity.ok().body(estadio);
    }

    @Operation(description = "Estadios", summary = "Inserir Novo Estadio", responses = {
            @ApiResponse(description = "Created", responseCode = "201"),
            @ApiResponse(description = "Unprocessable Entity", responseCode = "422")
    })
    @PostMapping(produces = "application/json")
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

    @Operation(description = "Estadios", summary = "Atualizar o Estadio", responses = {
            @ApiResponse(description = "Created", responseCode = "201"),
            @ApiResponse(description = "Not Found", responseCode = "404"),
            @ApiResponse(description = "Unprocessable Entity", responseCode = "422")
    })
    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<EstadioDTO> update(@PathVariable Long id, @Valid @RequestBody EstadioDTO dto) {
        EstadioDTO updatedEstadio = service.update(id, dto);
        return ResponseEntity.ok().body(updatedEstadio);
    }

    @Operation(description = "Estadios", summary = "Deletar um Estadio", responses = {
            @ApiResponse(description = "No Content", responseCode = "204"),
            @ApiResponse(description = "Not Found", responseCode = "404")
    })
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

