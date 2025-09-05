package entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import entities.enums.Genero;

public class Jogador {

	private Integer id;
	private String nome;
	private Date nascimento;
	private Genero genero;
	private Double altura;

	public Jogador() {
	}

	public Jogador(Integer id, String nome, Date nascimento, Genero genero, Double altura) {
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
		if (nascimento == null) {
			return 0;
		}

		Calendar nascimentoCal = Calendar.getInstance();
		nascimentoCal.setTime(nascimento);

		Calendar hoje = Calendar.getInstance();

		int idade = hoje.get(Calendar.YEAR) - nascimentoCal.get(Calendar.YEAR);

		if (hoje.get(Calendar.MONTH) < nascimentoCal.get(Calendar.MONTH)
				|| (hoje.get(Calendar.MONTH) == nascimentoCal.get(Calendar.MONTH)
						&& hoje.get(Calendar.DAY_OF_MONTH) < nascimentoCal.get(Calendar.DAY_OF_MONTH))) {
			idade--;
		}

		return idade;
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
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = (nascimento != null) ? sdf.format(nascimento) : "N/A";
		String alturaFormatada = (altura != null) ? String.format("%.2f", altura) : "N/A";

		return nome + " (Nascimento: " + dataFormatada + ", Idade: " + getIdade() + ", Gênero: "
				+ (genero != null ? genero : "N/A") + ", Altura: " + alturaFormatada + "m)";
	}

}
