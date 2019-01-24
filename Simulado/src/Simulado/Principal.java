package Simulado;

public class Principal {
	
	public static void main(String[] args) {
		
		Item alimento1 = new Item("arroz branco", 100);
		Item alimento2 = new Item("feijoada", 150);
		Item alimento3 = new Item("vinagrete", 0);
		Item alimento4 = new Item("bife", 100);
		Item alimento5 = new Item("feijao", 90);
		
		Cardapio c1 = new Cardapio("teste");
		c1.adicionaItem(alimento1);
		c1.adicionaItem(alimento2);
		c1.adicionaItem(alimento3);
		c1.adicionaItem(alimento4);
		c1.adicionaItem(alimento5);
		String[] refeicao = {"arroz branco", "feijoada", "vinagrete"};
		System.out.println(c1.listaCardapio());
		System.out.println(c1.calcularCaloriasRefeicao(refeicao, "grande"));
	}

}
