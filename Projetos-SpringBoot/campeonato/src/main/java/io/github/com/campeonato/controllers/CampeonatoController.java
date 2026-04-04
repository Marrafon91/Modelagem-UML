package io.github.com.campeonato.controllers;

import io.github.com.campeonato.dtos.CampeonatoDTO;
import io.github.com.campeonato.services.CampeonatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/campeonatos")
@Tag(name = "Campeonatos", description = "Controle do Campeonato")
public class CampeonatoController {

    @Autowired
    private CampeonatoService service;

    @Operation(description = "Todo Campeonato", summary = "Lista de todo campeonato", responses = {
            @ApiResponse(description = "OK", responseCode = "200")
    })
    @GetMapping(produces = "application/json")
    public List<CampeonatoDTO> findAll() {
        return service.findAllCampeonatos();
    }


}
