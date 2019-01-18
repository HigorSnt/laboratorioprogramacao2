package HigorSantos_prova2;

public class CaixaRetangular extends CaixaAbstract{
	
	private double lado1;
	private double lado2;
	
	public CaixaRetangular(String descricao, String personalizacao, String formato,
			double lado1, double lado2) {
		super(descricao, personalizacao, formato);
		this.lado1 = lado1;
		this.lado2 = lado2;
	}
	
	@Override
	public double areaDaTampa() {
		return lado1 * lado2;
	}
	
	@Override
	public double getPreco() {
		return (0.1 * areaDaTampa());
	}
}
