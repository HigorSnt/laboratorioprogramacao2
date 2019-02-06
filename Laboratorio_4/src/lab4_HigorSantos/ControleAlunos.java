package lab4_HigorSantos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Essa classe cria um objeto do tipo ControleAlunos que permite criar e controlar alunos
 * e grupos.
 * 
 * @author Higor Santos
 *
 */
public class ControleAlunos {
	
	private HashMap <String, Aluno> alunos;
	private ArrayList<Grupo> grupos;
	private ArrayList<Aluno> respondeuNoQuadro;
	
	public ControleAlunos() {
		 this.alunos = new HashMap<>();
		 this.grupos = new ArrayList<>();
		 this.respondeuNoQuadro = new ArrayList<>();
	}
	
	/**
	 * Esse método inicialmente verifica se a matricula recebida já está cadastrada,
	 * sendo criado e cadastrado um novo aluno somente quando a matrícula não está cadastrada.
	 * 
	 * @param matricula é o valor chave e um parametro para criar um aluno.
	 * @param nome é usado para criar um novo aluno.
	 * @param curso é usado para criar um novo aluno. 
	 * 
	 * @return Retorna um aviso de sucesso caso a matrícula não tenha sido cadastrada ainda ou 
	 * um aviso de que a matricula já havia sido cadastrada.
	 */
	public String addAluno(String matricula, String nome, String curso) {
		verificaExcecao(matricula);
		verificaExcecao(nome);
		verificaExcecao(curso);
		
		if (this.alunos.containsKey(matricula)){
			return "MATRÍCULA JÁ CADASTRADA!" + System.lineSeparator();
		}
		
		this.alunos.put(matricula, new Aluno(matricula, nome, curso));
		return "CADASTRO REALIZADO!" + System.lineSeparator();
	}
	
	/**
	 * Método que dado uma matrícula será verificado se essa matrícula está mesmo
	 * cadastrada e, em caso afirmativo, devolve uma representação do mesmo.
	 * 
	 * @param matricula é o identificador do aluno procurado.
	 * 
	 * @return Retorna uma representação do aluno pedido, caso ele exista, ou um 
	 * aviso, caso a matrícula não esteja cadastrada.
	 */
	public String consultaAluno(String matricula) {
		verificaExcecao(matricula);
		
		if (!this.alunos.containsKey(matricula)){
			return "ALUNO NÃO CADASTRADO!";
		}
		
		return "Aluno: " + this.alunos.get(matricula).toString();
	}
	
	/**
	 * Método que recebe um nome e itera sobre uma lista de grupos para verificar se 
	 * o nome passado já está cadastrado. Se caso esteja cadastrado a execução do método
	 * para, se não é criado um novo grupo. 
	 * Nomes de grupos são considerados iguais quando dois grupos possuem os mesmos caracteres
	 * na mesma posição independente se estão em maiúsculo ou minúsculo.
	 * 
	 * @param nomeGrupo é o nome a ser cadastrado.
	 * 
	 * @return Retorna um aviso caso o nome passado já exista, ou informa que
	 * a operação foi bem sucedida, caso o nome passado não exista.
	 */
	public String cadastraGrupo(String nomeGrupo) {
		verificaExcecao(nomeGrupo);
		
		for (Iterator<Grupo> iterator = this.grupos.iterator(); iterator.hasNext();) {
			Grupo grupo = (Grupo) iterator.next();
			if (grupo.getNome().equalsIgnoreCase(nomeGrupo)) {
				return "GRUPO JÁ CADASTRADO!" + System.lineSeparator();
			}
		}
		this.grupos.add(new Grupo(nomeGrupo));
		return "CADASTRO REALIZADO!" + System.lineSeparator();
	}
	
	/**
	 * Esse método verifica se a matrícula passada existe. Caso exista irá verificar se o
	 * nome do grupo passado existe. Se ambos existem o aluno é encaminhado
	 * para ser cadastrado no grupo.
	 * Caso a matricula ou o grupo não exista o método é encerrado.
	 * 
	 * @param matricula é a matrícula que representa um aluno.
	 * @param nomeGrupo é a identificação de um grupo.
	 * 
	 * @return Retorna um aviso caso a matrícula ou o grupo não existam, ou a informação
	 * que o aluno foi cadastrado com sucesso.
	 */
	public String alocaAluno(String matricula, String nomeGrupo) {
		verificaExcecao(matricula);
		verificaExcecao(nomeGrupo);
		
		if (!alunos.containsKey(matricula)) {
			return "ALUNO NÃO CADASTRADO!" + System.lineSeparator();
		}
		
		for (Iterator<Grupo> iterator = this.grupos.iterator(); iterator.hasNext();) {
			Grupo grupo = (Grupo) iterator.next();
			if (grupo.getNome().equalsIgnoreCase(nomeGrupo)) {
				grupo.alocaAluno(alunos.get(matricula));
				return "ALUNO ALOCADO!" + System.lineSeparator();
			}
		}
		
		return "GRUPO NÃO CADASTRADO!" + System.lineSeparator();
	}
	
	/**
	 * Dado um certo nome de grupo, se ele estiver cadastrado será listado cada aluno
	 * contido no grupo. Caso o grupo não exista o método encerra.
	 * 
	 * @param nomeGrupo é o grupo procurado.
	 * 
	 * @return Retorna todos os alunos presentes no grupo, ou um aviso caso o
	 * grupo pedido não exista.
	 */
	public String imprimeGrupo(String nomeGrupo) {
		verificaExcecao(nomeGrupo);
		
		for (Iterator<Grupo> iterator = grupos.iterator(); iterator.hasNext();) {
			Grupo grupo = (Grupo) iterator.next();
			if(grupo.getNome().equalsIgnoreCase(nomeGrupo)) {
				return grupo.imprimeGrupo();
			}
		}
		
		return "GRUPO NÃO CADASTRADO." + System.lineSeparator();
	}
	
	/**
	 * Dado uma matrícula, será verificado inicialmente se existe realmente um
	 * aluno com essa matrícula. Caso exista o aluno é registrado como quem
	 * respondeu uma questão no quadro
	 * 
	 * @param matricula é o identificador do aluno.
	 * 
	 * @return Retorna a confirmação do cadastramento, ou um aviso caso a matricula
	 * não corresponda a nenhum aluno cadastrado.
	 */
	public String respondeuQuestao(String matricula) {
		verificaExcecao(matricula);
		
		if (!alunos.containsKey(matricula)) {
			return "ALUNO NÃO CADASTRADO!" + System.lineSeparator();
		}
		
		this.respondeuNoQuadro.add(this.alunos.get(matricula));
		return "ALUNO REGISTRADO!" + System.lineSeparator();
	}
	
	/**
	 * Ao ser chamado esse método lista todos os alunos que responderam questões
	 * no quadro.
	 * 
	 * @return Retorna todos os alunos que foram cadastrados ao responder 
	 * questões no quadro.
	 */
	public String listarRespondeuQuestao() {
		String saida = "Alunos:" + System.lineSeparator();
		
		if (this.respondeuNoQuadro.size() == 0) {
			return saida + "NENHUM ALUNO CADASTRADO AINDA!" + System.lineSeparator();
		}
		
		for (int i = 0; i < this.respondeuNoQuadro.size(); i++) {
			Aluno aluno = this.respondeuNoQuadro.get(i);
			saida += (i + 1) + ". " + aluno.toString() + System.lineSeparator();
		}
		
		return saida;
	}
	
	/**
	 * Método que serve para validar um determinado dado informado.
	 * 
	 * @param op é o dado que irá ser validado.
	 */
	private void verificaExcecao(String op) {
		if (op == null) {
			throw new NullPointerException("A ENTRADA PASSADA É NULA");
		} else if (op.trim().equals("")) {
			throw new IllegalArgumentException("A ENTRADA PASSADA É VAZIA");
		}
	}
	
}