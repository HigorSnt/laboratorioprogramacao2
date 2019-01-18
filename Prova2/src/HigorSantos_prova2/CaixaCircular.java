package HigorSantos_prova2;

public class CaixaCircular extends CaixaAbstract{
	
	private double raio;
	
	public CaixaCircular(String descricao, String personalizacao, String formato,
			double raio) {
		super(descricao, personalizacao, formato);
		this.raio = raio;
	}
	
	@Override
	public double areaDaTampa() {
		return (Math.pow(raio, 2) * 3.14);
	}
	
	@Override
	public double getPreco() {
		return 0.1 * areaDaTampa();
	}
}
