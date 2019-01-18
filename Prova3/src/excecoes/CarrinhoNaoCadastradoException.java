package excecoes;

public class CarrinhoNaoCadastradoException extends RuntimeException {
	
	public CarrinhoNaoCadastradoException() {
		super("CARRINHO NAO CADASTRADO");
	}
}
