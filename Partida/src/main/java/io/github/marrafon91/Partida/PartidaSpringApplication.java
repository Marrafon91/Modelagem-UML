package io.github.marrafon91.Partida;

import io.github.marrafon91.Partida.entities.Endereco;
import io.github.marrafon91.Partida.entities.Estadio;
import io.github.marrafon91.Partida.entities.enums.Time;
import io.github.marrafon91.Partida.repository.CampeonatoRepository;
import io.github.marrafon91.Partida.repository.EnderecoRepository;
import io.github.marrafon91.Partida.repository.EstadioRepository;
import io.github.marrafon91.Partida.repository.PartidaRepository;
import io.github.marrafon91.Partida.entities.Campeonato;
import io.github.marrafon91.Partida.entities.Partida;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
@RequiredArgsConstructor
public class PartidaSpringApplication implements CommandLineRunner {

	private final PartidaRepository partidaRepository;
	private final CampeonatoRepository campeonatoRepository;
	private final EnderecoRepository enderecoRepository;
	private final EstadioRepository estadioRepository;

	public static void main(String[] args) {
		SpringApplication.run(PartidaSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Campeonato campeonato = new Campeonato();
		campeonato.setAno(2017);
		campeonato.setNome("Copa de Handebol");

		Endereco endereco = new Endereco();
		endereco.setLogradouro("Avenida Maracanã");
		endereco.setNumero(1000);
		endereco.setComplemento("Setor Norte");
		endereco.setBairro("Maracanã");
		endereco.setCidade("Rio de Janeiro");
		endereco.setEstado("RJ");

		Endereco endereco1 = new Endereco();
		endereco1.setLogradouro("Avenida Machado");
		endereco1.setNumero(1910);
		endereco1.setComplemento("Esquina com Rua São Francisco Xavier");
		endereco1.setBairro("Santo André");
		endereco1.setCidade("São Paulo");
		endereco1.setEstado("SP");

		Estadio estadio = new Estadio();
		estadio.setNome("Maracanã");
		estadio.setEndereco(endereco);

		Estadio estadio1 = new Estadio();
		estadio1.setNome("Estádio do Pacaembu");
		estadio1.setEndereco(endereco1);

		estadioRepository.save(estadio);
		estadioRepository.save(estadio1);

		Partida partida1 = new Partida();
		partida1.setMandante(Time.CORINTHIANS);
		partida1.setVisitante(Time.PALMEIRAS);
		partida1.setData(LocalDate.parse("2017-08-20"));
		partida1.setPontuacaoMandante(10);
		partida1.setPontuacaoVisitante(7);
		partida1.setCampeonato(campeonato);
		partida1.setEstadio(estadio);

		Partida partida2 = new Partida();
		partida2.setMandante(Time.FLUMINENSE);
		partida2.setVisitante(Time.FLAMENGO);
		partida2.setData(LocalDate.parse("2017-08-21"));
		partida2.setPontuacaoMandante(9);
		partida2.setPontuacaoVisitante(13);
		partida2.setCampeonato(campeonato);
		partida2.setEstadio(estadio1);

		campeonato.getPartidas().add(partida1);
		campeonato.getPartidas().add(partida2);

		campeonatoRepository.save(campeonato);

	}
}
