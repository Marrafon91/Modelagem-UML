package io.github.com.campeonato.controllers;

import io.github.com.campeonato.dtos.CampeonatoDTO;
import io.github.com.campeonato.dtos.PartidaDTO;
import io.github.com.campeonato.services.CampeonatoService;
import io.github.com.campeonato.services.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @Autowired
    private PartidaService partidaService;

    @GetMapping
    public CampeonatoDTO findAll() {
        return service.findALL();
    }

    @GetMapping("/{id}/partidas")
    public ResponseEntity<Page<PartidaDTO>> findPartidasByCampeonato(
            @PathVariable Long id,
            Pageable pageable) {

        Page<PartidaDTO> page = partidaService.findPartidasByCampeonato(id, pageable);
        return ResponseEntity.ok(page);
    }
}
