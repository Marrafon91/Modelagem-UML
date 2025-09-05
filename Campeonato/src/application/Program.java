package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import entities.Campeonato;
import entities.Jogador;
import entities.Partida;
import entities.Time;
import entities.enums.Genero;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		// Campeonato
		Campeonato c1 = new Campeonato(1, 2017, "Copa de Handebol");

		// Times
		Time corinthians = new Time(1, "Corinthians");
		Time flamengo = new Time(2, "Flamengo");

		// Jogadores
		Jogador j1 = new Jogador(1, "Joao da Silva", sdf.parse("11/07/1990"), Genero.MASCULINO, 1.81);
		Jogador j2 = new Jogador(2, "Marco Tulio", sdf.parse("21/03/1989"), Genero.MASCULINO, 1.74);
		Jogador j3 = new Jogador(3, "Gustavo Mendes", sdf.parse("03/12/1991"), Genero.MASCULINO, 1.73);
		Jogador j4 = new Jogador(4, "Carlos Teles", sdf.parse("14/08/1987"), Genero.MASCULINO, 1.86);

		// Adicionando jogadores aos times
		corinthians.adicionarJogador(j1);
		corinthians.adicionarJogador(j2);
		flamengo.adicionarJogador(j3);
		flamengo.adicionarJogador(j4);

		// Definindo capitães
		corinthians.setCapitaoDoTime(j1);
		flamengo.setCapitaoDoTime(j3);

		// Adicionando times diretamente na lista do campeonato
		c1.getTimes().add(corinthians);
		c1.getTimes().add(flamengo);

		// Partidas
		Partida p1 = new Partida(1, sdf.parse("20/08/2017"), corinthians, flamengo, 10, 7);
		Partida p2 = new Partida(2, sdf.parse("21/08/2017"), flamengo, corinthians, 9, 13);

		// Adicionando partidas diretamente no set do campeonato
		c1.getPartidas().add(p1);
		c1.getPartidas().add(p2);

		// Exibindo informações
		System.out.println("=== Campeonato ===");
		System.out.println(c1);

		System.out.println("\n=== Times ===");
		for (Time t : c1.getTimes()) {
			System.out.println(t);
			System.out.println("Jogadores:");
			for (Jogador j : t.getJogadores()) {
				System.out.println(" - " + j + ", Idade: " + j.getIdade());
			}
		}

		System.out.println("\n=== Partidas ===");
		for (Partida p : c1.getPartidas()) {
			System.out.println(p);
			String vencedor = (p.vencedor() != null) ? p.vencedor().getName() : "Empate";
			System.out.println("Vencedor: " + vencedor);
		}
	}
}
