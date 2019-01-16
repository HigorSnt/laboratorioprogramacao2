package Prova1_HigorSantos;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Prova1.Vaga;

class VagaTest {
	
	private Vaga vaga1;
	private Vaga vaga2;
	
	@BeforeEach
	void registraVagas(){
		this.vaga1 = new Vaga("A", 1);
		this.vaga2 = new Vaga("A", 4);
		
		this.vaga1.ocupaVaga("SOS000", LocalTime.now());
	}
	
	@Test
	void testConstrutor() {
		assertEquals(LocalTime.now().getHour(), this.vaga1.getHoraChegada());
		
		assertEquals("A/1", this.vaga1.getLocalizacao());
		assertEquals("A/4", this.vaga2.getLocalizacao());
		
		assertEquals("Vaga [setor = A, posicao = 1, status = OCUPADO]", this.vaga1.toString());
		assertEquals("Vaga [setor = A, posicao = 4, status = DESOCUPADO]", this.vaga2.toString());
	}
	
	@Test
	void testOcupaVaga() {
		this.vaga2.ocupaVaga("SOS454", LocalTime.of(LocalTime.now().getHour() + 2, LocalTime.now().getMinute()));
		
		assertEquals(LocalTime.now().getHour(), this.vaga1.getHoraChegada());
		assertEquals("SOS000", this.vaga1.getPlaca());
		assertEquals("A/1", this.vaga1.getLocalizacao());
		assertFalse(this.vaga1.isVagaLivre());
		
		assertEquals(LocalTime.now().getHour() + 2, this.vaga2.getHoraChegada());
		assertEquals("SOS454", this.vaga2.getPlaca());
		assertEquals("A/4", this.vaga2.getLocalizacao());
		assertFalse(this.vaga2.isVagaLivre());
		
	}

	@Test
	void testDesocupaVaga() {
		this.vaga2.ocupaVaga("SOS454", LocalTime.of(LocalTime.now().getHour() + 2, LocalTime.now().getMinute()));
		
		assertEquals(5.0, this.vaga1.desocupaVaga(LocalTime.of(LocalTime.now().getHour() + 2, LocalTime.now().getMinute() + 2)));
		assertEquals(6.0, this.vaga2.desocupaVaga(LocalTime.of(LocalTime.now().getHour() + 3, LocalTime.now().getMinute() + 3)));
		
		assertTrue(this.vaga1.isVagaLivre());
		assertNull(this.vaga1.getPlaca());
		
		assertTrue(this.vaga2.isVagaLivre());
		assertNull(this.vaga2.getPlaca());
	}
	
	@Test
	void testHashCode() {
		assertEquals(33998, this.vaga1.hashCode());
	}
	
	@Test
	void testEqualsObject() {
		Vaga vaga = new Vaga("A", 1);
		Vaga outraVaga = new Vaga("B", 1);
		//vaga.ocupaVaga("AAA111");
		
		Vaga vagaNula = null;
		Vaga vagaSetorNulo1 = new Vaga (null, 1);
		Vaga vagaSetorNulo2 = new Vaga (null, 1);
		
		assertTrue(this.vaga1.equals(this.vaga1));
		assertFalse(this.vaga1.equals("SSSSS"));
		assertTrue(vagaSetorNulo1.equals(vagaSetorNulo2));
		assertFalse(vagaSetorNulo1.equals(this.vaga1));
		assertTrue(vaga.equals(this.vaga1));
		assertFalse(outraVaga.equals(this.vaga1));
		assertFalse(this.vaga1.equals(vagaNula));
		assertFalse(this.vaga1.equals(new Vaga("A", 1)));
		assertFalse(this.vaga1.equals(this.vaga2));
	}

}
