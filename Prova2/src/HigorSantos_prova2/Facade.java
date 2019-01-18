package HigorSantos_prova2;

public class Facade {
	
	private Controller controller = new Controller();
	
	public void cadastraCaixaRetangular(String descricao, String personalizacao, String formato,
			double lado1, double lado2) {
		this.controller.cadastraCaixaRetangular(descricao, personalizacao, formato, lado1, lado2);
	}
	
	public void cadastraCaixaCircular(String descricao, String personalizacao, String formato,
			double raio) {
		this.controller.cadastraCaixaCircular(descricao, personalizacao, formato, raio);
	}
	
	public void cadastraCaixaPentagonal(String descricao, String personalizacao, String formato,
			double lado) {
		this.controller.cadastraCaixaPentagonal(descricao, personalizacao, formato, lado);
	}
	
	public void modificaPersonalizacao(String d, String p) {
		this.controller.setPersonalizacao(d, p);
	}
	
	public boolean removeCaixa(String d) {
		return this.controller.removeCaixa(d);
	}
	
	public int numeroDeCaixas() {
		return this.controller.numCaixasNoEstoque();
	}
	
	public boolean consultaCaixas(String p, String f) {
		return this.controller.consultaCaixa(p, f);
	}
	
	public String retornaCaixasPersonalizadas(String p) {
		return this.controller.retornaCaixasPersonalizacao(p);
	}
	
	public String retornaCaixasFormato(String f) {
		return this.controller.retornaCaixasFormato(f);
	}
	
	public String rendimento() {
		return this.controller.rendimento();
	}
}
