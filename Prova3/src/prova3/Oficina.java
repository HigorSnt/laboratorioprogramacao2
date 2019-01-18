package prova3;

public class Oficina extends Produto {
	
	private double cargaHoraria;
	
	public Oficina(String nome, String categoria, double valor, double cargahoraria) {
		super(nome, categoria, valor);
		this.cargaHoraria = cargahoraria;
	}
	
	public double obterPreco() {
		return (this.cargaHoraria * this.valor);
	}
}
