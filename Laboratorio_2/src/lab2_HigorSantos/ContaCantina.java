package lab2_HigorSantos;

/**
 * Classe responsável pelo controle dos gastos do aluno na cantina, entre as funcionalidades estão
 * registrar novas compras e o pagamento, além das dívidas.
 * 
 * @author Higor Santos
 *
 */

public class ContaCantina {
	
	/**
	 * nomeDaCantina é o nome do local onde está realizando a compra/ pagamento dos lanches.
	 */
	private String nomeDaCantina;
	
	/**
	 * qtdItens é a quantidade de itens comprados na cantina.
	 */
	private int qtdItens = 0;
	
	/**
	 * valorCentavos é o valor dos produtos comprados, convertidos para centavos.
	 */
	private int valorCentavos = 0;
	
	/**
	 * lanchesCadastrados é a quantidade de lanches registrados desde o início.
	 */
	private int lanchesCadastrados = 0;
	
	/**
	 * detalhes é um pequeno texto descrevendo o lanche.
	 */
	private String[] detalhes = {"NÃO CADASTRADO AINDA!","NÃO CADASTRADO AINDA!","NÃO CADASTRADO AINDA!",
			"NÃO CADASTRADO AINDA!","NÃO CADASTRADO AINDA!"};
	
	/**
	 * qtdDetalhes é a quantidade de detalhes cadastrados na cantina.
	 */
	private int qtdDetalhes = 0;
	
	/**
	 * Constrói a representação de uma cantina com determinado nome que
	 * que será dado como referência.
	 * 
	 * @param nomeDaCantina é o nome do estabelecimento que teve a compra dos lanches cadastrados.
	 * 
	 */
	public ContaCantina(String nomeDaCantina){
		this.nomeDaCantina = nomeDaCantina;
	}
	
	/**
	 * Método cuja função é cadastrar os lanches.
	 * 
	 * @param qtdItens é referente a quantidade de produtos comprados.
	 * @param valorCentavos é o valor pago pelo lanches que estão sendo cadastrados.
	 * 
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos) {
		this.qtdItens += qtdItens;
		this.valorCentavos += valorCentavos;
		this.lanchesCadastrados += valorCentavos;
	}
	
	/**
	 * Método cuja função é cadastrar os lanches.
	 * 
	 * @param qtdItens é referente a quantidade de produtos comprados.
	 * @param valorCentavos é o valor pago pelo lanches que estão sendo cadastrados.
	 * @param detalhes é um pequeno texto descrevendo o lanche.
	 * 
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos, String detalhes) {
		this.qtdItens += qtdItens;
		this.valorCentavos += valorCentavos;
		this.lanchesCadastrados += valorCentavos;
		cadastraDetalhe(detalhes);
	}
	
	/**
	 * Método que cadastra algum detalhe informado pra o lanche.
	 * 
	 * @param detalhe é um pequeno texto descrevendo o lanche.
	 * 
	 */
	private void cadastraDetalhe(String detalhe) {
		if (this.qtdDetalhes < 5) {
			this.detalhes[this.qtdDetalhes] = detalhe;
		} else {
			this.detalhes[0] = this.detalhes[1];
			this.detalhes[1] = this.detalhes[2];
			this.detalhes[2] = this.detalhes[3];
			this.detalhes[3] = this.detalhes[4];
			this.detalhes[4] = detalhe;
		}
		this.qtdDetalhes++;
	}
	
	/**
	 * Método que lista as últimas 5 descrições cadastradas. 
	 * 
	 * @return as últimas 5 descrições cadastradas.
	 *  
	 */
	public String listarDetalhes() {
		String string = "";
		for (int i = 0; i < 5; i++) {
			string += String.format("%d - " +  detalhes[i] + System.lineSeparator(), i + 1);
		}
		return string;
	}
	
	/**
	 * Registra os pagamentos de dívidas pendentes.
	 * 
	 * @param valorCentavos é o valor pago em centavos.
	 * 
	 */
	public void pagaConta(int valorCentavos) {
		this.valorCentavos -= valorCentavos;
	}
	
	/**
	 * Método que informa o quanto ainda tem de dívida na cantina.
	 * 
	 * @return o valor (em centavos) do quanto ainda deve.
	 * 
	 */
	public int getFaltaPagar() {
		return this.valorCentavos;
		
	}
	
	/**
	 * Método cuja utilidade é indicar o histórico de compras em uma determinada cantina.
	 * 
	 * @return quantos lanches foram comprados e o seu total (em centavos) dos gastos na cantina.
	 * 
	 */
	@Override
	public String toString() {
		return this.nomeDaCantina + " " + this.qtdItens + " " + this.lanchesCadastrados;
		
	}

}
