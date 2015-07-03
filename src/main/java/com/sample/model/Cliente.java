package com.sample.model;

public class Cliente extends Pessoa{
	private float ordenado;
	private float totalDespesasCreditos;
	private float taxaEsforco;
	private Cliente fiador;
	
	
	public Cliente(String nome, int idade, boolean historicoIncumprimento,
			float ordenado, float totalDespesasCreditos, float taxaEsforco,
			Cliente fiador) {
		super(nome, idade, historicoIncumprimento);
		this.ordenado = ordenado;
		this.totalDespesasCreditos = totalDespesasCreditos;
		this.taxaEsforco = taxaEsforco;
		this.fiador = fiador;
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

	public Cliente getFiador() {
		return fiador;
	}
	public void setFiador(Cliente fiador) {
		this.fiador = fiador;
	}
	public float getTotalDespesasCreditos() {
		return totalDespesasCreditos;
	}
	public void setTotalDespesasCreditos(float totalDespesasCreditos) {
		this.totalDespesasCreditos = totalDespesasCreditos;
	}
	
}
