package entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Time {

	private Integer id;
	private String name;

	private Jogador capitaoDoTime;
	private Set<Jogador> jogadores = new HashSet<>();

	public Time() {
	}

	public Time(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Jogador getCapitaoDoTime() {
		return capitaoDoTime;
	}

	public void setCapitaoDoTime(Jogador capitaoDoTime) {
		this.capitaoDoTime = capitaoDoTime;
	}

	public Set<Jogador> getJogadore() {
		return jogadores;
	}

	public void adicionarJogador(Jogador jogador) {
		jogadores.add(jogador);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Time [id=" + id + ", name=" + name + ", capitao="
				+ (capitaoDoTime != null ? capitaoDoTime.getNome() : "N/A") + "]";
	}
}
