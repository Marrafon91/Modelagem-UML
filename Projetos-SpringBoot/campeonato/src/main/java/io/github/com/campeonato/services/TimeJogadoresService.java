package io.github.com.campeonato.services;

import io.github.com.campeonato.dtos.TimeJogadoresDTO;
import io.github.com.campeonato.entities.TimeJogadores;
import io.github.com.campeonato.exceptions.ResourceNotFoundException;
import io.github.com.campeonato.repositories.TimeJogadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TimeJogadoresService {

    @Autowired
    private TimeJogadoresRepository repository;

    @Transactional(readOnly = true)
    public List<TimeJogadoresDTO> findAllTimes() {
        List<TimeJogadores> result = repository.findAllWithJogadores();
        return result.stream().map(TimeJogadoresDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public List<TimeJogadoresDTO> findByNome(String nome) {

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do time não pode ser vazio");
        }

        List<TimeJogadores> result = repository.findByNome(nome);

        if (result.isEmpty()) {
            throw new ResourceNotFoundException("Time com nome " + nome + " não encontrado");
        }

        return result.stream().map(TimeJogadoresDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public TimeJogadoresDTO findById(long id) {
        Optional<TimeJogadores> result = repository.findById(id);
        return result.map(TimeJogadoresDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException("Time com ID " + id + " não encontrado"));
    }
}
