package io.github.com.campeonato.controllers;

import io.github.com.campeonato.dtos.JogadorDTO;
import io.github.com.campeonato.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    private JogadorService service;

    @GetMapping
    public ResponseEntity<Page<JogadorDTO>> findAllJogadores(Pageable pageable) {
        Page<JogadorDTO> result = service.findAllJogadores(pageable);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JogadorDTO> findById(@PathVariable Long id) {
        JogadorDTO dto = service.findJogadorById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<JogadorDTO>> findByNome(@PathVariable String nome) {
        List<JogadorDTO> result = service.findJogadorByNome(nome);
        return ResponseEntity.ok().body(result);
    }
}
