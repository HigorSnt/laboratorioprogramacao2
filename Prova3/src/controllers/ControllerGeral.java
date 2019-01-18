package controllers;

public class ControllerGeral {
	
	private ControllerProduto cp = new ControllerProduto();
	private ControllerCarrinho cc = new ControllerCarrinho();
	
	public void adicionaOficina (String nome, String categoria, double valor, double cargahoraria) {
		this.cp.adicionaOficina(nome, categoria, valor, cargahoraria);
	}
	
	public void adicionaLivro(String nome, String categoria, double valor, String estado) {
		this.cp.adicionaLivro(nome, categoria, valor, estado);
	}
	
	public void adicionaJogo(String nome, String categoria, double valor) {
		this.cp.adicionaJogo(nome, categoria, valor);
	}
	
	public String exibirProduto(String nome) {
		return this.cp.exibirProduto(nome);
	}
	
	public double obterPreco(String nome) {
		return this.cp.obterPreco(nome);
	}
	
	public void criaCarrinho(int id) {
		this.cc.criaCarrinho(id);
	}
	
	public void adicionaProdutoAoCarrinho(int id, String nomeProduto) {
		this.cc.adicionaProdutoAoCarrinho(id, this.cp.existeProduto(nomeProduto));
	}
	
	public double totalizaCarrinho(int id) {
		return this.cc.totalizaCarrinho(id);
	}
	
	public void configuraOrdenacao(String ord) {
		this.cp.configuraOrdenacao(ord);
	}
	
	public String listar() {
		return this.cp.listar();
	}
	
}
