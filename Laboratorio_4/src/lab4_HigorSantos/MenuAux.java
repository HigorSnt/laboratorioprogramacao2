package lab4_HigorSantos;

import java.util.Scanner;

/**
 * Classe que continuará trabalhando com o usuário, mas daqui cada funcionalidade será
 * encaminhada para a classe responsável por tal operação.
 * 
 * @author Higor Santos.
 *
 */

public class MenuAux {
	
	private Scanner sc = new Scanner(System.in);
	private ControleAlunos controle = new ControleAlunos();
	
	/**
	 * Método que tem como objetivo reduzir a repetição do código.
	 * 
	 * @return Retorna uma String digitada pelo usuário.
	 */
	public String entrada() {
		return this.sc.nextLine();
	}
	
	/**
	 * Imprime o menu do programa.
	 * 
	 * @return Retorna o menu do programa.
	 */
	public String imprimeMenu() {
		return "(C)adastrar Aluno\n(E)xibir Aluno\n(N)ovo Grupo\n"
				+ "(A)locar Aluno no Grupo e Imprimir Grupos\n"
				+ "(R)egistrar Aluno que Respondeu\n(I)mprimir Alunos que Responderam\n"
				+ "(O)ra, vamos fechar o programa!\n\nOPÇÃO> ";
	}
	/**
	 * Método que pede uma matrícula, um nome e um curso e envia o pedido de cadastrar um aluno
	 * com os dados passados.
	 * 
	 * @return Retorna a resposta dada pela classe responsável por cadastrar um aluno.
	 */
	public String cadastrar() {
		String matricula, nome, curso;
		
		System.out.print("Matrícula: ");
		matricula = entrada();
		
		System.out.print("Nome: ");
		nome = entrada();
		
		System.out.print("Curso: ");
		curso = entrada();
		
		return controle.addAluno(matricula, nome, curso);
	}
	
	/**
	 * Método que pede uma matricula e envia a solicitação de consultar um aluno à classe responsável.
	 * 
	 * @return Retorna a resposta dada pela classe responsável por consultar um aluno.
	 */
	public String consultarAluno() {
		String matricula;
		System.out.print("Matrícula: ");
		matricula = entrada();
		
		return controle.consultaAluno(matricula) + "\n";	
	}

	/**
	 * Este método pede o nome de um grupo e encaminha para que seja criado um novo grupo.
	 * 
	 * @return Retorna a resposta dada pela classe responsável por criar um novo grupo.
	 */
	public String cadastrarGrupo() {
		String nomeGrupo;
		
		System.out.print("Grupo: ");
		nomeGrupo = entrada();
		
		return controle.cadastraGrupo(nomeGrupo);	
	}
	
	/**
	 * Método que pode solicitar que seja alocado um aluno em um determinado 
	 * grupo ou solicitar que seja listado os membros de um determinado grupo.
	 * 
	 * @return Retorna a resposta dada pela classe responsável pela operação que será realizada, 
	 * se caso a operação for inválida o método é encerrado.
	 */
	public String opAlocar() {
		String opcao;
		System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
		opcao = entrada().toUpperCase().trim();
		
		if(opcao.equals("A")) {
			return alocaAluno();
		} else if(opcao.equals("I")) {
			return imprimeGrupo();
		}
		
		return "OPÇÃO INVÁLIDA! TENTE NOVAMENTE! :( \n";
	}

	/**
	 * Esse método solicita uma matrícula e o nome de um grupo e é solicitado 
	 * que um determinado aluno seja alocado em um determinado grupo.
	 * 
	 * @return Retorna a resposta dada pela classe responsável por alocar um aluno
	 * em um grupo.
	 */
	private String alocaAluno() {
		String matricula, grupo;
		
		System.out.print("Matrícula: ");
		matricula = entrada();
		
		System.out.print("Grupo: ");
		grupo = entrada();
		
		return controle.alocaAluno(matricula, grupo);
	}

	/**
	 * Método que pede o nome de um grupo e solicita à classe responsável para
	 * listar todos os alunos desse grupo.
	 * 
	 * @return Retorna a resposta dada pela classe responsável por listar cada componente do grupo.
	 */
	private String imprimeGrupo() {
		String grupo;
		
		System.out.print("Grupo: ");
		grupo = entrada();
		
		return controle.imprimeGrupo(grupo);
	}

	/**
	 * Método cuja funcionalidade é enviar uma matricula informada e validada de
	 * um aluno que respondeu uma questão na sala de aula para que seja registrada. 
	 * 
	 * @return Retorna a resposta dada pela classe responsável por registrar um aluno
	 * que respondeu uma questão.
	 */
	public String registrarAluno() {
		String matricula;
		
		System.out.print("Matrícula: ");
		matricula = entrada();
		
		return controle.respondeuQuestao(matricula);
	}

	/**
	 * Método que solicita a listagem de todos os alunos que respondeu alguma questão.
	 * 
	 * @return Retorna a resposta dada pela classe responsável por listar os alunos
	 * que respondeu alguma questão.
	 */
	public String imprimeAlunos() {
		return controle.listarRespondeuQuestao();
	}
}