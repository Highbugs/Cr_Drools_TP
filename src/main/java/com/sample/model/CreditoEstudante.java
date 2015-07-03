package com.sample.model;

public class CreditoEstudante extends Credito {
	private boolean produtofinanceiro;

	public CreditoEstudante(Cliente cliente, float montanteEscolhido,
			int prazoAmortizacao, String tipoJuros, float mensalidade,
			float totalPagar, float spread, float euribor, float tAN,
			boolean produtofinanceiro) {
		super(cliente, montanteEscolhido, prazoAmortizacao, tipoJuros,
				mensalidade, totalPagar, spread, euribor, tAN);
		this.produtofinanceiro = produtofinanceiro;
	}

	public boolean isProdutofinanceiro() {
		return produtofinanceiro;
	}

	public void setProdutofinanceiro(boolean produtofinanceiro) {
		this.produtofinanceiro = produtofinanceiro;
	}
	
}
