package prova3;

public abstract class Produto {
	
	protected String nome;
	protected String categoria;
	protected double valor;
	
	public Produto(String nome, String categoria, double valor) {
		this.categoria = categoria;
		this.valor = valor;
		this.nome = nome;
	}
	
	public abstract double obterPreco();
	
	public String getNome() {
		return nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public double getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return "[" + this.nome + ", " + this.categoria + ", " + 
				String.format("%.1f", this.obterPreco()) + "]";
	}
}
