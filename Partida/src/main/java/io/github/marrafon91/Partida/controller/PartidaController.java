package io.github.marrafon91.Partida.controller;

import io.github.marrafon91.Partida.entities.Partida;
import io.github.marrafon91.Partida.repository.CampeonatoRepository;
import io.github.marrafon91.Partida.repository.PartidaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "partidas")
@RequiredArgsConstructor
public class PartidaController {

    private final PartidaRepository partidaRepository;

    @PostMapping
    public ResponseEntity<Void> criarPartida(@RequestBody Partida partida) {
        Partida save = partidaRepository.save(partida);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(save.getId())
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
            @RequestBody Partida partida) {

        return partidaRepository.findById(id)
                .map(partidaEncontrada -> {
                    partidaEncontrada.setPontuacaoMandante(partida.getPontuacaoMandante());
                    partidaEncontrada.setPontuacaoVisitante(partida.getPontuacaoVisitante());
                    Partida atualizar = partidaRepository.save(partidaEncontrada);
                    return ResponseEntity.ok(atualizar);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
