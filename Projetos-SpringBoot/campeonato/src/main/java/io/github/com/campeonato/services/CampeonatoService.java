package io.github.com.campeonato.services;

import io.github.com.campeonato.dtos.CampeonatoComPartidasPageDTO;
import io.github.com.campeonato.dtos.CampeonatoDTO;
import io.github.com.campeonato.dtos.PartidaDTOSemJogadores;
import io.github.com.campeonato.entities.Campeonato;
import io.github.com.campeonato.repositories.CampeonatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CampeonatoService {

    @Autowired
    private CampeonatoRepository repository;

    @Transactional(readOnly = true)
    public CampeonatoDTO findALL() {
        Campeonato campeonatos = repository.findAll().getFirst();
        return new CampeonatoDTO(campeonatos);
    }

    @Transactional(readOnly = true)
    public CampeonatoComPartidasPageDTO findByNameWithPartidas(String nome, Pageable pageable) {
        // Se o pageable não especificar tamanho, usa 5 como padrão
        Pageable pageablePartidas = pageable.getPageSize() == 0 ? PageRequest.of(0, 5) : PageRequest.of(pageable.getPageNumber(), 5);
        
        // Buscar o campeonato completo (sem paginação)
        Campeonato campeonato = repository.findByNomeContaining(nome, PageRequest.of(0, 1))
                .getContent()
                .stream()
                .findFirst()
                .orElse(null);
        
        if (campeonato == null) {
            throw new RuntimeException("Campeonato com nome '" + nome + "' não encontrado");
        }
        
        // Buscar partidas paginadas de 5 em 5
        Page<io.github.com.campeonato.entities.Partida> partidas = repository.findPartidasByCampeonatoNomeContaining(nome, pageablePartidas);
        
        // Converter partidas para DTO sem jogadores
        Page<PartidaDTOSemJogadores> partidasDTO = partidas.map(PartidaDTOSemJogadores::new);
        
        return new CampeonatoComPartidasPageDTO(campeonato, partidasDTO);
    }
}
