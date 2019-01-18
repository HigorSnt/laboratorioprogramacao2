package comparators;

import java.util.Comparator;

import prova3.Produto;

public class ComparaPorCategoria implements Comparator<Produto>{
	
	@Override
	public int compare(Produto o1, Produto o2) {
		return o1.getCategoria().compareTo(o2.getCategoria());
	}
}
