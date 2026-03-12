package io.github.com.campeonato.services;

import io.github.com.campeonato.dtos.PartidaDTO;
import io.github.com.campeonato.dtos.PartidaInsertDTO;
import io.github.com.campeonato.dtos.PartidaMinDTO;
import io.github.com.campeonato.entities.Campeonato;
import io.github.com.campeonato.entities.Estadio;
import io.github.com.campeonato.entities.Partida;
import io.github.com.campeonato.exceptions.ResourceNotFoundException;
import io.github.com.campeonato.repositories.CampeonatoRepository;
import io.github.com.campeonato.repositories.EstadioRepository;
import io.github.com.campeonato.repositories.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository repository;

    @Autowired
    private CampeonatoRepository campeonatoRepository;

    @Autowired
    private EstadioRepository estadioRepository;

    @Transactional(readOnly = true)
    public List<PartidaMinDTO> findAll()  {
        List<Partida> result = repository.findAllWithEstadio();
        return result.stream().map(PartidaMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public PartidaMinDTO findById(Long id) {
        return repository.findById(id)
                .map(PartidaMinDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException("Partida com ID " + id + " não encontrada"));
    }

    @Transactional
    public PartidaInsertDTO insert(PartidaInsertDTO dto) {

        Partida partida = new Partida();

        partida.setData(dto.data());
        partida.setMandante(dto.mandante());
        partida.setVisitante(dto.visitante());
        partida.setPontuacaoMandante(dto.pontuacaoMandante());
        partida.setPontuacaoVisitante(dto.pontuacaoVisitante());

        Campeonato campeonato = campeonatoRepository.getReferenceById(dto.campeonatoId());
        partida.setCampeonato(campeonato);

        Estadio estadio = estadioRepository.getReferenceById(dto.estadioId());
        partida.setEstadio(estadio);

        partida = repository.save(partida);

        return new PartidaInsertDTO(partida);
    }

    @Transactional
    public PartidaMinDTO update(Long id, PartidaMinDTO dto) {
        Partida partida = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Partida com ID " + id + " não encontrado"));

        partida.setData(dto.data());
        partida.setMandante(dto.mandante());
        partida.setVisitante(dto.visitante());
        partida.setPontuacaoMandante(dto.pontuacaoMandante());
        partida.setPontuacaoVisitante(dto.pontuacaoVisitante());

        partida = repository.save(partida);
        return new PartidaMinDTO(partida);

    }
}
