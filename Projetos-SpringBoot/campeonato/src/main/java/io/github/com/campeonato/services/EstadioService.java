package io.github.com.campeonato.services;

import io.github.com.campeonato.dtos.EstadioDTO;
import io.github.com.campeonato.entities.Estadio;
import io.github.com.campeonato.exceptions.EstadioNotFoundException;
import io.github.com.campeonato.repositories.EstadioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstadioService {

    @Autowired
    private EstadioRepository repository;

    @Transactional(readOnly = true)
    public List<EstadioDTO> findAll() {
        // Usa FETCH JOIN para carregar endereco e evitar N+1 queries
        List<Estadio> estadios = repository.findAllWithEndereco();
        return estadios.stream().map(EstadioDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public EstadioDTO findById(Long id) {
        // Usa FETCH JOIN para carregar endereco e evitar N+1 queries
        return repository.findByIdWithEndereco(id)
                .map(EstadioDTO::new)
                .orElseThrow(() -> new EstadioNotFoundException("Estádio com ID " + id + " não encontrado"));
    }

    @Transactional(readOnly = true)
    public EstadioDTO findByNome(String nome) {
        Estadio estadio = repository.findByNome(nome);
        if (estadio == null) {
            throw new EstadioNotFoundException("Estádio com nome '" + nome + "' não encontrado");
        }
        return new EstadioDTO(estadio);
    }

    @Transactional
    public EstadioDTO save(EstadioDTO dto) {
        Estadio estadio = new Estadio(null, dto.nome(), null);
        Estadio savedEstadio = repository.save(estadio);
        return new EstadioDTO(savedEstadio);
    }

    @Transactional
    public EstadioDTO update(Long id, EstadioDTO dto) {
        Estadio estadio = repository.findById(id)
                .orElseThrow(() -> new EstadioNotFoundException("Estádio com ID " + id + " não encontrado"));
        estadio.setNome(dto.nome());
        Estadio updatedEstadio = repository.save(estadio);
        return new EstadioDTO(updatedEstadio);
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EstadioNotFoundException("Estádio com ID " + id + " não encontrado");
        }
        repository.deleteById(id);
    }
}

