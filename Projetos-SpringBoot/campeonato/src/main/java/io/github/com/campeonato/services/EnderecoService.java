package io.github.com.campeonato.services;

import io.github.com.campeonato.dtos.EnderecoDTO;
import io.github.com.campeonato.entities.Endereco;
import io.github.com.campeonato.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    @Transactional(readOnly = true)
    public List<EnderecoDTO> findAll() {
        List<Endereco> list = repository.findAll();
        return list.stream().map(EnderecoDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public List<EnderecoDTO> findByLogradouro(String logradouro) {
        List<Endereco> list = repository.findByLogradouro(logradouro);
        return list.stream().map(EnderecoDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public List<EnderecoDTO> findByCidade(String cidade) {
        List<Endereco> list = repository.findByCidade(cidade);
        return list.stream().map(EnderecoDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public List<EnderecoDTO> findByBairro(String bairro) {
        List<Endereco> list = repository.findByBairro(bairro);
        return list.stream().map(EnderecoDTO::new).toList();
    }
}
