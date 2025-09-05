package entities;

import java.util.Date;
import java.util.Objects;

public class Partida {

	private Integer id;
	private Date data;
	private Integer pontuacaoMandante;
	private Integer pontuacaoVisitante;

	public Partida() {
	}

	public Partida(Integer id, Date data, Integer pontuacaoMandante, Integer pontuacaoVisitante) {
		this.id = id;
		this.data = data;
		this.pontuacaoMandante = pontuacaoMandante;
		this.pontuacaoVisitante = pontuacaoVisitante;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getPontuacaoMandante() {
		return pontuacaoMandante;
	}

	public void setPontuacaoMandante(Integer pontuacaoMandante) {
		this.pontuacaoMandante = pontuacaoMandante;
	}

	public Integer getPontuacaoVisitante() {
		return pontuacaoVisitante;
	}

	public void setPontuacaoVisitante(Integer pontuacaoVisitante) {
		this.pontuacaoVisitante = pontuacaoVisitante;
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
		Partida other = (Partida) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Partida [id=");
		builder.append(id);
		builder.append(", data=");
		builder.append(data);
		builder.append(", pontuacaoMandante=");
		builder.append(pontuacaoMandante);
		builder.append(", pontuacaoVisitante=");
		builder.append(pontuacaoVisitante);
		builder.append("]");
		return builder.toString();
	}
}
