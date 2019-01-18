package prova3;

public class Livro extends Produto {
	
	private String estado;
	
	public Livro(String nome, String categoria, double valor, String estado) {
		super(nome, categoria, valor);
		this.estado = estado.trim().toUpperCase();
	}
	
	public double obterPreco() {
		if (this.estado.equals("USADO")){
			return (this.valor - (0.5 * this.valor));
		}
		return this.valor;
	}
	
}
