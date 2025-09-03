package entities;

import java.time.Year;
import java.util.Objects;

public class Carro {

	private Long id;
	private String modelo;
	private Year ano;

	public Carro() {
	}

	public Carro(Long id, String modelo, Year ano) {
		this.id = id;
		this.modelo = modelo;
		this.ano = ano;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Year getAno() {
		return ano;
	}

	public void setAno(Year ano) {
		this.ano = ano;
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
		Carro other = (Carro) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
	    StringBuilder builder = new StringBuilder();
	    builder.append("Carro [id=");
	    builder.append(id);
	    builder.append(", modelo=");
	    builder.append(modelo);
	    builder.append(", ano=");
	    builder.append(ano != null ? ano.toString() : "N/A");
	    builder.append("]");
	    return builder.toString(); 
	}

}
