package io.github.marrafon91.Partida.controller;

import io.github.marrafon91.Partida.entities.Partida;
import io.github.marrafon91.Partida.repository.PartidaRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/partidas")
@RequiredArgsConstructor
public class PartidaController {

    private final PartidaRepository partidaRepository;

    @PostMapping
    public ResponseEntity<Void> criarPartida(@RequestBody @Valid Partida partida) {
        Partida salva = partidaRepository.save(partida);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(salva.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<Partida>> buscarTodos() {
        List<Partida> lista = partidaRepository.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("{id}")
    public ResponseEntity<Partida> buscarPorId(@PathVariable("id") Long id) {
        return partidaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {

        if (!partidaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        partidaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Partida> attPartidas(
            @PathVariable("id") Long id,
            @RequestBody @Valid Partida partida) {

        return partidaRepository.findById(id)
                .map(partidaEncontrada -> {
                    partidaEncontrada.setMandante(partida.getMandante());
                    partidaEncontrada.setVisitante(partida.getVisitante());
                    partidaEncontrada.setData(partida.getData());
                    partidaEncontrada.setPontuacaoMandante(partida.getPontuacaoMandante());
                    partidaEncontrada.setPontuacaoVisitante(partida.getPontuacaoVisitante());
                    Partida atualizar = partidaRepository.save(partidaEncontrada);
                    return ResponseEntity.ok(atualizar);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
