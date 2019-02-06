package lab3_HigorSantos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContatoTest {

	private Contato contato1;
	private Contato contato2;
	private Contato contato3;
	private Contato contato4;
	private Contato contato5;
	private Contato contato6;

    @BeforeEach
    public void criaContato() {
    	contato1 = new Contato("Higor", "Santos", "(83) 0552000000");
    	contato2 = new Contato("Outra", "Pessoa", "000000000");
    	contato3 = new Contato("Fulano", "de Tal", "9999-9999");
    	contato4 = new Contato("Fulano", "de Tal", "55885-554899");
    	contato5 = new Contato("Outra", "Pessoa", "000000000");
    	contato6 = new Contato("Higor", "Santos", "(83) 000001000");
    }
	
	@Test
	public void testContato() {
		assertThrows(NullPointerException.class, () -> {new Contato(null, "Exemplo", "000000");	});
		assertThrows(NullPointerException.class, () -> new Contato("Higor", "Santos", null));
		assertThrows(NullPointerException.class, () -> new Contato("Higor", null, "14516884646"));
		assertThrows(NullPointerException.class, () -> new Contato(null, "Santos", null));
		assertThrows(NullPointerException.class, () -> new Contato(null, null, null));
		assertThrows(IllegalArgumentException.class, () -> new Contato("", "", ""));
		assertThrows(IllegalArgumentException.class, () -> new Contato("Oi", "", "111"));
		assertThrows(IllegalArgumentException.class, () -> new Contato("", "Oi", "111"));
		assertThrows(IllegalArgumentException.class, () -> new Contato("", "", "111"));
		assertThrows(IllegalArgumentException.class, () -> new Contato("Oi", "teste", ""));
		assertThrows(IllegalArgumentException.class, () -> new Contato("Oi", "", ""));
		assertThrows(IllegalArgumentException.class, () -> new Contato("", "teste", ""));
	}

	@Test
	public void testToString() {
		assertEquals("Higor Santos - (83) 0552000000", contato1.toString());
		assertEquals("Outra Pessoa - 000000000", contato2.toString());
		assertEquals("Fulano de Tal - 9999-9999", contato3.toString());
	}

	@Test
	public void testEqualsObject() {
		assertTrue(contato1.equals(contato6));
		assertTrue(contato2.equals(contato5));
		assertTrue(contato3.equals(contato4));
		assertTrue(contato6.equals(contato1));
		assertTrue(contato5.equals(contato2));
		assertTrue(contato4.equals(contato3));
		
		assertFalse(contato1.equals(contato2));
		assertFalse(contato1.equals(contato3));
		assertFalse(contato1.equals(contato4));
		assertFalse(contato1.equals(contato5));
		
		assertFalse(contato2.equals(contato1));
		assertFalse(contato2.equals(contato3));
		assertFalse(contato2.equals(contato4));
		assertFalse(contato2.equals(contato6));
		
		assertFalse(contato3.equals(contato1));
		assertFalse(contato3.equals(contato2));
		assertFalse(contato3.equals(contato5));
		assertFalse(contato3.equals(contato6));
		
		assertFalse(contato4.equals(contato1));
		assertFalse(contato4.equals(contato2));
		assertFalse(contato4.equals(contato5));
		assertFalse(contato4.equals(contato6));
		
		assertFalse(contato5.equals(contato1));
		assertFalse(contato5.equals(contato3));
		assertFalse(contato5.equals(contato4));
		assertFalse(contato5.equals(contato6));
		
		assertFalse(contato6.equals(contato2));
		assertFalse(contato6.equals(contato3));
		assertFalse(contato6.equals(contato4));
		assertFalse(contato6.equals(contato5));
	}

}
