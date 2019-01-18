package prova3;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	
	private int id;
	private List<Produto> produtos;
	
	public Carrinho(int id) {
		this.id = id;
		this.produtos = new ArrayList<>();
	}
	
	public void adicionaProdutoAoCarrinho(Produto produto) {
		this.produtos.add(produto);
	}
	
	public double totalizaCarrinho() {
		double total = 0;
		
		for (Produto produto : produtos) {
			total += produto.obterPreco();
		}
		return total;
	}
	
}
