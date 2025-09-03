package application;

import java.text.ParseException;
import java.time.Year;
import java.util.Locale;

import entities.Carro;
import entities.Pessoa;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);

		Pessoa p1 = new Pessoa(2031L, "Greg");
		Pessoa p2 = new Pessoa(7513L, "Jhon");
		Pessoa p3 = new Pessoa(1394L, "Maria");
		Pessoa p4 = new Pessoa(8015L, "Chris");

		Carro c1 = new Carro(1001L, "Fox", Year.of(2015));
		Carro c2 = new Carro(1002L, "Van Plus", Year.of(2017));
		Carro c3 = new Carro(1003L, "Cross Hatch", Year.of(2014));
		Carro c4 = new Carro(1004L, "Convert", Year.of(1998));

		System.out.println(p1 + " possui o " + c1);
		System.out.println(p2 + " Não possui carro. ");
		System.out.println(p3 + " possui o " + c2 + c4);
		System.out.println(p4 + " possui o " + c3);
	}

}
