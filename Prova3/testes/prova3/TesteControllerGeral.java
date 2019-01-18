package prova3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controllers.ControllerGeral;
import excecoes.CarrinhoNaoCadastradoException;
import excecoes.ProdutoNaoCadastradoException;

class TesteControllerGeral {
	
	private ControllerGeral c = new ControllerGeral();
	
	@BeforeEach
	public void cadastrandoItens() {
		c.adicionaOficina("Oficina", "Infantil", 10.0, 5);
		c.adicionaJogo("aei", "Juvenil", 10.0);
		c.adicionaJogo("aeiou", "Infantil", 10.0);
		c.adicionaLivro("livro1", "Infantil", 15.0, "USADO");
		c.adicionaLivro("livro2", "Infantil", 15.0, "Novo");
		c.criaCarrinho(1);
	}
	
	@Test
	public void testObterPreco() {
		assertEquals(50.0, c.obterPreco("Oficina"));
		assertEquals(10.0, c.obterPreco("aei"));
		assertEquals(9.50, c.obterPreco("aeiou"));
		assertEquals(7.50, c.obterPreco("livro1"));
		assertEquals(15.0, c.obterPreco("livro2"));
	}
	
	@Test
	public void testAdicionaOficina() {
		assertEquals("[Oficina, Infantil, 50,0]", c.exibirProduto("Oficina"));
	}
	
	@Test
	public void testAdicionaJogo() {
		assertEquals("[aei, Juvenil, 10,0]", c.exibirProduto("aei"));
		assertEquals("[aeiou, Infantil, 9,5]", c.exibirProduto("aeiou"));
	}
	
	@Test
	public void testAdicionaLivro() {
		assertEquals("[livro1, Infantil, 7,5]", c.exibirProduto("livro1"));
		assertEquals("[livro2, Infantil, 15,0]", c.exibirProduto("livro2"));
	}
	
	@BeforeEach
	public void adicionandoProdutoAoCarrinho() {
		this.c.adicionaProdutoAoCarrinho(1, "aeiou");
		this.c.adicionaProdutoAoCarrinho(1, "Oficina");
		this.c.adicionaProdutoAoCarrinho(1, "livro1");
		this.c.adicionaProdutoAoCarrinho(1, "aei");
		this.c.adicionaProdutoAoCarrinho(1, "livro2");
	}
	
	@Test
	public void testTotalizaCarrinho() {
		assertThrows(ProdutoNaoCadastradoException.class, ()-> c.adicionaProdutoAoCarrinho(1, "prod"));
		assertEquals(92.0, this.c.totalizaCarrinho(1));
		assertThrows(CarrinhoNaoCadastradoException.class, ()-> c.totalizaCarrinho(5));
	}
	
	@Test
	public void testListar() {
		assertEquals("[[aei, Juvenil, 10,0], [aeiou, Infantil, 9,5], "
				+ "[livro1, Infantil, 7,5], [livro2, Infantil, 15,0], "
				+ "[Oficina, Infantil, 50,0] ]", this.c.listar());
	}
	
	@Test
	public void testListarPorCategoria() {
		this.c.configuraOrdenacao("CATEGORIA");
		assertEquals("[[livro1, Infantil, 7,5], [livro2, Infantil, 15,0], "
				+ "[Oficina, Infantil, 50,0], "
				+ "[aeiou, Infantil, 9,5], "
				+ "[aei, Juvenil, 10,0] ]", c.listar());
	}
	
	@Test
	public void testListarPorPreco() {
		this.c.configuraOrdenacao("PRECO");
		assertEquals("[[livro1, Infantil, 7,5], "
				+ "[aeiou, Infantil, 9,5], [aei, Juvenil, 10,0], "
				+ "[livro2, Infantil, 15,0], [Oficina, Infantil, 50,0] ]", c.listar());
	}

}
