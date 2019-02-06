package Simulado;

public class Item {

	private String nome_comida;
	private int caloria;
	
	public Item(String nome_comida, int caloria) {
		this.nome_comida = nome_comida;
		this.caloria = caloria;
	}

	public String getNomeAlimento() {
		return this.nome_comida;
	}

	public int getCaloria() {
		return this.caloria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome_comida == null) ? 0 : nome_comida.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (nome_comida == null) {
			if (other.nome_comida != null)
				return false;
		} else if (!nome_comida.equals(other.nome_comida))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.nome_comida + ", possui " + this.caloria + " caloria(s) por porção.";
	}
	
	
}
