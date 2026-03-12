package io.github.com.campeonato.controllers;

import io.github.com.campeonato.dtos.CampeonatoComPartidasPageDTO;
import io.github.com.campeonato.dtos.CampeonatoDTO;
import io.github.com.campeonato.services.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/campeonato")
public class CampeonatoController {

    @Autowired
    private CampeonatoService service;

    @GetMapping
    public CampeonatoDTO findAll() {
        return service.findALL();
    }
 
    @GetMapping("/nome/{nome}")
    public ResponseEntity<CampeonatoComPartidasPageDTO> findByNameWithPartidas(@PathVariable String nome, Pageable pageable) {
        CampeonatoComPartidasPageDTO campeonato = service.findByNameWithPartidas(nome, pageable);
        return ResponseEntity.ok().body(campeonato);
    }
}
