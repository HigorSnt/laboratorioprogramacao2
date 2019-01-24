package lab2_HigorSantos;

import java.util.Arrays;

/**
 * Classe responsável por registrar as notas dos alunos, calcular a média dos mesmos
 * e definir a situação (aprovado ou reprovado).
 * Um aluno é aprovado quando possui média maior ou igual a 7, e se caso alguma nota
 * não for registrada equivale a 0.
 * 
 * @author Higor Santos
 *
 */

public class Disciplina {
	
	/**
	 * nomeDisciplina é o nome da matéria que terá as notas cadastradas.
	 */
	private String nomeDisciplina;
	
	/**
	 * horas é o número de horas trabalhadas.
	 */
	private int horas;
	
	/**
	 * notas é um array cujo elementos são as 4 notas do aluno.
	 */
	private double[] notas;

	/**
	 * numNotas armazena a quantidade de notas que serão dadas.
	 */
	private int numNotas;
	
	/**
	 * pesos é um array que armazenará os pesos de cada nota, caso necessário.
	 */
	private int[] pesos;
	
	/**
	 * Constrói uma disciplina a partir de um nome, e considera como
	 * padrão possuir 4 notas.
	 * Por padrão o array de notas se inicializa com 0.
	 * 
	 * @param nomeDisciplina é o nome da disciplina a ser registrada.
	 * 
	 */
	public Disciplina (String nomeDisciplina){
		this.nomeDisciplina = nomeDisciplina;
		this.numNotas = 4;
		this.notas = new double[this.numNotas];
		inicializaNotas();
	}
	
	/**
	 * Constrói uma disciplina a partir de um nome, e o usuário que
	 * irá informar quantas notas serão utilizadas para formas a média.
	 * Por padrão o array de notas se inicializa com 0.
	 * 
	 * @param nomeDisciplina é o nome da disciplina a ser registrada.
	 * @param numNotas é a quantidade de notas que serão registradas.
	 * 
	 */
	public Disciplina(String nomeDisciplina, int numNotas) {
		this.nomeDisciplina = nomeDisciplina;
		this.numNotas = numNotas;
		this.notas = new double[this.numNotas];
		inicializaNotas();
	}
	
	/**
	 * Assim como os construtores anteriores esse constrói um objeto do tipo Disciplina
	 * onde cada uma possui um nome, uma certa quantidade de notas e, nesse caso, pesos.
	 * Por padrão o array de notas se inicializa com 0.
	 * 
	 * @param nomeDisciplina simboliza o nome da Disciplina que está sendo cadastrada.
	 * @param numNotas é a quantidade de notas da disciplina.
	 * @param vetor são os pesos de cada nota, um peso de uma certa posição refere-se a nota
	 * da mesma posição.
	 * 
	 */
	public Disciplina(String nomeDisciplina, int numNotas, int[] vetor) {
		this.nomeDisciplina = nomeDisciplina;
		this.numNotas = numNotas;
		this.notas = new double[this.numNotas];
		this.pesos = vetor;
		inicializaNotas();
	}
	
	/**
	 * Método criado para inicializar o vetor notas com todas as posições valendo 0 e
	 * dessa forma evitar repetição de código.
	 * 
	 */
	private void inicializaNotas() {
		for (int i = 0; i < this.numNotas; i++) {
			this.notas[i] = 0;
		}
	}
	
	/**
	 * Cadastra as horas da disciplina registrada.
	 * 
	 * @param horas representa as horas trabalhadas.
	 * 
	 */
	public void cadastraHoras(int horas) {
		this.horas = horas;
	}
	
	/**
	 * Registra notas em um array de 4 posições, onde cada posição representa uma nota.
	 * 
	 * @param nota é a nota que irá ser registrada.
	 * @param valorNota é a nota que será registrada.
	 * 
	 */
	public void cadastraNota (int nota, double valorNota) {
		this.notas[nota - 1] = valorNota;
	}
	
	/**
	 * Método que irá calcular a média. O somatorio das notas (representado pela variável somaNotas) 
	 * e dos pesos sempre iniciam como 0. Em seguida, se caso o vetor peso for null, ou seja, 
	 * não foi definido durante os registros então a média será aritmética (para esse caso, somaPesos 
	 * servirá como uma espécie de contador de elementos), caso o vetor pesos tenha algum valor registrado, 
	 * então ele fará uma média ponderada.
	 * 
	 * @return o valor da média, caso seja aritmética será a soma das notas com a quantidade de elementos, caso seja
	 * ponderada será a soma das notas multiplicada pelo peso divido pela soma de todos os pesos.
	 * 
	 */
	private double calculaMedia() {
		double somaNotas = 0;
		int somaPesos = 0;
		if (this.pesos != null) {
			for(int i = 0; i < this.notas.length; i++) {
				somaNotas += this.notas[i] * this.pesos[i];
				somaPesos += this.pesos[i];
			}
		}else {
			for(int i = 0; i < this.notas.length; i++) {
				somaNotas += this.notas[i];
				somaPesos += 1;
			}
		}
		return somaNotas / somaPesos;
	}
	
	/**
	 * Analisa se o aluno possui nota ideal para ser aprovado, ou seja, verifica
	 * se a média do aluno é maior ou igual a 7 sendo, nesse caso, aprovado. Caso contrário
	 * reprovado.
	 * 
	 * @return verdadeiro se o aluno está aprovado, se não falso.
	 * 
	 */
	public boolean aprovado() {
		return calculaMedia() >= 7.0;
	}
	
	/**
	 * Retorna uma String cuja representação é da disciplina cadastrada e suas características. A saída é da seguinte maneira:
	 * "DISCIPLINA HORAS MEDIA [NOTA1, NOTA2, NOTA3, NOTA4]".
	 * 
	 * @return a situação do aluno em uma determinada disciplina.
	 * 
	 */
	@Override
	public String toString() {
		return this.nomeDisciplina + " " + this.horas + " " + calculaMedia() + " " + Arrays.toString(this.notas);
	}
	
}
