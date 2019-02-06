package lab3_HigorSantos;

import java.util.Arrays;

public class Agenda {
	
	private Contato[] agenda = new Contato[100];
	
	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		try {
			this.agenda[posicao - 1] = new Contato(nome, sobrenome, telefone);
			return "CADASTRO REALIZADO!" + System.lineSeparator();
		} catch (IndexOutOfBoundsException ibe) {
			return "POSIÇÃO INVÁLIDA!" + System.lineSeparator();
		}
	}
	
	public String exibeContato(int posicao) {
		return this.agenda[posicao - 1].toString();
	}
	
	public String listarContatos() {
		String print = "VOCÊ NÃO REGISTROU NENHUM CONTATO" + System.lineSeparator();
		for (int i = 0; i < this.agenda.length; i++) {
			if (this.agenda[i] != null) {
				if (i == 0) {
					print = "";
				}
			print += (i + 1) + " - " + this.agenda[i].getNome() + System.lineSeparator();
			}
		}
		return print;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(agenda);
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
		Agenda other = (Agenda) obj;
		if (!Arrays.equals(agenda, other.agenda))
			return false;
		return true;
	}
	
}
