package com.sample.model;

public class CreditoHabitacao extends Credito{
	private boolean seguroVida;
	private boolean seguroCredito;
	private boolean produtofinanceiro;
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
	
}
