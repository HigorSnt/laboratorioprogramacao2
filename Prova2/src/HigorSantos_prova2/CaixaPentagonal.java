package HigorSantos_prova2;

public class CaixaPentagonal extends CaixaAbstract{
	
	private double lado;
	
	public CaixaPentagonal(String descricao, String personalizacao, String formato,
			double lado) {
		super(descricao, personalizacao, formato);
		this.lado = lado;
	}
	
	private double altura() {
		return (this.lado / 2 * Math.sqrt(5) + 2 * Math.sqrt(5)) / 2;
	}
	
	@Override
	public double areaDaTampa() {
		return 5.0 * (this.lado * altura()) / 2.0;
	}
	
	@Override
	public double getPreco() {
		return (0.1 * areaDaTampa());
	}
}
