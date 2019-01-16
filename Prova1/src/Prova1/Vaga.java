package Prova1;

import java.time.LocalTime;

public class Vaga {

	private String placa;
	private LocalTime horaChegada;
	private String setor;
	private int posicao;
	private boolean vagaLivre;
	
	public Vaga(String setor, int posicao) {
		this.setor = setor;
		this.posicao = posicao;
		this.vagaLivre = true;
	}
	
	public void ocupaVaga(String placa, LocalTime hora) {
		this.placa = placa;
		this.horaChegada = hora;
		this.vagaLivre = false;
	}
	
	public double desocupaVaga(LocalTime horaSaida) {
		this.vagaLivre = true;
		this.placa = null;
		if ((horaSaida.getHour() - this.horaChegada.getHour()) <= 2) {
			return (5.0);
		} else {
			return (5.0 + (horaSaida.getHour() - horaChegada.getHour()));
		}
	}

	public boolean isVagaLivre() {
		return this.vagaLivre;
	}

	public String getPlaca() {
		return this.placa;
	}

	public int getHoraChegada() {
		return this.horaChegada.getHour();
	}

	public String getLocalizacao() {
		return this.setor + "/" + this.posicao;
	}

	@Override
	public String toString() {
		return "Vaga [setor = " + setor + ", posicao = " + posicao + ", status = " + (vagaLivre ? "DESOCUPADO" : "OCUPADO")
	+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + posicao;
		result = prime * result + ((setor == null) ? 0 : setor.hashCode());
		result = prime * result + (vagaLivre ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vaga other = (Vaga) obj;
		if (posicao != other.posicao)
			return false;
		if (setor == null) {
			if (other.setor != null)
				return false;
		} else if (!setor.equals(other.setor))
			return false;
		if (vagaLivre != other.vagaLivre)
			return false;
		return true;
	}
	
	
}
