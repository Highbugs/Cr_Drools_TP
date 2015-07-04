package com.sample.model;

public class Credito {
	private Cliente cliente;
	private Cliente fiador;
	private float montanteEscolhido;
	private int prazoAmortizacao;
	private String tipoJuros;//fixa, variável
	private float mensalidade;
	private float totalPagar;
	private float spread;
	private float euribor;
	private float TAN;
	public Credito(Cliente cliente, float montanteEscolhido,
			int prazoAmortizacao, String tipoJuros, float mensalidade,
			float totalPagar, float spread, float euribor, float tAN) {
		super();
		this.cliente = cliente;
		this.montanteEscolhido = montanteEscolhido;
		this.prazoAmortizacao = prazoAmortizacao;
		this.tipoJuros = tipoJuros;
		this.mensalidade = mensalidade;
		this.totalPagar = totalPagar;
		this.spread = spread;
		this.euribor = euribor;
		TAN = tAN;
		fiador = null;
	}
	
	public Cliente getFiador() {
		return fiador;
	}

	public void setFiador(Cliente fiador) {
		this.fiador = fiador;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public float getMontanteEscolhido() {
		return montanteEscolhido;
	}
	public void setMontanteEscolhido(float montanteEscolhido) {
		this.montanteEscolhido = montanteEscolhido;
	}
	public int getPrazoAmortizacao() {
		return prazoAmortizacao;
	}
	public void setPrazoAmortizacao(int prazoAmortizacao) {
		this.prazoAmortizacao = prazoAmortizacao;
	}
	public String getTipoJuros() {
		return tipoJuros;
	}
	public void setTipoJuros(String tipoJuros) {
		this.tipoJuros = tipoJuros;
	}
	public float getMensalidade() {
		return mensalidade;
	}
	public void setMensalidade(float mensalidade) {
		this.mensalidade = mensalidade;
	}
	public float getTotalPagar() {
		return totalPagar;
	}
	public void setTotalPagar(float totalPagar) {
		this.totalPagar = totalPagar;
	}
	public float getSpread() {
		return spread;
	}
	public void setSpread(float spread) {
		this.spread = spread;
	}
	public float getEuribor() {
		return euribor;
	}
	public void setEuribor(float euribor) {
		this.euribor = euribor;
	}
	public float getTAN() {
		return TAN;
	}
	public void setTAN(float tAN) {
		TAN = tAN;
	}
	public float getTaxaEsforcoCliente() {
		float mensalidade = (this.montanteEscolhido/this.prazoAmortizacao)+this.cliente.getTotalDespesasCreditos();
		System.out.println("mesalidade "+mensalidade);
		System.out.println("ordenado "+this.cliente.getOrdenado());
		System.out.println("taxa de esforco "+(mensalidade*100)/this.cliente.getOrdenado());
		return (this.cliente.getOrdenado()*100) / mensalidade;
	}
	public float getTaxaEsforcoFiadorCliente() {
		float mensalidade = (this.montanteEscolhido/this.prazoAmortizacao)+this.cliente.getTotalDespesasCreditos()+this.fiador.getTotalDespesasCreditos();
		System.out.println("mesalidade "+mensalidade);
		float ordenado = this.cliente.getOrdenado()+this.fiador.getOrdenado();
		System.out.println("ordenado "+ordenado);
		System.out.println("taxa de esforco "+(mensalidade*100)/ordenado);
		return (ordenado*100)/mensalidade;
	}
	
}
