package io.github.com.campeonato.services;

import io.github.com.campeonato.dtos.CampeonatoDTO;
import io.github.com.campeonato.entities.Campeonato;
import io.github.com.campeonato.repositories.CampeonatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CampeonatoService {

    @Autowired
    private CampeonatoRepository repository;

    @Transactional(readOnly = true)
    public List<CampeonatoDTO> findAllCampeonatos() {
        List<Campeonato> result = repository.findAllWithPartidas();
        return result.stream().map(CampeonatoDTO::new).toList();
    }
}
