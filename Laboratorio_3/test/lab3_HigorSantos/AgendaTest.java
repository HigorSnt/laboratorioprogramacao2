package lab3_HigorSantos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgendaTest {

	private Agenda agenda = new  Agenda();
	
	@BeforeEach
	public void cadastraContato() {
		agenda.cadastraContato(1, "teste1", "lab", "5587744654");
		agenda.cadastraContato(100, "teste2", "lab", "77787878");
		agenda.cadastraContato(61, "teste3", "lab", "5584564684");
	}
	
	@Test
	public void testCadastraContato() {
		Agenda agendatest = new  Agenda();
		assertEquals("POSIÇÃO INVÁLIDA!" + System.lineSeparator(), agendatest.cadastraContato(101, "ddsa", "dsfds", "aasd"));
		assertEquals("POSIÇÃO INVÁLIDA!" + System.lineSeparator(), agendatest.cadastraContato(101, "ddsa", "dsfds", "aasd"));
		assertEquals("CADASTRO REALIZADO!" + System.lineSeparator(), agendatest.cadastraContato(1, "teste", "lab", "4866888"));
	}
	
	@Test
	public void testExibeContato() {
		assertEquals("teste1 lab - 5587744654", agenda.exibeContato(1));
		assertEquals("teste2 lab - 77787878", agenda.exibeContato(100));
		assertEquals("teste3 lab - 5584564684",agenda.exibeContato(61));
	}
	
	@Test
	public void testListarContatos() {
		Agenda agendaVazia = new Agenda();
		assertEquals("1 - teste1" + System.lineSeparator() + "61 - teste3" + System.lineSeparator() + 
				"100 - teste2" + System.lineSeparator(), agenda.listarContatos());
		assertEquals("VOCÊ NÃO REGISTROU NENHUM CONTATO" + System.lineSeparator(), agendaVazia.listarContatos());
	}
	
	@Test
	public void testHashCode() {
		assertEquals(1206268237, agenda.hashCode());
	}
	
	@Test
	public void testEqualsObject() {
		Agenda agenda1 = new Agenda();
		Agenda agenda2 = new Agenda();
		agenda1.cadastraContato(1, "teste1", "lab", "1565615656");
		agenda1.cadastraContato(61, "teste3", "lab", "5654");
		agenda1.cadastraContato(100, "teste2", "lab", "hbfthrt");
		assertTrue(agenda.equals(agenda));
		assertFalse(agenda.equals(null));
		assertFalse(agenda.equals("TESTE"));
		assertTrue(agenda1.equals(agenda));
		assertFalse(agenda1.equals(agenda2));
	}

}
