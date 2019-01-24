package lab2_HigorSantos;

/**
 * Classe responsável pelo controle na situação da saúde do aluno, é analisada
 * a saúde física e a mental, e no fim é gerado um quadro geral da situação
 * da saúde do aluno.
 * 
 * A saúde do aluno pode estar fraca ou boa, caso ambas estejam fracas, a saúde geral é “fraca”, se 
 * ambas estiverem boas, a saúde geral do aluno é “boa”, se apenas uma estiver fraca ou boa, a situação
 * é "ok".
 * 
 * @author Higor Santos
 *
 */

public class Saude {
	
	/**
	 * saudeMental responsável por controlar a saúde mental do aluno.
	 * 
	 */
	private String saudeMental;

	/**
	 *saudeFisica responsável por controlar a saude física do aluno.
	 *
	 */
	private String saudeFisica;
	
	/**
	 * emoji é uma descrição da sua última sensação em geral.
	 * 
	 */
	private String emoji;
	
	/**
	 * Constrói o quadro geral da situação da saúde física e mental do 
	 * aluno, ambas são iniciadas como boa.
	 * 
	 */	
	public Saude() {
		this.saudeMental = "boa";
		this.saudeFisica = "boa";
	}
	
	/**
	 * Esse método define a situação da saúde mental do aluno.
	 * 
	 * @param valor é a situação da saúde mental de acordo com o aluno.
	 * 
	 */
	public void defineSaudeMental(String valor) {
		this.saudeMental = valor;
	}
	
	/**
	 * Esse método define a situação da saúde física do aluno.
	 * 
	 * @param valor é a situação da saúde física de acordo com o aluno.
	 * 
	 */
	public void defineSaudeFisica (String valor) {
		this.saudeFisica = valor;
	}
	
	/**
	 * Esse método define um emoji que descreve a última sensação do aluno.
	 * 
	 * @param valor é o emoji que será cadastrado.
	 */
	public void definirEmoji(String valor) {
		this.emoji = valor;
	}
	
	/**
	 * Esse método analisa a situação do quadro geral da saúde do aluno, podendo ser
	 * boa, ruim ou ok.
	 * Além disso, é retornado o emoji caso tenha sido cadastrado algum.
	 * 
	 * @return a situação da saúde do aluno.
	 * 
	 */
	public String getStatusGeral() {
		if (this.saudeFisica.equals(saudeMental)) {
			return this.saudeFisica + ((this.emoji == null) ? "" : " " + this.emoji);
		} else {
			return "ok" + ((this.emoji == null) ? "" : " " + this.emoji);
		}
	}
}
