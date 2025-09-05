package entities;

import java.util.Date;
import java.util.Objects;

public class Jogador {

	private Integer id;
	private String nome;
	private Date nascimento;
	private Character genero;
	private Double altura;
	
	public Jogador() {
	}

	public Jogador(Integer id, String nome, Date nascimento, Character genero, Double altura) {
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

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Character getGenero() {
		return genero;
	}

	public void setGenero(Character genero) {
		this.genero = genero;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
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
		Jogador other = (Jogador) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Jogador [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", nascimento=");
		builder.append(nascimento);
		builder.append(", genero=");
		builder.append(genero);
		builder.append(", altura=");
		builder.append(altura);
		builder.append("]");
		return builder.toString();
	}	
	
}
