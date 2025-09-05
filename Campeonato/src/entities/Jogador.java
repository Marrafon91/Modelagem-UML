package entities;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

import entities.enums.Genero;

public class Jogador {

	private Integer id;
	private String nome;
	private LocalDate nascimento;
	private Genero genero;
	private Double altura;

	public Jogador() {
	}

	public Jogador(Integer id, String nome, LocalDate nascimento, Genero genero, Double altura) {
		this.id = id;
		this.nome = nome;
		this.nascimento = nascimento;
		this.genero = genero;
		this.altura = altura;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public int getIdade() {
		if (nascimento == null)	return 0;
		return Period.between(nascimento, LocalDate.now()).getYears();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Jogador [id=" + id + ", nome=" + nome + ", nascimento=" + nascimento + ", idade=" + getIdade()
				+ ", genero=" + genero + ", altura=" + altura + "]";
	}
}
