package lab2_HigorSantos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
	
	/**
	 * Representa um aluno.
	 */
	private static Aluno aluno;
		
	/**
	 * Construtor de Menu.
	 */
	public Menu() {
		aluno = new Aluno();
	}
	
	/**
	 * Método que captura os comandos dados.
	 * 
	 * @param aluno
	 */
	private static void controle(String[] args) {
		while (true) {
			
			if (args[0].equals("1")) {
				aluno.cadastraLaboratorio(args[1]);
			} else if (args[0].equals("2")) {
				aluno.cadastraLaboratorio(args[1], Integer.parseInt(args[2]));
			} else if (args[0].equals("3")) {
				aluno.cadastraCantina(args[1]);
			} else if (args[0].equals("4")) {
				aluno.cadastraDisciplina(args[1]);
			} else if (args[0].equals("5")) {
				aluno.consomeEspaco(args[1], Integer.parseInt(args[2]));
			} else if (args[0].equals("6")) {
				aluno.liberaEspaco(args[1], Integer.parseInt(args[2]));
			} else if (args[0].equals("7")) {
				aluno.laboratorioToString(args[1]);
			} else if (args[0].equals("8")) {
				aluno.atingiuCota(args[1]);
			} else if (args[0].equals("9")) {
				aluno.cadastraHoras(args[1], Integer.parseInt(args[2]));
			} else if (args[0].equals("10")) {
				aluno.cadastraNota(args[1], Integer.parseInt(args[2]), Double.parseDouble(args[3]));
			} else if (args[0].equals("11")) {
				aluno.aprovado(args[1]);
			} else if (args[0].equals("12")) {
				aluno.disciplinaToString(args[1]);
			} else if (args[0].equals("13")) {
				aluno.cadastraLanche(args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]));
			} else if (args[0].equals("14")) {
				aluno.pagarConta(args[1], Integer.parseInt(args[2]));
			} else if (args[0].equals("15")) {
				aluno.getFaltaPagar(args[1]);
			} else if (args[0].equals("16")) {
				aluno.listarDetalhes(args[1]);
			} else if (args[0].equals("17")) {
				aluno.cantinaToString(args[1]);
			} else if (args[0].equals("18")) {
				aluno.defineSaudeFisica(args[1]);
			} else if (args[0].equals("19")) {
				aluno.defineSaudeMental(args[1]);
			} else if (args[0].equals("20")) {
				aluno.defineEmoji(args[1]);
			} else if (args[0].equals("21")) {
				aluno.getStatusGeral();
			} else {
				System.out.println("OPÇÃO INEXISTENTE");
				break;
			}
		}
	}
	
	/**
	 * 
	 * Método que imprime as opcoes em controle.
	 */
	public static void opcoes() {
		System.out.println("________________________ MENU ________________________" + System.lineSeparator());
		System.out.println("POSSÍVEIS COMANDOS");
		System.out.println("1. CADASTRA LABORATORIO SEM COTA");
		System.out.println("2. CADASTRA LABORATORIO COM COTA");
		System.out.println("3. CADASTRA CANTINA");
		System.out.println("4. CADASTRA DISCIPLINA");
		System.out.println("5. CONSOME");
		System.out.println("6. LIBERA");
		System.out.println("7. LABORATORIOTOSTRING");
		System.out.println("8. ATINGIU COTA");
		System.out.println("9. CADASTRA HORAS");
		System.out.println("10. CADASTRA NOTA");
		System.out.println("11. APROVADO");
		System.out.println("12. DISCIPLINATOSTRING");
		System.out.println("13. CADASTRA LANCHE");
		System.out.println("14. PAGAR CONTA");
		System.out.println("15. FALTA PAGAR");
		System.out.println("16. LISTAR DETALHES");
		System.out.println("17. CANTINATOSTRING");
		System.out.println("18. DEFINE SAUDE FISICA");
		System.out.println("19. DEFINE SAUDE MENTAL");
		System.out.println("20. DEFINE EMOJI");
		System.out.println("21. GET STATUS GERAL");
	}
	
	public static void main(String[] args) {
		opcoes();
		controle(args);
	}
}
