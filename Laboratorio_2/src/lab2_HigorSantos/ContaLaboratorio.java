package lab2_HigorSantos;

/**
 * Representação da conta de alunos em laboratórios, responsável por controlar o espaço utilizado pelo aluno
 * (por padrão esse espaço é de 2GB). 
 * 
 * @author Higor Santos
 *
 */
public class ContaLaboratorio {
	
	/**
	 * cota é o limite de espaço disponível no sistema de armazenamento.
	 */
	private int cota;
	
	/**
	 * espaco é a quantidade de memória utilizada pelo usuário.
	 */
	private int espaco;
	
	/**
	 * nomeLaboratorio é a identificação do laboratório.
	 */
	private String nomeLaboratorio;
	
	/**
	 * Constrói uma conta em um determinado laboratório, quando não é dado um valor 
	 * a cota é um valor determinado.
	 * 
	 * @param nomeLaboratorio identificação do laboratório onde a conta está registrada.
	 * 
	 */
	public ContaLaboratorio (String nomeLaboratorio){
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = 2000;
	}
	
	/**
	 * Constrói uma conta em um determinado laboratório, o diferencial em relação ao anterior
	 * é que a cota se não for o valor padrão cai nesse construtor.
	 * 
	 * @param nomeLaboratorio identificação do laboratório onde a conta está registrada.
	 * @param cota é o espaço máximo que o usuário pode ocupar.
	 * 
	 */
	public ContaLaboratorio (String nomeLaboratorio, int cota){
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = cota;
	}
	
	/**
	 * Método cuja funcionalidade é controlar a quantidade de espaço
	 * utilizado pelo usuário.
	 * 
	 * @param mbytes representa o espaço que foi ocupado.
	 * 
	 */
	public void consomeEspaco(int mbytes) {
		this.espaco += mbytes;
	}
	
	/**
	 * Método cuja funcionalidade é controlar a quantidade de espaço liberado
	 * pelo usuário.
	 * 
	 * @param mbytes representa o espaço que foi desocupado.
	 * 
	 */
	public void liberaEspaco(int mbytes) {
		this.espaco -= mbytes;
	}
	
	/**
	 * Método cuja função é analisar se o usuário atingiu a cota destinada ao mesmo.
	 * 
	 * @return se o usuario atingiu o espaço destinado à sua conta.
	 * 
	 */
	public boolean atingiuCota(){
		return cota <= espaco;
	}
	
	/**
	 * Retorna uma String que representa a utilização de um certo laboratório pelo usuário. A 
	 * representação segue o formato "LABORATÓRIO - espaço utilizado/espaço destinado ao usuário".
	 * 
	 * @return o consumo de memória em sua conta em um determinado laboratório.
	 * 
	 */
	@Override
	public String toString() {
		return this.nomeLaboratorio + " " + this.espaco + "/" + this.cota;
	}

}
