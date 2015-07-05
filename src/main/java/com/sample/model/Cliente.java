package com.sample.model;

public class Cliente extends Pessoa{
	private float ordenado;
	private float totalDespesasCreditos;
	private float taxaEsforco;
	private Fiador fiador;
	private boolean seguroVida;
	private boolean emprego;
	
	public Cliente(String nome, int idade, boolean historicoIncumprimento,
			float ordenado, float totalDespesasCreditos, float taxaEsforco,
			Fiador fiador) {
		super(nome, idade, historicoIncumprimento);
		this.ordenado = ordenado;
		this.totalDespesasCreditos = totalDespesasCreditos;
		this.taxaEsforco = taxaEsforco;
		this.fiador = fiador;
		this.seguroVida = false;
	}
	public boolean isEmprego() {
		return emprego;
	}
	public void setEmprego(boolean emprego) {
		this.emprego = emprego;
	}
	public boolean isSeguroVida() {
		return seguroVida;
	}
	public void setSeguroVida(boolean seguroVida) {
		this.seguroVida = seguroVida;
	}
	public float getTaxaEsforco() {
		return taxaEsforco;
	}
	public void setTaxaEsforco(float taxaEsforco) {
		this.taxaEsforco = taxaEsforco;
	}
	public float getOrdenado() {
		return ordenado;
	}
	public void setOrdenado(float ordenado) {
		this.ordenado = ordenado;
	}

	public Fiador getFiador() {
		return fiador;
	}
	public void setFiador(Fiador fiador) {
		this.fiador = fiador;
	}
	public float getTotalDespesasCreditos() {
		return totalDespesasCreditos;
	}
	public void setTotalDespesasCreditos(float totalDespesasCreditos) {
		this.totalDespesasCreditos = totalDespesasCreditos;
	}
	public String toString (){
		String returnString = "";
		returnString+="A pessoa "+this.getNome();
		returnString+=" tem "+this.getIdade()+" anos";
		returnString+=" ordenado "+this.getOrdenado()+"€";
		returnString+=" despesas em crédito de  "+this.getTotalDespesasCreditos()+"€";
		if(this.isHistoricoIncumprimento()) {
			returnString+=" e histórico de incumprimento";
		} else {
			returnString+=" e não tem histórico de incumprimento";
		}
		return returnString;
	}
}
