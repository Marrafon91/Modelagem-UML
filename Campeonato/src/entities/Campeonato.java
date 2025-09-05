package entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Campeonato {

	private Integer id;
	private Integer ano;
	private String nome;

	Set<Time> times = new HashSet<>();
	Set<Partida> partidas = new HashSet<>();

	public Campeonato() {
	}

	public Campeonato(Integer id, Integer ano, String nome) {
		this.id = id;
		this.ano = ano;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public Set<Time> getTimes() {
		return Set.copyOf(times);
	}

	public Set<Partida> getPartidas() {
		return Set.copyOf(partidas);
	}

	public void adicionarTimes(Time time) {
		if (!times.contains(time)) {
			times.add(time);
		}
	}

	public void adicionarPartida(Partida partida) {
		partidas.add(partida);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campeonato other = (Campeonato) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Campeonato [id=");
		builder.append(id);
		builder.append(", ano=");
		builder.append(ano);
		builder.append(", nome=");
		builder.append(nome);
		builder.append("]");
		return builder.toString();
	}
}
