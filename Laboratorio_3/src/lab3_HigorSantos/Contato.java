package lab3_HigorSantos;

public class Contato {
	
	private String nome;
	private String sobrenome;
	private String telefone;
	
	public Contato(String nome, String sobrenome, String telefone) {
		if (nome == null || sobrenome == null || telefone == null) {
			throw new NullPointerException("ALGUM ELEMENTO DADO É NULO");
		}
		if ("".equals(nome.trim()) || "".equals(sobrenome.trim()) || "".equals(telefone.trim())) {
			throw new IllegalArgumentException("ALGUM ELEMENTO DADO É VAZIO");
		}
		
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	@Override
	public String toString () {
		return this.nome + " " + this.sobrenome + " - " + this.telefone;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Contato other = (Contato) obj;
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		if (sobrenome == null) {
			if (other.sobrenome != null) {
				return false;
			}
		} else if (!sobrenome.equals(other.sobrenome)) {
			return false;
		}
		return true;
	}
	
}