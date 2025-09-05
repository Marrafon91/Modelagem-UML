package entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class Partida {

	private Integer id;
	private LocalDateTime data;
	private Integer pontuacaoMandante;
	private Integer pontuacaoVisitante;

	private Time mandante;
	private Time visitante;

	public Partida() {
	}

	public Partida(Integer id, LocalDateTime data, Time mandante, Time visitante, Integer pontuacaoMandante,
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

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
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

	public String vencedor() {
		if (pontuacaoMandante > pontuacaoVisitante) {
			return mandante.getName();
		} else if (pontuacaoVisitante > pontuacaoMandante) {
			return visitante.getName();
		} else {
			return "Empate";
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
		if (obj == null || getClass() != obj.getClass())
			return false;
		Partida other = (Partida) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Partida [id=" + id + ", data=" + data + ", mandante=" + mandante.getName() + ", visitante="
				+ visitante.getName() + ", placar=" + pontuacaoMandante + "x" + pontuacaoVisitante + "]";
	}
}
