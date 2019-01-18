package HigorSantos_prova2;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Controller {
	
	private Map <String, Caixa> caixas;
	
	public Controller() {
		this.caixas = new HashMap<>();
	}
	
	public void cadastraCaixaRetangular(String descricao, String personalizacao, String formato,
			double lado1, double lado2) {
		
		validacao(personalizacao, descricao, formato);
		
		if(lado1 <= 0 || lado2 <= 0) {
			throw new IllegalArgumentException();
		}
		
		this.caixas.put(descricao, new CaixaRetangular(descricao, personalizacao, formato, lado1, lado2));
	}
	
	public void cadastraCaixaPentagonal(String descricao, String personalizacao, String formato,
			double lado) {
		validacao(personalizacao, descricao, formato);
		
		if(lado <= 0) {
			throw new IllegalArgumentException();
		}
		
		this.caixas.put(descricao, new CaixaPentagonal(descricao, personalizacao, formato, lado));
	}
	
	public void cadastraCaixaCircular(String descricao, String personalizacao, String formato,
			double raio) {
		validacao(personalizacao, descricao, formato);
		
		if(raio <= 0) {
			throw new IllegalArgumentException();
		}
		
		this.caixas.put(descricao, new CaixaCircular(descricao, personalizacao, formato, raio));
	}
	
	private void validacao(String personalizacao, String descricao, String formato) {
		if (personalizacao == null || personalizacao.trim().equals("")){
			throw new IllegalArgumentException();
		}
		if (descricao == null || descricao.trim().equals("")){
			throw new IllegalArgumentException();
		}
		if (formato == null || formato.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		if (!personalizacao.equalsIgnoreCase("ARTE EM TECIDO") && !personalizacao.equalsIgnoreCase("COLAGEM")
				&& !personalizacao.equalsIgnoreCase("PINTURA À MÃO")) {
			throw new IllegalArgumentException();
		}
		if (this.caixas.containsKey(descricao)) {
			throw new IllegalArgumentException();
		}
	}
	
	public void setPersonalizacao(String descricao, String personalizacao){
		this.caixas.get(descricao).setPersonalizacao(personalizacao);
	}
	
	public boolean removeCaixa(String descricao) {
		if (!this.caixas.containsKey(descricao)) {
			return false;
		}
		
		this.caixas.remove(descricao);
		return true;
	}
	
	public int numCaixasNoEstoque() {
		return this.caixas.size();
	}
	
	public boolean consultaCaixa(String personalizacao, String formato) {
		for (Caixa c : this.caixas.values()) {
			if (c.getFormato().equals(formato) && c.getPersonalizacao().equals(personalizacao)) {
				return true;
			}
		}
		return false;
	}
	
	public String retornaCaixasPersonalizacao(String personalizacao) {
		List<Caixa> lista = new ArrayList<>();
		
		for (Caixa c : this.caixas.values()) {
			if (c.getPersonalizacao().equals(personalizacao.trim())){
				lista.add(c);
			}
		}
		
		if (lista.isEmpty()) {
			return "NENHUM CAIXA POSSUI ESSA PERSONALIZAÇÃO";
		}
		
		return lista.stream().map(c -> c.toString()).collect(Collectors.joining(System.lineSeparator()));
	}
	
	public String retornaCaixasFormato(String formato) {
		List<Caixa> lista = new ArrayList<>();
		for (Caixa c : this.caixas.values()) {
			if (c.getFormato().equals(formato.trim())){
				lista.add(c);
			}
		}
		if (lista.isEmpty()) {
			return "NENHUM CAIXA POSSUI ESSE FORMATO";
		}
		
		return lista.stream().map(c -> c.toString()).collect(Collectors.joining(System.lineSeparator()));
	}
	
	public String rendimento() {
		double preco = 0;
		for (Caixa c : this.caixas.values()) {
			preco += c.getPreco();
		}
		
		return String.format("%.2f", preco);
	}
	
	public String exibeCaixa(String descricao) {
		return this.caixas.get(descricao).toString();
	}
	
}
