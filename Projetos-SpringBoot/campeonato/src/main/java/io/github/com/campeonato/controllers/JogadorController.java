package io.github.com.campeonato.controllers;

import io.github.com.campeonato.dtos.JogadorDTO;
import io.github.com.campeonato.services.JogadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
@Tag(name = "Jogadores", description = "Controle de Jogadores")
public class JogadorController {

    @Autowired
    private JogadorService service;

    @Operation(description = "Jogadores", summary = "Todos Jogadores", responses = {
            @ApiResponse(description = "Ok", responseCode = "200")
    })
    @GetMapping(produces = "application/json")
    public ResponseEntity<Page<JogadorDTO>> findAllJogadores(Pageable pageable) {
        Page<JogadorDTO> result = service.findAllJogadores(pageable);
        return ResponseEntity.ok().body(result);
    }

    @Operation(description = "Jogadores", summary = "Busca Jogadores por ID", responses = {
            @ApiResponse(description = "Ok", responseCode = "200"),
            @ApiResponse(description = "Not Found", responseCode = "404")
    })
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<JogadorDTO> findById(@PathVariable Long id) {
        JogadorDTO dto = service.findJogadorById(id);
        return ResponseEntity.ok().body(dto);
    }

    @Operation(description = "Jogadores", summary = "Busca Jogadores por Nome", responses = {
            @ApiResponse(description = "Ok", responseCode = "200"),
            @ApiResponse(description = "Not Found", responseCode = "404")
    })
    @GetMapping(value = "/nomeJogador", produces = "application/json")
    public ResponseEntity<List<JogadorDTO>> findByNome(
            @RequestParam(required = false) String nome) {

        List<JogadorDTO> result = service.findJogadorByNome(nome);
        return ResponseEntity.ok().body(result);
    }
}
