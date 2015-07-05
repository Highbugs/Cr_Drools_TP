package com.sample.model;

public class Fiador extends Pessoa{
	private float ordenado;
	private float totalDespesasCreditos;
	private float taxaEsforco;
	private Cliente fiador;
	private boolean seguroVida;
	private boolean emprego;
	public Fiador() {
		super(null, 0,false);
	}
	public float getOrdenado() {
		return ordenado;
	}
	public void setOrdenado(float ordenado) {
		this.ordenado = ordenado;
	}
	public float getTotalDespesasCreditos() {
		return totalDespesasCreditos;
	}
	public void setTotalDespesasCreditos(float totalDespesasCreditos) {
		this.totalDespesasCreditos = totalDespesasCreditos;
	}
	public float getTaxaEsforco() {
		return taxaEsforco;
	}
	public void setTaxaEsforco(float taxaEsforco) {
		this.taxaEsforco = taxaEsforco;
	}
	public Cliente getFiador() {
		return fiador;
	}
	public void setFiador(Cliente fiador) {
		this.fiador = fiador;
	}
	public boolean isSeguroVida() {
		return seguroVida;
	}
	public void setSeguroVida(boolean seguroVida) {
		this.seguroVida = seguroVida;
	}
	public boolean isEmprego() {
		return emprego;
	}
	public void setEmprego(boolean emprego) {
		this.emprego = emprego;
	}
	
}
