package io.github.com.campeonato.services;

import io.github.com.campeonato.dtos.JogadorDTO;
import io.github.com.campeonato.entities.Jogador;
import io.github.com.campeonato.repositories.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository repository;

    @Transactional(readOnly = true)
    public Page<JogadorDTO> findAllJogadores(Pageable pageable) {
        Page<Jogador> jogador = repository.findAll(pageable);
        return jogador.map(JogadorDTO::new);
    }
}
