package HigorSantos_prova2;

public interface Caixa extends Comparable<Caixa>{
	
	
	public String toString();

	public void setPersonalizacao(String personalizacao);
	
	public String getFormato();
	
	public String getPersonalizacao();
	
	public String getDescricao();
	
	public double areaDaTampa();
	
	public double getPreco();
	
	@Override
	public default int compareTo(Caixa o) {
		return this.getDescricao().compareTo(o.getDescricao());
	}
}
