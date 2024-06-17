package com.ellenmateus.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ellenmateus.cursomc.domain.Categoria;
import com.ellenmateus.cursomc.domain.Cidade;
import com.ellenmateus.cursomc.domain.Cliente;
import com.ellenmateus.cursomc.domain.Endereco;
import com.ellenmateus.cursomc.domain.Estado;
import com.ellenmateus.cursomc.domain.Produto;
import com.ellenmateus.cursomc.domain.enums.TipoCliente;
import com.ellenmateus.cursomc.repositories.CategoriaRepository;
import com.ellenmateus.cursomc.repositories.CidadeRepository;
import com.ellenmateus.cursomc.repositories.ClienteRepository;
import com.ellenmateus.cursomc.repositories.EnderecoRepository;
import com.ellenmateus.cursomc.repositories.EstadoRepository;
import com.ellenmateus.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository EnderecoRepository;
	
	 
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	
	@Override
	public void run(String... args ) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Informatica",null);
		Categoria cat2 = new Categoria(null, "Escritorio",null);
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
		
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto (null, "Impressora", 800.00);
		Produto p3 = new Produto (null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		
		
		
		Estado est1 = new Estado (null, "Minas Gerais");
		Estado est2 = new Estado (null, "Sao Paulo");
				
		
		Cidade c1 =new Cidade(null, "Uberlandia" , est1);
		Cidade c2 =new Cidade(null, "Sao Paulo" , est2);
		Cidade c3 =new Cidade(null, "Campinas" , est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		
		
		
		Cliente cli1= new Cliente (null, "Maria Silva", null,  "36378912377", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 =new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		EnderecoRepository.saveAll(Arrays.asList(e1, e2));
		
	
	}

}
