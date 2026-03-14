package io.github.com.campeonato.services;

import io.github.com.campeonato.dtos.JogadorDTO;
import io.github.com.campeonato.entities.Jogador;
import io.github.com.campeonato.exceptions.ResourceNotFoundException;
import io.github.com.campeonato.repositories.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository repository;

    @Transactional(readOnly = true)
    public Page<JogadorDTO> findAllJogadores(Pageable pageable) {

        Page<Jogador> result = repository.findAll(pageable);
        return result.map(JogadorDTO::new);
    }

    @Transactional(readOnly = true)
    public JogadorDTO findJogadorById(Long id) {

        Optional<Jogador> result = repository.findByIdWithTime(id);
        return result.map(JogadorDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException("Jogador com ID " + id + " não encontrado"));
    }

    @Transactional(readOnly = true)
    public List<JogadorDTO> findJogadorByNome(String nome) {

        List<Jogador> result = repository.findByNome(nome);

        if (result.isEmpty()) {
            throw new ResourceNotFoundException("O nome do Jogador não pode ser em branco, Por favor ensira um nome");
        }
        return result.stream().map(JogadorDTO::new).toList();
    }
}

