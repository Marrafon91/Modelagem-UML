package entities;

import java.util.Objects;

public class Musica {

	private Integer id;
	private String nome;
	private Integer duracao;

	public Musica() {
	}

	public Musica(Integer id, String nome, Integer duracao) {
		this.id = id;
		this.nome = nome;
		this.duracao = duracao;
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

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
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
		Musica other = (Musica) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Musica [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", duracao=");
		builder.append(duracao);
		builder.append("]");
		return builder.toString();
	}
}
