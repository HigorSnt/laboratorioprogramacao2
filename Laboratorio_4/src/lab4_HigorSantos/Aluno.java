package lab4_HigorSantos;

/**
 * Classe que cria um Aluno que é responsável pelo seu próprio nome,
 * matrícula e curso.
 * 
 * @author Higor Santos.
 *
 */
public class Aluno {
	private String matricula;
	private String nome;
	private String curso;
	
	/**
	 * Cria um novo aluno.
	 * 
	 * @param matricula
	 * @param nome
	 * @param curso
	 */
	public Aluno(String matricula, String nome, String curso) {
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}

	/**
	 * @return Retorna a matrícula do aluno.
	 */
	public String getMatricula() {
		return this.matricula;
	}

	/**
	 * @return Retorna o nome do aluno.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * @return Retorna o curso do aluno.
	 */
	public String getCurso() {
		return this.curso;
	}
	
	/**
	 * Método que serve para validar um determinado dado informado.
	 * 
	 * @param op é o dado que irá ser validado.
	 */
	public void verificaExcecao(String op) {
		if (op.equals("")) {
			throw new IllegalArgumentException("A ENTRADA PASSADA É VAZIA");
		} else if (op.equals(null)) {
			throw new NullPointerException("A ENTRADA PASSADA É NULA");
		}
	}

	@Override
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
	
		Aluno other = (Aluno) obj;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
