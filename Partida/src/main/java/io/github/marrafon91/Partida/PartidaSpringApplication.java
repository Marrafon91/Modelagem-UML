package io.github.marrafon91.Partida;

import io.github.marrafon91.Partida.entities.enums.Time;
import io.github.marrafon91.Partida.repository.CampeonatoRepository;
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

	public static void main(String[] args) {
		SpringApplication.run(PartidaSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Campeonato campeonato = new Campeonato();
		campeonato.setAno(2017);
		campeonato.setNome("Copa de Handebol");

		Partida partida1 = new Partida();
		partida1.setMandante(Time.CORINTHIANS);
		partida1.setVisitante(Time.PALMEIRAS);
		partida1.setData(LocalDate.parse("2017-08-20"));
		partida1.setPontuacaoMandante(10);
		partida1.setPontuacaoVisitante(7);
		partida1.setCampeonato(campeonato);

		Partida partida2 = new Partida();
		partida2.setMandante(Time.FLUMINENSE);
		partida2.setVisitante(Time.FLAMENGO);
		partida2.setData(LocalDate.parse("2017-08-21"));
		partida2.setPontuacaoMandante(9);
		partida2.setPontuacaoVisitante(13);
		partida2.setCampeonato(campeonato);

		campeonato.getPartidas().add(partida1);
		campeonato.getPartidas().add(partida2);

		campeonatoRepository.save(campeonato);
	}
}
