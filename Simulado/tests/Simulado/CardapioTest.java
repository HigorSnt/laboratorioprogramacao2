package Simulado;

import static org.junit.jupiter.api.Assertions.*;

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
		
		assertEquals("LancheTop" + System.lineSeparator() + "NÃO FOI CADASTRADO NENHUMA COMIDA.", c1.listaCardapio());
		assertEquals(5, c1.getTamanhoCardapio());
		assertEquals("LancheTop" + System.lineSeparator() + "NÃO FOI CADASTRADO NENHUMA COMIDA.", c2.listaCardapio());
		assertEquals(20, c2.getTamanhoCardapio());
	}

	
	@Test
	void testAdicionaItem() {
		Cardapio menu = new Cardapio("LancheTop", 2);
		menu.adicionaItem(this.a);
		menu.adicionaItem(this.e);
		assertEquals("LancheTop" + System.lineSeparator() + "1 - arroz branco - 100 calorias/porção." + System.lineSeparator() + 
				"2 - feijao verde - 90 calorias/porção." + System.lineSeparator(), menu.listaCardapio());
		Cardapio menuVazio = new Cardapio("teste", 2);
		assertEquals("teste" + System.lineSeparator() + "NÃO FOI CADASTRADO NENHUMA COMIDA.", menuVazio.listaCardapio());
	}

	@Test
	void testListaCardapio() {
		this.menu.adicionaItem(this.a);
		this.menu.adicionaItem(this.b);
		this.menu.adicionaItem(this.c);
		this.menu.adicionaItem(this.d);
		this.menu.adicionaItem(this.e);
		this.menu.adicionaItem(this.f);
		this.menu.adicionaItem(this.g);
		this.menu.adicionaItem(this.h);
		assertEquals("kjbjkf" + System.lineSeparator() + "1 - arroz branco - 100 calorias/porção." + System.lineSeparator() + 
				"2 - arroz a grega - 200 calorias/porção." + System.lineSeparator() + "3 - macarrao - 200 calorias/porção." + System.lineSeparator() + 
				"4 - feijoada - 150 calorias/porção." + System.lineSeparator() + "5 - feijao verde - 90 calorias/porção." + System.lineSeparator() + 
				"6 - frango assado - 90 calorias/porção." + System.lineSeparator() + "7 - bife - 100 calorias/porção." + System.lineSeparator() +
				"8 - vinagrete - 0 calorias/porção." + System.lineSeparator(), this.menu.listaCardapio());
	}

	@Test
	void testCalcularCaloriasRefeicao() {
		this.menu.adicionaItem(this.a);
		this.menu.adicionaItem(this.b);
		this.menu.adicionaItem(this.c);
		this.menu.adicionaItem(this.d);
		this.menu.adicionaItem(this.e);
		this.menu.adicionaItem(this.f);
		this.menu.adicionaItem(this.g);
		this.menu.adicionaItem(this.h);
		
		String[] refeicao1 = {"arroz branco", "feijoada", "vinagrete"};
		assertEquals(250, this.menu.calcularCaloriasRefeicao(refeicao1, "padrao"));
		assertEquals(500, this.menu.calcularCaloriasRefeicao(refeicao1, "grande"));
		assertEquals(750, this.menu.calcularCaloriasRefeicao(refeicao1, "mega"));
		String[] refeicao2 = {"arroz branco", "salada", "vinagrete"};
		assertThrows(IllegalArgumentException.class, ()-> this.menu.calcularCaloriasRefeicao(refeicao2, "padrao"));
	}

}
