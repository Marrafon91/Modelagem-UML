package entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Partida implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Date data;
	private Integer pontuacaoMandante;
	private Integer pontuacaoVisitante;

	private Time mandante;
	private Time visitante;

//	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Partida() {
	}

	public Partida(Integer id, Date data, Time mandante, Time visitante, Integer pontuacaoMandante,
			Integer pontuacaoVisitante) {
		this.id = id;
		this.data = data;
		this.mandante = mandante;
		this.visitante = visitante;
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

	public Time getMandante() {
		return mandante;
	}

	public void setMandante(Time mandante) {
		this.mandante = mandante;
	}

	public Time getVisitante() {
		return visitante;
	}

	public void setVisitante(Time visitante) {
		this.visitante = visitante;
	}

	public Time vencedor() {
		if (pontuacaoMandante > pontuacaoVisitante) {
			return mandante;
		} else if (pontuacaoVisitante > pontuacaoMandante) {
			return visitante;
		} else {
			return null;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Partida))
			return false;
		Partida other = (Partida) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = (data != null) ? sdf.format(data) : "N/A";

		return "Partida [id=" + id + ", data=" + dataFormatada + ", pontuacaoMandante=" + pontuacaoMandante
				+ ", pontuacaoVisitante=" + pontuacaoVisitante + ", mandante=" + mandante.getName() + ", visitante="
				+ visitante.getName() + "]";
	}

}
