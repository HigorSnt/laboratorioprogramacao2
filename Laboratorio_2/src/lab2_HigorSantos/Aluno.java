package lab2_HigorSantos;

import java.util.HashMap;
import java.util.Map;

public class Aluno {
	
	private Saude saude;
	private Map<String, ContaLaboratorio> conta;
	private Map <String, Disciplina> disciplina;
	private Map <String, ContaCantina> cantina;
	
	public Aluno() {
		this.saude = new Saude();
		this.conta = new HashMap<>();
		this.disciplina = new HashMap<>();
		this.cantina = new HashMap<>();
	}

	public void cadastraLaboratorio(String nomeLaboratorio) {
		this.conta.put(nomeLaboratorio, new ContaLaboratorio(nomeLaboratorio));
	}
	
	public void cadastraLaboratorio(String nomeLaboratorio, int cota) {
		this.conta.put(nomeLaboratorio, new ContaLaboratorio(nomeLaboratorio, cota));
	}
	
	public void consomeEspaco(String nomeLaboratorio, int mbytes) {
		this.conta.get(nomeLaboratorio).consomeEspaco(mbytes);
	}
	
	public void liberaEspaco(String nomeLaboratorio, int mbytes) {
		this.conta.get(nomeLaboratorio).liberaEspaco(mbytes);
	}
	
	public boolean atingiuCota(String nomeLaboratorio) {
		return this.conta.get(nomeLaboratorio).atingiuCota();
	}
	
	public String laboratorioToString(String nomeLaboratorio) {
		return this.conta.get(nomeLaboratorio).toString();
	}
	
	public void cadastraDisciplina(String nomeDisciplina) {
		this.disciplina.put(nomeDisciplina, new Disciplina(nomeDisciplina));
	}
	
	public void cadastraHoras(String nomeDisciplina, int horas) {
		this.disciplina.get(nomeDisciplina).cadastraHoras(horas);
	}
	
	public void cadastraNota(String nomeDisciplina, int nota, double valorNota) {
		this.disciplina.get(nomeDisciplina).cadastraNota(nota, valorNota);
	}
	
	public boolean aprovado(String nomeDisciplina) {
		return this.disciplina.get(nomeDisciplina).aprovado();
	}
	
	public String disciplinaToString(String nomeDisciplina) {
		return this.disciplina.get(nomeDisciplina).toString();
	}
	
	public void cadastraCantina(String nomeCantina) {
		this.cantina.put(nomeCantina, new ContaCantina(nomeCantina));
	}
	
	public void cadastraLanche(String nomeCantina, int qtdItens, int valorCentavos) {
		this.cantina.get(nomeCantina).cadastraLanche(qtdItens, valorCentavos);
	}
	
	public void pagarConta(String nomeCantina, int valorCentavos) {
		this.cantina.get(nomeCantina).pagaConta(valorCentavos);
	}
	
	public int getFaltaPagar(String nomeCantina) {
		return this.cantina.get(nomeCantina).getFaltaPagar();
	}
	
	public String listarDetalhes(String nomeCantina) {
		return this.cantina.get(nomeCantina).listarDetalhes();
	}
	
	public String cantinaToString(String nomeCantina) {
		return this.cantina.get(nomeCantina).toString();
	}
	
	public void defineSaudeMental(String valor) {
		this.saude.defineSaudeMental(valor);
	}
	
	public void defineSaudeFisica(String valor) {
		this.saude.defineSaudeFisica(valor);
	}
	
	public void defineEmoji(String valor) {
		this.saude.definirEmoji(valor);
	}
	
	public String getStatusGeral() {
		return this.saude.getStatusGeral();
	}
}
