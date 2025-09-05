package entities;

import java.util.Objects;

public class Endereco {

	private Integer id;
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String bairro;

	private Estadio estadio;

	public Endereco() {
	}

	public Endereco(Integer id, String logradouro, Integer numero, String complemento, String bairro) {
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		if (logradouro == null || logradouro.isBlank()) {
			throw new IllegalArgumentException("O logradouro não pode ser vazio.");
		}
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
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
		Endereco other = (Endereco) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		if (logradouro != null && !logradouro.isEmpty()) {
			builder.append(logradouro);
		}

		if (numero != null) {
			builder.append(", ").append(numero);
		}

		if (complemento != null && !complemento.isEmpty()) {
			builder.append(" - ").append(complemento);
		}

		if (bairro != null && !bairro.isEmpty()) {
			builder.append(", ").append(bairro);
		}

		return builder.toString().trim();
	}

}
