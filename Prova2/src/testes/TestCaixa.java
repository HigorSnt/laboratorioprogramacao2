package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import HigorSantos_prova2.CaixaCircular;
import HigorSantos_prova2.CaixaPentagonal;
import HigorSantos_prova2.CaixaRetangular;

class TestCaixa {
	
	private CaixaRetangular caixaR;
	private CaixaCircular caixaC;
	private CaixaPentagonal caixaP;
	
	@BeforeEach
	public void cadastraCaixas() {
		caixaR = new CaixaRetangular("Caixa de presente", "Arte em tecido", "retangular", 5.0, 6.0);
		caixaC = new CaixaCircular("Caixa2", "Pintura à mão", "circular", 5.0);
		caixaP = new CaixaPentagonal("Caixa1", "Colagem", "pentagonal", 5.0);
	}
	
	@Test
	public void testConstrutor() {
		assertThrows(IllegalArgumentException.class, ()-> new CaixaRetangular("Caixa de presente", null, "retangular", 5.0, 6.0));
		assertThrows(IllegalArgumentException.class, ()-> new CaixaRetangular("Caixa de presente", "  ", "retangular", 5.0, 6.0));
		assertThrows(IllegalArgumentException.class, ()-> new CaixaCircular(null, "Pintura à mão", "circular", 5.0));
		assertThrows(IllegalArgumentException.class, ()-> new CaixaCircular("  ", "Pintura à mão", "circular", 5.0));
		assertThrows(IllegalArgumentException.class, ()-> new CaixaPentagonal("Caixa1", "Colagem", null, 5.0));
		assertThrows(IllegalArgumentException.class, ()-> new CaixaPentagonal("Caixa1", "Colagem", "  ", 5.0));
		assertThrows(IllegalArgumentException.class, ()-> new CaixaPentagonal("Caixa1", "Pintura", "pentagonal", 5.0));
		
		assertEquals("Caixa de presente", caixaR.getDescricao());
		assertEquals("Caixa2", caixaC.getDescricao());
		assertEquals("Caixa1", caixaP.getDescricao());
		
		assertEquals("retangular", caixaR.getFormato());
		assertEquals("circular", caixaC.getFormato());
		assertEquals("pentagonal", caixaP.getFormato());
		
		assertEquals("Arte em tecido", caixaR.getPersonalizacao());
		assertEquals("Pintura à mão", caixaC.getPersonalizacao());
		assertEquals("Colagem", caixaP.getPersonalizacao());
		
		assertEquals(3.0, caixaR.getPreco());
		assertEquals(7.8500000000000005, caixaC.getPreco());
		assertEquals(6.288941186718159, caixaP.getPreco());
		
		assertEquals(30.0, caixaR.areaDaTampa());
		assertEquals(78.5, caixaC.areaDaTampa());
		assertEquals(62.889411867181586, caixaP.areaDaTampa());
		
		assertEquals("Caixa com Arte em tecido custa R$ 3,00. Formato retangular", caixaR.toString());
		assertEquals("Caixa com Pintura à mão custa R$ 7,85. Formato circular", caixaC.toString());
		assertEquals("Caixa com Colagem custa R$ 6,29. Formato pentagonal", caixaP.toString());
	}
	
	@Test
	public void testSetPersonalizacao() {
		caixaC.setPersonalizacao("Arte em Tecido");
		assertEquals("Arte em Tecido", caixaC.getPersonalizacao());
		assertEquals("Caixa com Arte em Tecido custa R$ 7,85. Formato circular", caixaC.toString());
	}
	
	@Test
	public void testEquals() {
		assertTrue(caixaC.equals(caixaC));
		assertFalse(caixaP.equals(null));
		assertFalse(caixaR.equals("TEXTO"));
		assertFalse(caixaC.equals(new CaixaCircular("Descricao", "Pintura à mão", "circular", 5.0)));
		assertFalse(caixaC.equals(new CaixaCircular("Caixa2", "Pintura à mão", "pentagonal", 5.0)));
		assertFalse(caixaC.equals(new CaixaCircular("Caixa2", "Colagem", "circular", 5.0)));
		assertTrue(caixaC.equals(new CaixaCircular("Caixa2", "Pintura à mão", "circular", 5.0)));
	}

}
