package comparators;

import java.util.Comparator;

import prova3.Produto;

public class ComparaPorPreco implements Comparator<Produto> {
	
	@Override
	public int compare(Produto o1, Produto o2) {
		return Double.compare(o1.obterPreco(), o2.obterPreco());
	}
}
