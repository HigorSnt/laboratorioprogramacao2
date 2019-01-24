package Simulado;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardapioTest {
	
	public Cardapio menu = new Cardapio("kjbjkf", 8);
	
	private Item a = new Item("arroz branco", 100);
	private Item b = new Item("arroz a grega", 200);
	private Item c = new Item("macarrao", 200);
	private Item d = new Item("feijoada", 150);
	private Item e = new Item("feijao verde", 90);
	private Item f = new Item("frango assado", 90);
	private Item g = new Item("bife", 100);
	private Item h = new Item("vinagrete", 0);

	@Test
	public void testCardapioString() {
		Cardapio c1 = new Cardapio("LancheTop");
		Cardapio c2 = new Cardapio("LancheTop", 20);
		
		assertEquals("LancheTop" + System.lineSeparator() + 
				"NÃO FOI CADASTRADO NENHUMA COMIDA.", c2.listaCardapio());
	}

	
	@Test
	void testAdicionaItem() {
		Cardapio menu = new Cardapio("LancheTop", 2);
		menu.adicionaItem(a);
		menu.adicionaItem(e);
		assertEquals("LancheTop" + System.lineSeparator() + "1 - arroz branco - 100 calorias/porção." + System.lineSeparator() + 
				"2 - feijao verde - 90 calorias/porção.\n", menu.listaCardapio());
		Cardapio menuVazio = new Cardapio("teste", 2);
		assertEquals("teste\nNÃO FOI CADASTRADO NENHUMA COMIDA.", menuVazio.listaCardapio());
	}

	@Test
	void testListaCardapio() {
		menu.adicionaItem(a);
		menu.adicionaItem(b);
		menu.adicionaItem(c);
		menu.adicionaItem(d);
		menu.adicionaItem(e);
		menu.adicionaItem(f);
		menu.adicionaItem(g);
		menu.adicionaItem(h);
		assertEquals("kjbjkf\n1 - arroz branco - 100 calorias/porção.\n2 - arroz a grega - 200 calorias/porção.\n3 - macarrao - 200 calorias/porção.\n4 - feijoada - 150 calorias/porção.\n"
				+ "5 - feijao verde - 90 calorias/porção.\n6 - frango assado - 90 calorias/porção.\n7 - bife - 100 calorias/porção.\n"
				+ "8 - vinagrete - 0 calorias/porção.\n", menu.listaCardapio());
	}

	@Test
	void testCalcularCaloriasRefeicao() {
		menu.adicionaItem(a);
		menu.adicionaItem(b);
		menu.adicionaItem(c);
		menu.adicionaItem(d);
		menu.adicionaItem(e);
		menu.adicionaItem(f);
		menu.adicionaItem(g);
		menu.adicionaItem(h);
		
		String[] refeicao1 = {"arroz branco", "feijoada", "vinagrete"};
		assertEquals(250, menu.calcularCaloriasRefeicao(refeicao1, "padrao"));
		assertEquals(500, menu.calcularCaloriasRefeicao(refeicao1, "grande"));
		assertEquals(750, menu.calcularCaloriasRefeicao(refeicao1, "mega"));
		String[] refeicao2 = {"arroz branco", "salada", "vinagrete"};
		assertThrows(IllegalArgumentException.class, ()-> menu.calcularCaloriasRefeicao(refeicao2, "padrao"));
	}

}
