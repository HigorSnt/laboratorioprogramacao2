package comparators;

import java.util.Comparator;

import prova3.Produto;

public class ComparaPorNome implements Comparator<Produto> {
	
	@Override
	public int compare(Produto o1, Produto o2) {
		return o1.getNome().toLowerCase().compareTo(o2.getNome().toLowerCase());
	}

}
