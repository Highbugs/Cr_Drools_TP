package com.sample.model;

public class CreditoAutomovel extends Credito {
	private boolean seguroVida;
	private boolean seguroCredito;
	private boolean produtofinanceiro;
	private boolean seguroCarro;
	private float seguroVidaValor;
	private float seguroCreditoValor;
	private float produtofinanceiroValor;
	private float seguroCarroValor;
	public CreditoAutomovel(Cliente cliente, float montanteEscolhido,
			int prazoAmortizacao, String tipoJuros, float mensalidade,
			float totalPagar, float spread, float euribor, float tAN,
			boolean seguroVida, boolean seguroCredito,
			boolean produtofinanceiro, boolean seguroCarro) {
		super(cliente, montanteEscolhido, prazoAmortizacao, tipoJuros,
				mensalidade, totalPagar, spread, euribor, tAN);
		this.seguroVida = seguroVida;
		this.seguroCredito = seguroCredito;
		this.produtofinanceiro = produtofinanceiro;
		this.seguroCarro = seguroCarro;
		this.produtofinanceiroValor = 0;
		this.seguroVidaValor = 0;
		this.seguroCarroValor = 0;
		this.seguroCreditoValor = 0;
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

	public float getSeguroCarroValor() {
		return seguroCarroValor;
	}

	public void setSeguroCarroValor(float seguroCarroValor) {
		this.seguroCarroValor = seguroCarroValor;
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
	public boolean isSeguroCarro() {
		return seguroCarro;
	}
	public void setSeguroCarro(boolean seguroCarro) {
		this.seguroCarro = seguroCarro;
	}
	
	
}
