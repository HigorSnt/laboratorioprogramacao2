package Prova1;

import java.time.LocalTime;

public class Estacionamento {
	
	private Vaga[] vagas;
	private double caixa;
	
	public Estacionamento() {
		this.vagas = new Vaga[50];
		this.caixa = 0;
		inicializaVagas();
	}
	
	public Estacionamento(int posicoes) {
		this.vagas = new Vaga[posicoes];
		this.caixa = 0;
		inicializaVagas();
	}
	
	private void inicializaVagas() {
		for (int i = 0; i < vagas.length; i++) {
			vagas[i] = new Vaga("A", i+1);
		}
	}
	
	public void estacionarCarro(String placa) {
		for (int i = 0; i < vagas.length; i++) {
			if (!vagas[i].isVagaLivre()) {
				vagas[i].ocupaVaga(placa, LocalTime.now());
				break;
			}
		}
	}
	
	public String liberarVaga(String placa) {
		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i].getPlaca().equals(placa)) {
				this.caixa = vagas[i].desocupaVaga(LocalTime.now());
				return "Valor a ser pago: R$ " + this.caixa;
			}
		}
		return "Vaga não encontrada";
	}
	
	public String exibirVagasLivres() {
		String vagasLivre = "";
		for (int i = 0; i < vagas.length; i++) {
			if (!vagas[i].isVagaLivre()) {
				vagasLivre += vagas[i].toString() + "\n";
			}
		}
		return vagasLivre;
	}
	
	public String localizaCarro(String placa) {
		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i].getPlaca().equals(placa)) {
				return vagas[i].toString();
			}
		}
		return "Carro não encntrado";
	}
	
	public String imprimeLucro() {
		return "O lucro até o momento é de R$ " + this.caixa;
	}

}
