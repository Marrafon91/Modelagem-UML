package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Artista {

	private Integer id;
	private String nome;
	private String nacionalidade;
	private List<Album> albuns = new ArrayList<Album>();

	public Artista() {
	}

	public Artista(Integer id, String nome, String nacionalidade) {
		this.id = id;
		this.nome = nome;
		this.nacionalidade = nacionalidade;
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

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}	

	public void adicionarAlbum(Album album) {
		albuns.add(album);
	}
	
	public List<Album> getAlbuns() {
		return albuns;
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
		Artista other = (Artista) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(nome);
		builder.append("(");
		builder.append(nacionalidade);
		builder.append(")");
		builder.append(",");
		return builder.toString();
	}
}
