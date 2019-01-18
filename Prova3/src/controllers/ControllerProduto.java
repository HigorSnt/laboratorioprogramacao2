package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import comparators.ComparaPorCategoria;
import comparators.ComparaPorNome;
import comparators.ComparaPorPreco;
import excecoes.ProdutoNaoCadastradoException;
import prova3.Jogo;
import prova3.Livro;
import prova3.Oficina;
import prova3.Produto;

public class ControllerProduto {
	private Map<String, Produto> produtos;
	private String ordenacao;
	
	public ControllerProduto() {
		this.produtos = new HashMap<>();
		this.ordenacao = "NOME";
	}
	
	public void adicionaOficina (String nome, String categoria, double valor, double cargahoraria) {
		if (this.produtos.containsKey(nome)) {
			throw new IllegalArgumentException();
		}
		this.produtos.put(nome, new Oficina(nome, categoria, valor, cargahoraria));
	}
	
	public void adicionaLivro(String nome, String categoria, double valor, String estado) {
		if (this.produtos.containsKey(nome)) {
			throw new IllegalArgumentException();
		}
		this.produtos.put(nome, new Livro(nome, categoria, valor, estado));
	}
	
	public void adicionaJogo(String nome, String categoria, double valor) {
		if (this.produtos.containsKey(nome)) {
			throw new IllegalArgumentException();
		}
		this.produtos.put(nome, new Jogo(nome, categoria, valor));
	}
	
	public String exibirProduto(String nome) {
		if (!this.produtos.containsKey(nome)) {
			throw new IllegalArgumentException();
		}
		
		return this.produtos.get(nome).toString();
	}
	
	public double obterPreco(String nome) {
		if (!this.produtos.containsKey(nome)) {
			throw new IllegalArgumentException();
		}
		return this.produtos.get(nome).obterPreco();
	}
	
	public void configuraOrdenacao(String nome) {
		this.ordenacao = nome.toUpperCase();
	}
	
	public Produto existeProduto(String nome) {
		if(this.produtos.containsKey(nome)) {
			return this.produtos.get(nome);
		}
		throw new ProdutoNaoCadastradoException();
	}
	
	public String listar() {
		List<Produto> produtosOrdenados = new ArrayList<>();
		produtosOrdenados.addAll(this.produtos.values());
		
		switch (this.ordenacao) {
		case "NOME":
			Collections.sort(produtosOrdenados, new ComparaPorNome());
			break;
		case "CATEGORIA":
			Collections.sort(produtosOrdenados, new ComparaPorCategoria());
			break;
		case "PRECO":
			Collections.sort(produtosOrdenados, new ComparaPorPreco());
			break;
		}
		
		return "[" + produtosOrdenados.stream().map(p -> 
				p.toString()).collect(Collectors.joining(", ")) + " ]";
	}
}
