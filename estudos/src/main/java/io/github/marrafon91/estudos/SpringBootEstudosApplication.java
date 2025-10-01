package io.github.marrafon91.estudos;

import io.github.marrafon91.estudos.entities.Categoria;
import io.github.marrafon91.estudos.entities.Produto;
import io.github.marrafon91.estudos.repositories.CategoriaRepositorio;
import io.github.marrafon91.estudos.repositories.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringBootEstudosApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	@Autowired
	private ProdutoRepositorio produtoRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEstudosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria();
		cat1.setId(null);
		cat1.setNome("Informática");

		Categoria cat2 = new Categoria();
		cat2.setId(null);
		cat2.setNome("Escritório");

		Produto p1 = new Produto();
		p1.setNome("Computador");
		p1.setPreco(BigDecimal.valueOf(2000.00));

		Produto p2 = new Produto();
		p2.setNome("Impresora");
		p2.setPreco(BigDecimal.valueOf(800.00));

		Produto p3 = new Produto();
		p3.setNome("Mouse");
		p3.setPreco(BigDecimal.valueOf(80.00));

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().add(p2);

		p1.getCategorias().add(cat1);
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().add(cat1);

		categoriaRepositorio.saveAll(Arrays.asList(cat1, cat2));
		produtoRepositorio.saveAll(Arrays.asList(p1, p2, p3));
	}
}
