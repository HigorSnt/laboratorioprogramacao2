package Simulado;

public class Cardapio {

	private String nomeLanchonete;
	private Item[] menu;
	private int qtdItemAdd;
	
	public Cardapio(String nomeLanchonete) {
		this.nomeLanchonete = nomeLanchonete;
		this.menu = new Item[5];
		this.qtdItemAdd = 0;
	}
	
	public Cardapio(String nomeLanchonete, int itens) {
		this.nomeLanchonete = nomeLanchonete;
		this.menu = new Item[itens];
		this.qtdItemAdd = 0;
	}
	
	public void adicionaItem(Item item) {
		this.menu[qtdItemAdd] = item;
		this.qtdItemAdd++;
	}
	
	public String listaCardapio() {
		String saida = this.nomeLanchonete + System.lineSeparator() + "NÃO FOI CADASTRADO NENHUMA COMIDA.";
		if (this.qtdItemAdd != 0) {
			for (int i = 0; i < this.menu.length; i++) {
				if (i == 0) {
					saida = this.nomeLanchonete + System.lineSeparator();
				}
				saida += (i+1) + " - " + this.menu[i].getAlimento() + " - " + this.menu[i].getCaloria() + 
						" calorias/porção." + System.lineSeparator();
			}
		}
		return saida;
	}
	
	public int calcularCaloriasRefeicao(String[] refeicao, String tamanhoRefeicao) {
		int calorias = 0;
		for (String a : refeicao) {
			boolean naoExiste = true;
			for (Item b : this.menu) {
				if (b.getAlimento().equals(a)) {
					calorias += b.getCaloria();
					naoExiste = false;
				}
			}
			if (naoExiste) {
				throw new IllegalArgumentException("ALIMENTO NÃO CADASTRADO!");
			}
		}
		
		if (tamanhoRefeicao.equalsIgnoreCase("grande")) {
			calorias *= 2;
		} else if (tamanhoRefeicao.equalsIgnoreCase("mega")) {
			calorias *= 3;
		}
		
		return calorias;
	}
	
}
