package lab4_HigorSantos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlunoTest {

	public Aluno a1;
	public Aluno a2;
	public Aluno a3;
	
	@BeforeEach
	public void criaAlunos() {
		this.a1 = new Aluno("123", "João", "Elétrica");
		this.a2 = new Aluno("147", "Maria", "Computação");
		this.a3 = new Aluno("874", "Gabi", "Engenharia Química");
	}
	
	@Test
	void testAluno() {
		assertThrows(NullPointerException.class, ()-> new Aluno(null, "João", "Elétrica"));
		assertThrows(NullPointerException.class, ()-> new Aluno("111", null, "Elétrica"));
		assertThrows(NullPointerException.class, ()-> new Aluno("111", "João", null));
		assertThrows(IllegalArgumentException.class,()-> new Aluno("", "João", "Elétrica"));
		assertThrows(IllegalArgumentException.class,()-> new Aluno("111", "    ", "Elétrica"));
		assertThrows(IllegalArgumentException.class,()-> new Aluno("111", "João", "        "));
		
		assertEquals("123", this.a1.getMatricula());
		assertEquals("João", this.a1.getNome());
		assertEquals("Elétrica", this.a1.getCurso());
		assertEquals("123 - João - Elétrica", this.a1.toString());
	}

	@Test
	void testEqualsObject() {
		Object a = "teste";
		Aluno b = this.a1;
		assertFalse(this.a1.equals(a3));
		assertFalse(this.a1.equals(null));
		assertFalse(this.a1.equals(a));
		assertTrue(this.a1.equals(a1));
		assertTrue(this.a1.hashCode() == b.hashCode());
		
		assertFalse(new Aluno("123", "Maria", "Administração").equals(this.a1));
		assertFalse(new Aluno("123", "Pedro", "Elétrica").equals(this.a1));
		assertFalse(new Aluno("321", "Pedro", "Elétrica").equals(this.a1));
		assertTrue(new Aluno("123", "João", "Elétrica").equals(this.a1));
	}

}
