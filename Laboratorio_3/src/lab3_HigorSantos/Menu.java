package lab3_HigorSantos;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);

		/** variável para guardar a posição do contato */
		int posicao;
		
		// variável para armazenar o nome a ser cadastrado
		String nome;
		
		// variável para armazenar o sobrenome da pessoa a ser cadastrada
		String sobrenome;
		
		// variável para armazenar o número do telefone a ser cadastrado
		String telefone;
		
		// variável cuja função é verificar a operação que será realizada
		String op;
		
		// variável que cria uma agenda para armazenar seus contatos
		Agenda novoContato = new Agenda();

		do {
			exibeMenu();
			op = sc.nextLine().trim().toUpperCase();
			
			// analisando a operação que o usuário deseja realizar
			switch(op) {
			
			case "C":
				System.out.print("\nPosição: ");
				posicao = sc.nextInt();
				sc.nextLine();
				
				System.out.print("Nome: ");
				nome = sc.next();
				sc.nextLine();
				
				System.out.print("Sobrenome: ");
				sobrenome = sc.next();
				sc.nextLine();
				
				System.out.print("Telefone: ");
				telefone = sc.nextLine();
				
				// cadastra o usuário e informa se o cadastro ocorreu de maneira correta
				System.out.println(novoContato.cadastraContato(posicao, nome, sobrenome, telefone));
				break;
			
			case "E":
				System.out.print("Contato> ");
				posicao = sc.nextInt();
				sc.nextLine();
				System.out.println("\n" + novoContato.exibeContato(posicao) + "\n");
				break;
			
			case "L":
				System.out.println();
				System.out.println(novoContato.listarContatos());
				break;
			
			default:
				if (op.equals("S")) {
					System.out.println("Programa Encerrado!");
				} else {
					System.out.println("OPÇÃO INVÁLIDA!\n");
				}
			}
		}while(!op.equals("S"));
		sc.close();
	}

	private static void exibeMenu() {
		System.out.println("(C)adastrar Contato");
		System.out.println("(L)istar Contatos");
		System.out.println("(E)xibir Contato");
		System.out.println("(S)air\n");
		System.out.print("Opção> ");
	}
	
}
