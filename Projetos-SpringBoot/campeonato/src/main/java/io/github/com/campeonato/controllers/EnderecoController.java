package io.github.com.campeonato.controllers;

import io.github.com.campeonato.dtos.EnderecoDTO;
import io.github.com.campeonato.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping("/{logradouro}")
    public ResponseEntity<List<EnderecoDTO>> findAllLogradouro(EnderecoDTO dto) {
        List<EnderecoDTO> list = service.findEnderecoBylogradouro(dto);
        return ResponseEntity.ok().body(list);
    }
}
