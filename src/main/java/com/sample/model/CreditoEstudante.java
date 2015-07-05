package com.sample.model;

public class CreditoEstudante extends Credito {
	private boolean produtofinanceiro;
	private float produtofinanceiroValor;
	private Estudante estudante;
	public CreditoEstudante(Cliente cliente, float montanteEscolhido,
			int prazoAmortizacao, String tipoJuros, float mensalidade,
			float totalPagar, float spread, float euribor, float tAN,
			boolean produtofinanceiro) {
		super(cliente, montanteEscolhido, prazoAmortizacao, tipoJuros,
				mensalidade, totalPagar, spread, euribor, tAN);
		this.produtofinanceiro = produtofinanceiro;
	}
	
	public float getProdutofinanceiroValor() {
		return produtofinanceiroValor;
	}

	public void setProdutofinanceiroValor(float produtofinanceiroValor) {
		this.produtofinanceiroValor = produtofinanceiroValor;
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

	public boolean isProdutofinanceiro() {
		return produtofinanceiro;
	}

	public void setProdutofinanceiro(boolean produtofinanceiro) {
		this.produtofinanceiro = produtofinanceiro;
	}
	
}
