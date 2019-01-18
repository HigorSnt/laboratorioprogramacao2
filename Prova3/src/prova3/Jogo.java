package prova3;

public class Jogo extends Produto {
	
	public Jogo(String nome, String categoria, double valor) {
		super(nome, categoria, valor);
	}
	
	public double obterPreco() {
		if (this.categoria.equalsIgnoreCase("INFANTIL")) {
			return (this.valor - (0.05 * valor));
		}
		return this.valor;
	}
	
}
