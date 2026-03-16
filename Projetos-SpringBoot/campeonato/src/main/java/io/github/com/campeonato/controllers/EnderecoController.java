package io.github.com.campeonato.controllers;

import io.github.com.campeonato.dtos.EnderecoDTO;
import io.github.com.campeonato.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> findAll() {
        List<EnderecoDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);

    }

    @GetMapping("/logradouro")
    public ResponseEntity<List<EnderecoDTO>> findByLogradouro(
            @RequestParam(required = false) String logradouro) {

        List<EnderecoDTO> list = service.findByLogradouro(logradouro);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/cidade")
    public ResponseEntity<List<EnderecoDTO>> findByCidade(
            @RequestParam(required = false) String cidade) {

        List<EnderecoDTO> list = service.findByCidade(cidade);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/bairro")
    public ResponseEntity<List<EnderecoDTO>> findByBairro(
            @RequestParam(required = false) String bairro) {

        List<EnderecoDTO> list = service.findByBairro(bairro);
        return ResponseEntity.ok().body(list);
    }
}
