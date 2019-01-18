package HigorSantos_prova2;

public abstract class CaixaAbstract implements Caixa {
	
	private String personalizacao;
	private String formato;
	private String descricao;
	
	public CaixaAbstract(String descricao, String personalizacao, String formato) {
		if (personalizacao == null || personalizacao.trim().equals("")){
			throw new IllegalArgumentException();
		}
		if (descricao == null || descricao.trim().equals("")){
			throw new IllegalArgumentException();
		}
		if (formato == null || formato.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		if (!personalizacao.equalsIgnoreCase("ARTE EM TECIDO") && !personalizacao.equalsIgnoreCase("COLAGEM")
				&& !personalizacao.equalsIgnoreCase("PINTURA À MÃO")) {
			throw new IllegalArgumentException();
		}
		
		this.descricao = descricao;
		this.formato = formato;
		this.personalizacao = personalizacao;
	}
	
	public void setPersonalizacao(String personalizacao) {
		this.personalizacao = personalizacao;
	}
	
	public String getPersonalizacao() {
		return this.personalizacao;
	}

	public abstract double areaDaTampa();
	
	public abstract double getPreco();
	
	@Override
	public String getFormato() {
		return this.formato;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	@Override
	public String toString() {
		return "Caixa com " + this.personalizacao + " custa R$ " + 
				String.format("%2.2f", this.getPreco()) + ". Formato " + this.formato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((formato == null) ? 0 : formato.hashCode());
		result = prime * result + ((personalizacao == null) ? 0 : personalizacao.hashCode());
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
		CaixaAbstract other = (CaixaAbstract) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (formato == null) {
			if (other.formato != null)
				return false;
		} else if (!formato.equals(other.formato))
			return false;
		if (personalizacao == null) {
			if (other.personalizacao != null)
				return false;
		} else if (!personalizacao.equals(other.personalizacao))
			return false;
		return true;
	}
	
	
}
