package io.github.com.campeonato.controllers;

import io.github.com.campeonato.dtos.EnderecoDTO;
import io.github.com.campeonato.services.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
@Tag(name = "Endereço", description = "Endereço dos Estadios")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @Operation(description = "Endereços", summary = "Todos os Endereços", responses = {
            @ApiResponse(description = "Ok", responseCode = "200")
    })
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<EnderecoDTO>> findAll() {
        List<EnderecoDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);

    }

    @Operation(description = "Endereços", summary = "Endereços por Rua", responses = {
            @ApiResponse(description = "Ok", responseCode = "200"),
            @ApiResponse(description = "Not Found", responseCode = "404")
    })
    @GetMapping(value = "/logradouro", produces = "application/json")
    public ResponseEntity<List<EnderecoDTO>> findByLogradouro(
            @RequestParam(required = false) String logradouro) {

        List<EnderecoDTO> list = service.findByLogradouro(logradouro);
        return ResponseEntity.ok().body(list);
    }

    @Operation(description = "Endereços", summary = "Endereços por Cidade", responses = {
            @ApiResponse(description = "Ok", responseCode = "200"),
            @ApiResponse(description = "Not Found", responseCode = "404")
    })
    @GetMapping(value = "/cidade", produces = "application/json")
    public ResponseEntity<List<EnderecoDTO>> findByCidade(
            @RequestParam(required = false) String cidade) {

        List<EnderecoDTO> list = service.findByCidade(cidade);
        return ResponseEntity.ok().body(list);
    }

    @Operation(description = "Endereços", summary = "Endereços por Bairro", responses = {
            @ApiResponse(description = "Ok", responseCode = "200"),
            @ApiResponse(description = "Not Found", responseCode = "404")
    })
    @GetMapping(value = "/bairro", produces = "application/json")
    public ResponseEntity<List<EnderecoDTO>> findByBairro(
            @RequestParam(required = false) String bairro) {

        List<EnderecoDTO> list = service.findByBairro(bairro);
        return ResponseEntity.ok().body(list);
    }
}
