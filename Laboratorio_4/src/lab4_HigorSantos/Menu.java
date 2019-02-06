package lab4_HigorSantos;

/**
 * Classe responsável por interagir diretamente com o usuário.
 * 
 * @author Higor Santos.
 *
 */

public class Menu {
	
	public static void main(String[] args) {
		/** Responsável por chamar e realizar as operações possíveis definidas para essa aplicação. */
		MenuAux menu = new MenuAux();
		
		/** variável para armazenar a opção da operação. */
		String op;
	
		/** variáveis para auxiliar a definir qual operação será realizada. */
		final String CADASTRAR = "C", EXIBIR = "E", NOVOGRUPO = "N", ALOCAR = "A",
				REGISTRAR = "R", IMPRIMIR = "I", FECHAR = "O";
		
		do {
			/** Imprime o menu. */
			System.out.print(menu.imprimeMenu());
			op = menu.entrada().toUpperCase().trim();
			/** Verificando se o que foi digitado é aceitável. */
			
			if (op.equals("")) {
				throw new IllegalArgumentException("A ENTRADA PASSADA É VAZIA");
			} else if (op.equals(null)) {
				throw new NullPointerException("A ENTRADA PASSADA É NULA");
			}
			
			switch(op) {
			
			case CADASTRAR:
				System.out.println(menu.cadastrar());
				break;
			
			case EXIBIR:
				System.out.println(menu.consultarAluno());
				break;
			
			case NOVOGRUPO:
				System.out.println(menu.cadastrarGrupo());
				break;
			
			case ALOCAR:
				System.out.println(menu.opAlocar());
				break;
			
			case REGISTRAR:
				System.out.println(menu.registrarAluno());
				break;
			
			case IMPRIMIR:
				System.out.println(menu.imprimeAlunos());
				break;
			
			default:
				if (op.equals(FECHAR)) {
					System.out.println(System.lineSeparator() + "O PROGRAMA ESTÁ SENDO ENCERRADO!" + 
							System.lineSeparator() + "VOLTE SEMPRE! :)");
				} else {
					System.out.println("OPÇÃO INVÁLIDA! TENTE NOVAMENTE! :(" + System.lineSeparator());
				}
			}
		}while(!op.equals(FECHAR));
	}	
}