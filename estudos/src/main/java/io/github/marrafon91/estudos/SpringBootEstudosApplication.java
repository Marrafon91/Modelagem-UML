package io.github.marrafon91.estudos;

import io.github.marrafon91.estudos.entities.Categoria;
import io.github.marrafon91.estudos.repositories.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootEstudosApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepositorio categoriaRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEstudosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritorio");

		categoriaRepositorio.saveAll(Arrays.asList(cat1, cat2));
	}
}
