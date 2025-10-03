package io.github.marrafon91.estudos;

import io.github.marrafon91.estudos.entities.*;
import io.github.marrafon91.estudos.entities.enums.EstadoPagamento;
import io.github.marrafon91.estudos.entities.enums.TipoCliente;
import io.github.marrafon91.estudos.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringBootEstudosApplication implements CommandLineRunner {

	private final CategoriaRepositorio categoriaRepositorio;
	private final ProdutoRepositorio produtoRepositorio;
	private final EstadoRepositorio estadoRepositorio;
	private final CidadeRepositorio cidadeRepositorio;
	private final ClienteRepositorio clienteRepositorio;
	private final EnderecoRepositorio enderecoRepositorio;
	private final PedidoRepositorio pedidoRepositorio;
	private final PagamentoRepositorio pagamentoRepositorio;
	private final ItemPedidoRepositorio itemPedidoRepositorio;

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

		Estado est1 = new Estado();
		est1.setId(null);
		est1.setNome("Minas Gerais");

		Estado est2 = new Estado();
		est2.setId(null);
		est2.setNome("São Paulo");

		Cidade c1 = new Cidade();
		c1.setId(null);
		c1.setNome("Uberlandia");
		c1.setEstado(est1);

		Cidade c2 = new Cidade();
		c2.setId(null);
		c2.setNome("São Paulo");
		c2.setEstado(est2);

		Cidade c3 = new Cidade();
		c3.setId(null);
		c3.setNome("Campinas");
		c3.setEstado(est2);

		est1.getCidades().add(c1);
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepositorio.saveAll(Arrays.asList(est1, est2));
		cidadeRepositorio.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente();
		cli1.setId(null);
		cli1.setNome("Maria Silva");
		cli1.setEmail("maria@gmail.com");
		cli1.setCpfOuCnpj("36378912377");
		cli1.setTipo(TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));

		Endereco e1 = new Endereco();
		e1.setId(null);
		e1.setLogradouro("Rua flores");
		e1.setNumero("300");
		e1.setComplemento("Apto 303");
		e1.setBairro("Jardim");
		e1.setCep("38220834");
		e1.setCliente(cli1);
		e1.setCidade(c1);

		Endereco e2 = new Endereco();
		e2.setId(null);
		e2.setLogradouro("Avenida Matos");
		e2.setNumero("105");
		e2.setComplemento("Sala 800");
		e2.setBairro("Centro");
		e2.setCep("38777012");
		e2.setCliente(cli1);
		e2.setCidade(c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepositorio.save(cli1);
		enderecoRepositorio.saveAll(Arrays.asList(e1, e2));

		Pedido ped1 = new Pedido();
		ped1.setCliente(cli1);
		ped1.setEnderecoDeEntrega(e1);
		ped1.setInstante(Instant.now());

		PagamentoComCartao pagto1 = new PagamentoComCartao();
		pagto1.setEstado(EstadoPagamento.QUITADO);
		pagto1.setPedido(ped1);
		pagto1.setNumeroDeParcelas(6);

		ped1.setPagamento(pagto1);

		Pedido ped2 = new Pedido();
		ped2.setCliente(cli1);
		ped2.setEnderecoDeEntrega(e2);
		ped2.setInstante(Instant.now());

		PagamentoComBoleto pagto2 = new PagamentoComBoleto();
		pagto2.setEstado(EstadoPagamento.PENDENTE);
		pagto2.setPedido(ped2);
		pagto2.setDataVencimento(Instant.now());
		pagto2.setDataPagamento(null);

		ped2.setPagamento(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepositorio.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepositorio.saveAll(Arrays.asList(pagto1, pagto2));

		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().add(ip3);

		p1.getItens().add(ip1);
		p2.getItens().add(ip3);
		p3.getItens().add(ip2);

		itemPedidoRepositorio.saveAll(Arrays.asList(ip1, ip2, ip3));

	}
}
