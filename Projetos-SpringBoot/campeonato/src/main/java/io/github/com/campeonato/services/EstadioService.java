package io.github.com.campeonato.services;

import io.github.com.campeonato.dtos.EstadioDTO;
import io.github.com.campeonato.entities.Endereco;
import io.github.com.campeonato.entities.Estadio;
import io.github.com.campeonato.exceptions.DatabaseException;
import io.github.com.campeonato.exceptions.ResourceNotFoundException;
import io.github.com.campeonato.repositories.EstadioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstadioService {

    @Autowired
    private EstadioRepository repository;

    @Transactional(readOnly = true)
    public List<EstadioDTO> findAll() {
        List<Estadio> estadios = repository.findAllWithEndereco();
        return estadios.stream().map(EstadioDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public EstadioDTO findById(Long id) {
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
    public EstadioDTO insert(EstadioDTO dto) {

        Estadio estadio = toEntity(dto);

        estadio = repository.save(estadio);

        return new EstadioDTO(estadio);
    }

    @Transactional
    public EstadioDTO update(Long id, EstadioDTO dto) {

        try {

            Estadio estadio = repository.getReferenceById(id);

            updateData(estadio, dto);

            return new EstadioDTO(estadio);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Estádio com ID " + id + " não encontrado");
        }
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Estádio com ID " + id + " não encontrado");
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação de integridade referencial!");
        }
    }

    private Estadio toEntity(EstadioDTO dto) {

        Estadio estadio = new Estadio();
        estadio.setNome(dto.nome());

        Endereco endereco = new Endereco();
        endereco.setLogradouro(dto.endereco().logradouro());
        endereco.setNumero(dto.endereco().numero());
        endereco.setComplemento(dto.endereco().complemento());
        endereco.setBairro(dto.endereco().bairro());
        endereco.setCidade(dto.endereco().cidade());
        endereco.setEstado(dto.endereco().estado());

        estadio.setEndereco(endereco);

        return estadio;
    }


    private void updateData(Estadio estadio, EstadioDTO dto) {

        estadio.setNome(dto.nome());

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
    }
}

