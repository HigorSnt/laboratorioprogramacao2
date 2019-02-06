package lab4_HigorSantos;

import java.util.HashSet;

/**
 * Cria um Objeto Grupo, onde cada grupo é responsável pelo seu próprio nome e 
 * alunos que o compõe.
 * 
 * @author Higor Santos
 *
 */
public class Grupo {
	private HashSet <Aluno> componentes;
	private String nome;
	
	/**
	 * Cria um novo grupo.
	 * 
	 * @param nome é o que identificará o grupo,
	 */
	public Grupo(String nome) {
		this.nome = nome;
		this.componentes = new HashSet<>();
	}

	/** 
	 * @return Retorna o nome do grupo.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Adiciona um aluno no grupo.
	 * 
	 * @param aluno é o aluno a ser adicionado.
	 * 
	 * @return Retorna a confirmação que o aluno foi cadastrado.
	 */
	public String alocaAluno(Aluno aluno) {
		this.componentes.add(aluno);
		return "ALUNO ALOCADO!";
	}
	
	/**
	 * Pega cada aluno que está dentro do grupo e o imprime.
	 * 
	 * @return Retorna todos os alunos que foram alocados para o grupo.
	 */
	public String imprimeGrupo() {
		String saida = System.lineSeparator() + "Alunos do grupo " + this.nome + ":" + System.lineSeparator();
		
		if (this.componentes.size() == 0) {
			return saida + "NENHUM ALUNO CADASTRADO AINDA!" + System.lineSeparator();
		}
		
		for (Aluno aluno : this.componentes) {
			saida += "* " + aluno.toString() + System.lineSeparator();
		}
		return saida;
	}
}
