package prova3;

import controllers.ControllerGeral;

public class Facade {
	private ControllerGeral cg;
	
	public Facade() {
		this.cg = new ControllerGeral();
	}
	
	public void adicionaOficina (String nome, String categoria, double valor, double cargahoraria) {
		this.cg.adicionaOficina(nome, categoria, valor, cargahoraria);
	}
	
	public void adicionaLivro(String nome, String categoria, double valor, String estado) {
		this.cg.adicionaLivro(nome, categoria, valor, estado);
	}
	
	public void adicionaJogo(String nome, String categoria, double valor) {
		this.cg.adicionaJogo(nome, categoria, valor);
	}
	
	public String exibirProduto(String nome) {
		return this.cg.exibirProduto(nome);
	}
	
	public double obterPreco(String nome) {
		return this.cg.obterPreco(nome);
	}
	
	public void adicionaProdutoAoCarrinho(int id, String nomeProduto) {
		this.cg.adicionaProdutoAoCarrinho(id, nomeProduto);
	}
	
	public void configuraOrdenacao(String ord) {
		this.cg.configuraOrdenacao(ord);
	}
	
	public void criaCarrinho(int id) {
		this.cg.criaCarrinho(id);
	}
	
	public double totalizaCarrinho(int id) {
		return this.cg.totalizaCarrinho(id);
	}
	
	public String listar() {
		return this.cg.listar();
	}
}
