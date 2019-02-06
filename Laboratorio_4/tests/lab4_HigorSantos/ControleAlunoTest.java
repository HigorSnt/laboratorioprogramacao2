package lab4_HigorSantos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ControleAlunoTest {

	public ControleAlunos controle = new ControleAlunos();	
	
	@Test
	public void testAddAluno() {
		assertEquals("CADASTRO REALIZADO!\n", this.controle.addAluno("123", "João", "Elétrica"));
		assertEquals("MATRÍCULA JÁ CADASTRADA!\n", this.controle.addAluno("123", "Pedro", "Administração"));
		
		assertThrows(IllegalArgumentException.class, ()-> this.controle.addAluno("", "", ""));
		assertThrows(IllegalArgumentException.class, ()-> this.controle.addAluno("", "João", ""));
		assertThrows(IllegalArgumentException.class, ()-> this.controle.addAluno("123", "", "Computação"));
		
		assertThrows(NullPointerException.class, ()-> this.controle.addAluno(null, null, null));
		assertThrows(NullPointerException.class, ()-> this.controle.addAluno(null, null, "Elétrica"));
		assertThrows(NullPointerException.class, ()-> this.controle.addAluno("149", "Pedro", null));
	}

	@Test
	public void testConsultaAluno() {
		this.controle.addAluno("123", "João", "Elétrica");
		
		assertEquals("Aluno: 123 - João - Elétrica", this.controle.consultaAluno("123"));
		assertEquals("ALUNO NÃO CADASTRADO!", this.controle.consultaAluno("2000"));
		
		assertThrows(NullPointerException.class, ()-> this.controle.consultaAluno(null));
		assertThrows(IllegalArgumentException.class, ()-> this.controle.consultaAluno(""));
	}

	@Test
	public void testCadastraGrupo() {
		assertEquals("CADASTRO REALIZADO!\n", this.controle.cadastraGrupo("Coleções"));
		assertEquals("GRUPO JÁ CADASTRADO!\n", this.controle.cadastraGrupo("COLEÇÕES"));
		assertEquals("GRUPO JÁ CADASTRADO!\n", this.controle.cadastraGrupo("CoLeÇõEs"));
		
		assertThrows(IllegalArgumentException.class, ()-> this.controle.cadastraGrupo(""));
		assertThrows(NullPointerException.class, ()-> this.controle.cadastraGrupo(null));
	}

	@Test
	public void testAlocaAluno() {
		this.controle.cadastraGrupo("Coleções");
		this.controle.addAluno("123", "João", "Elétrica");
		this.controle.addAluno("874", "Gabi", "Engenharia Química");
		
		assertEquals("ALUNO NÃO CADASTRADO!\n", this.controle.alocaAluno("2000", "Coleções"));
		assertEquals("GRUPO NÃO CADASTRADO!\n", this.controle.alocaAluno("123", "Listas"));
		assertEquals("ALUNO ALOCADO!\n", this.controle.alocaAluno("123", "Coleções"));
		
		assertThrows(IllegalArgumentException.class, ()-> this.controle.alocaAluno("", ""));
		assertThrows(NullPointerException.class, ()-> this.controle.alocaAluno(null, null));
		
	}

	@Test
	public void testImprimeGrupo() {
		this.controle.cadastraGrupo("Coleções");
		
		assertEquals("\nAlunos do grupo Coleções:\nNENHUM ALUNO CADASTRADO AINDA!\n", 
				this.controle.imprimeGrupo("Coleções"));
		
		this.controle.addAluno("123", "João", "Elétrica");
		this.controle.addAluno("874", "Gabi", "Engenharia Química");
		this.controle.alocaAluno("123", "Coleções");
		this.controle.alocaAluno("874", "Coleções");
		
		String saida1 = "\nAlunos do grupo Coleções:\n"
				+ "* 123 - João - Elétrica\n"
				+ "* 874 - Gabi - Engenharia Química";
		
		String saida2 = "\nAlunos do grupo Coleções:\n"
				+ "* 874 - Gabi - Engenharia Química\n"
				+ "* 123 - João - Elétrica\n";
		
		assertEquals("GRUPO NÃO CADASTRADO.\n", this.controle.imprimeGrupo("Listas"));
		assertTrue(this.controle.imprimeGrupo("Coleções").equals(saida1) ||
				this.controle.imprimeGrupo("Coleções").equals(saida2));
		
		assertThrows(IllegalArgumentException.class, ()-> this.controle.imprimeGrupo(""));
		assertThrows(NullPointerException.class, ()-> this.controle.imprimeGrupo(null));
		
	}

	@Test
	public void testRespondeuQuestao() {
		this.controle.addAluno("147", "Maria", "Computação");
		
		assertEquals("ALUNO NÃO CADASTRADO!\n", this.controle.respondeuQuestao("200"));
		assertEquals("ALUNO REGISTRADO!\n", this.controle.respondeuQuestao("147"));
		
		assertThrows(IllegalArgumentException.class, ()-> this.controle.respondeuQuestao(""));
		assertThrows(NullPointerException.class, ()-> this.controle.respondeuQuestao(null));
	}

	@Test
	public void testListarRespondeuQuestao() {
		assertEquals("Alunos:\nNENHUM ALUNO CADASTRADO AINDA!\n", this.controle.listarRespondeuQuestao());
		this.controle.addAluno("147", "Maria", "Computação");
		this.controle.addAluno("874", "Gabi", "Engenharia Química");
		this.controle.addAluno("123", "João", "Elétrica");
		this.controle.respondeuQuestao("147");
		this.controle.respondeuQuestao("874");
		this.controle.respondeuQuestao("123");
		this.controle.respondeuQuestao("147");
		
		String saida = "Alunos:\n1. 147 - Maria - Computação\n"
				+ "2. 874 - Gabi - Engenharia Química\n"
				+ "3. 123 - João - Elétrica\n"
				+ "4. 147 - Maria - Computação\n";
		
		assertEquals(saida, this.controle.listarRespondeuQuestao());
	}

}
