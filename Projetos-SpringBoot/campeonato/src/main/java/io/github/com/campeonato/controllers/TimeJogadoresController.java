package io.github.com.campeonato.controllers;

import io.github.com.campeonato.dtos.TimeJogadoresDTO;
import io.github.com.campeonato.services.TimeJogadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/nome/{time}")
    public ResponseEntity<List<TimeJogadoresDTO>> findByNome(@PathVariable("time") String nome) {
        List<TimeJogadoresDTO> list = service.findByNome(nome);
        return ResponseEntity.ok().body(list);
    }
}
