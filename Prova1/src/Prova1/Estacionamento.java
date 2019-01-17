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
		for (int i = 0; i < this.vagas.length; i++) {
			this.vagas[i] = new Vaga("A", i+1);
		}
	}
	
	public void estacionarCarro(String placa) {
		for (int i = 0; i < this.vagas.length; i++) {
			if (!this.vagas[i].isVagaLivre()) {
				this.vagas[i].ocupaVaga(placa, LocalTime.now());
				break;
			}
		}
	}
	
	public String liberarVaga(String placa) {
		for (int i = 0; i < this.vagas.length; i++) {
			if (this.vagas[i].getPlaca().equals(placa)) {
				double preco = this.vagas[i].desocupaVaga(LocalTime.now());
				this.caixa += preco;
				return "Valor a ser pago: R$ " + preco;
			}
		}
		return "Vaga não encontrada";
	}
	
	public String exibirVagasLivres() {
		String vagasLivre = "";
		for (int i = 0; i < this.vagas.length; i++) {
			if (!this.vagas[i].isVagaLivre()) {
				vagasLivre += this.vagas[i].toString() + System.lineSeparator();
			}
		}
		return vagasLivre;
	}
	
	public String localizaCarro(String placa) {
		for (int i = 0; i < this.vagas.length; i++) {
			if (this.vagas[i].getPlaca().equals(placa)) {
				return this.vagas[i].toString();
			}
		}
		return "Carro não encntrado";
	}
	
	public String imprimeLucro() {
		return "O lucro até o momento é de R$ " + this.caixa;
	}

}
