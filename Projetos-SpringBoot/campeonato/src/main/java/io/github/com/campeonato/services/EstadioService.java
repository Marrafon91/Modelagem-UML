package io.github.com.campeonato.services;

import io.github.com.campeonato.dtos.EstadioDTO;
import io.github.com.campeonato.entities.Endereco;
import io.github.com.campeonato.entities.Estadio;
import io.github.com.campeonato.exceptions.ResourceNotFoundException;
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
                .orElseThrow(() -> new ResourceNotFoundException("Estádio com ID " + id + " não encontrado"));
    }

    @Transactional(readOnly = true)
    public EstadioDTO findByNome(String nome) {
        Estadio estadio = repository.findByNome(nome);
        if (estadio == null) {
            throw new ResourceNotFoundException("Estádio com nome '" + nome + "' não encontrado");
        }
        return new EstadioDTO(estadio);
    }

    @Transactional
    public EstadioDTO save(EstadioDTO dto) {
        Estadio estadio = new Estadio();
        estadio.setNome(dto.nome());
        
        // Criar endereço a partir do EnderecoDTO
        Endereco endereco = new Endereco();
        endereco.setLogradouro(dto.endereco().logradouro());
        endereco.setNumero(dto.endereco().numero());
        endereco.setComplemento(dto.endereco().complemento());
        endereco.setBairro(dto.endereco().bairro());
        endereco.setCidade(dto.endereco().cidade());
        endereco.setEstado(dto.endereco().estado());
        
        estadio.setEndereco(endereco);
        Estadio savedEstadio = repository.save(estadio);
        return new EstadioDTO(savedEstadio);
    }

    @Transactional
    public EstadioDTO update(Long id, EstadioDTO dto) {
        Estadio estadio = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estádio com ID " + id + " não encontrado"));
        estadio.setNome(dto.nome());
        
        // Atualizar endereço se fornecido
        if (dto.endereco() != null) {
            Endereco endereco = estadio.getEndereco();
            if (endereco == null) {
                endereco = new Endereco();
                estadio.setEndereco(endereco);
            }
            endereco.setLogradouro(dto.endereco().logradouro());
            endereco.setNumero(dto.endereco().numero());
            endereco.setComplemento(dto.endereco().complemento());
            endereco.setBairro(dto.endereco().bairro());
            endereco.setCidade(dto.endereco().cidade());
            endereco.setEstado(dto.endereco().estado());
        }
        
        Estadio updatedEstadio = repository.save(estadio);
        return new EstadioDTO(updatedEstadio);
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Estádio com ID " + id + " não encontrado");
        }
        repository.deleteById(id);
    }
}

