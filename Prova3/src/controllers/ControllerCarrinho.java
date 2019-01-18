package controllers;

import java.util.HashMap;
import java.util.Map;

import excecoes.CarrinhoNaoCadastradoException;
import prova3.Carrinho;
import prova3.Produto;

public class ControllerCarrinho {
	
	private Map<Integer, Carrinho> carrinho = new HashMap<>();
	
	public void criaCarrinho(int id) {
		this.carrinho.put(id, new Carrinho(id));
	}
	
	public void adicionaProdutoAoCarrinho(int id, Produto produto) {
		this.carrinho.get(id).adicionaProdutoAoCarrinho(produto);
	}
	
	public double totalizaCarrinho(int id) {
		if(!this.carrinho.containsKey(id)) {
			throw new CarrinhoNaoCadastradoException();
		}
		
		return this.carrinho.get(id).totalizaCarrinho();
	}

}
