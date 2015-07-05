package com.sample.model;

public class CreditoHabitacao extends Credito{
	private float valorImovel;
	private boolean seguroVida;
	private boolean seguroCredito;
	private boolean produtofinanceiro;
	private float seguroVidaValor;
	private float seguroCreditoValor;
	private float produtofinanceiroValor;
	public CreditoHabitacao(Cliente cliente, float montanteEscolhido,
			int prazoAmortizacao, String tipoJuros, float mensalidade,
			float totalPagar, float spread, float euribor, float tAN,
			boolean seguroVida, boolean seguroCredito, boolean produtofinanceiro) {
		super(cliente, montanteEscolhido, prazoAmortizacao, tipoJuros,
				mensalidade, totalPagar, spread, euribor, tAN);
		this.seguroVida = seguroVida;
		this.seguroCredito = seguroCredito;
		this.produtofinanceiro = produtofinanceiro;
	}
	
	public float getSeguroVidaValor() {
		return seguroVidaValor;
	}

	public void setSeguroVidaValor(float seguroVidaValor) {
		this.seguroVidaValor = seguroVidaValor;
	}

	public float getSeguroCreditoValor() {
		return seguroCreditoValor;
	}

	public void setSeguroCreditoValor(float seguroCreditoValor) {
		this.seguroCreditoValor = seguroCreditoValor;
	}

	public float getProdutofinanceiroValor() {
		return produtofinanceiroValor;
	}

	public void setProdutofinanceiroValor(float produtofinanceiroValor) {
		this.produtofinanceiroValor = produtofinanceiroValor;
	}

	public float getValorImovel() {
		return valorImovel;
	}
	public void setValorImovel(float valorImovel) {
		this.valorImovel = valorImovel;
	}
	public boolean isSeguroVida() {
		return seguroVida;
	}
	public void setSeguroVida(boolean seguroVida) {
		this.seguroVida = seguroVida;
	}
	public boolean isSeguroCredito() {
		return seguroCredito;
	}
	public void setSeguroCredito(boolean seguroCredito) {
		this.seguroCredito = seguroCredito;
	}
	public boolean isProdutofinanceiro() {
		return produtofinanceiro;
	}
	public void setProdutofinanceiro(boolean produtofinanceiro) {
		this.produtofinanceiro = produtofinanceiro;
	}
	public float getPercentagemValorCredito(){
		return (this.getMontanteEscolhido()*100)/this.valorImovel;
	}
	public int getTempoAmortizacaoComIdade(){
		int idadeCliente = this.getCliente().getIdade();
		return idadeCliente+(this.getPrazoAmortizacao()/12);
	}
}
