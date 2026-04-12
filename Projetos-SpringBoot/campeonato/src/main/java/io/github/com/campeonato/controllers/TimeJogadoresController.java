package io.github.com.campeonato.controllers;

import io.github.com.campeonato.dtos.TimeJogadoresDTO;
import io.github.com.campeonato.services.TimeJogadoresService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/times")
@Tag(name = "Times", description = "Controle de Times")
public class TimeJogadoresController {

    @Autowired
    private TimeJogadoresService service;

    @Operation(description = "Times", summary = "Todos os Times", responses = {
            @ApiResponse(description = "Ok", responseCode = "200")
    })
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<TimeJogadoresDTO>> allTimeJogadores() {
        List<TimeJogadoresDTO> list = service.findAllTimes();
        return ResponseEntity.ok().body(list);
    }

    @Operation(description = "Times", summary = "Busca os Times por ID", responses = {
            @ApiResponse(description = "Ok", responseCode = "200"),
            @ApiResponse(description = "Not Found", responseCode = "404")
    })
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<TimeJogadoresDTO> findById(@PathVariable Long id) {
        TimeJogadoresDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @Operation(description = "Times", summary = "Busca os Times por Nome", responses = {
            @ApiResponse(description = "Ok", responseCode = "200"),
            @ApiResponse(description = "Not Found", responseCode = "404")
    })
    @GetMapping(value = "/nomeTime", produces = "application/json")
    public ResponseEntity<List<TimeJogadoresDTO>> findByNome(
            @RequestParam(required = false) String nome) {

        List<TimeJogadoresDTO> list = service.findByNome(nome);
        return ResponseEntity.ok().body(list);
    }
}
