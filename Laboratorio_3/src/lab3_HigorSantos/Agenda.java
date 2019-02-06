package lab3_HigorSantos;

import java.util.Arrays;

public class Agenda {
	
	private Contato[] agenda = new Contato[100];
	
	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		try {
			this.agenda[posicao - 1] = new Contato(nome, sobrenome, telefone);
			return "CADASTRO REALIZADO!\n";
		} catch (IndexOutOfBoundsException ibe) {
			return "POSIÇÃO INVÁLIDA!\n";
		}
	}
	
	public String exibeContato(int posicao) {
		return this.agenda[posicao - 1].toString();
	}
	
	public String listarContatos() {
		String print = "VOCÊ NÃO REGISTROU NENHUM CONTATO\n";
		for (int i = 0; i < agenda.length; i++) {
			if (agenda[i] != null) {
				if (i == 0) {
					print = "";
				}
			print += (i + 1) + " - " + agenda[i].getNome() + "\n";
			}
		}
		return print;
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
