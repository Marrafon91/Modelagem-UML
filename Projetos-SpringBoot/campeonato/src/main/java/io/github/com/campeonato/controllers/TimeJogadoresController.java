package io.github.com.campeonato.controllers;

import io.github.com.campeonato.dtos.TimeJogadoresDTO;
import io.github.com.campeonato.services.TimeJogadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/times")
public class TimeJogadoresController {

    @Autowired
    private TimeJogadoresService service;

    @GetMapping
    public ResponseEntity<List<TimeJogadoresDTO>> allTimeJogadores() {
        List<TimeJogadoresDTO> list = service.findAllTimes();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeJogadoresDTO> findById(@PathVariable Long id) {
        TimeJogadoresDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/nomeTime")
    public ResponseEntity<List<TimeJogadoresDTO>> findByNome(
            @RequestParam(required = false) String nome) {

        List<TimeJogadoresDTO> list = service.findByNome(nome);
        return ResponseEntity.ok().body(list);
    }
}
