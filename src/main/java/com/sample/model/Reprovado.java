package com.sample.model;

import java.util.ArrayList;

public class Reprovado {
	ArrayList <String> motivos;
	private boolean checkDivida;
	private boolean checkIdade;
	private boolean checkContaBancaria;
	private boolean checkEmprego;
	private boolean checkTaxaEsforco;
	private boolean checkDividaFiador;
	private boolean checkIdadeFiador;
	private boolean checkContaBancariaFiador;
	private boolean checkEmpregoFiador;
	private boolean checkTaxaEsforcoFiador;
	public boolean isCheckDivida() {
		return checkDivida;
	}

	public boolean isCheckDividaFiador() {
		return checkDividaFiador;
	}

	public void setCheckDividaFiador(boolean checkDividaFiador) {
		this.checkDividaFiador = checkDividaFiador;
	}

	public boolean isCheckIdadeFiador() {
		return checkIdadeFiador;
	}

	public void setCheckIdadeFiador(boolean checkIdadeFiador) {
		this.checkIdadeFiador = checkIdadeFiador;
	}

	public boolean isCheckContaBancariaFiador() {
		return checkContaBancariaFiador;
	}

	public void setCheckContaBancariaFiador(boolean checkContaBancariaFiador) {
		this.checkContaBancariaFiador = checkContaBancariaFiador;
	}

	public boolean isCheckEmpregoFiador() {
		return checkEmpregoFiador;
	}

	public void setCheckEmpregoFiador(boolean checkEmpregoFiador) {
		this.checkEmpregoFiador = checkEmpregoFiador;
	}

	public boolean isCheckTaxaEsforcoFiador() {
		return checkTaxaEsforcoFiador;
	}

	public void setCheckTaxaEsforcoFiador(boolean checkTaxaEsforcoFiador) {
		this.checkTaxaEsforcoFiador = checkTaxaEsforcoFiador;
	}

	public void setCheckDivida(boolean checkDivida) {
		this.checkDivida = checkDivida;
	}

	public boolean isCheckIdade() {
		return checkIdade;
	}

	public void setCheckIdade(boolean checkIdade) {
		this.checkIdade = checkIdade;
	}

	public boolean isCheckContaBancaria() {
		return checkContaBancaria;
	}

	public void setCheckContaBancaria(boolean checkContaBancaria) {
		this.checkContaBancaria = checkContaBancaria;
	}

	public boolean isCheckEmprego() {
		return checkEmprego;
	}

	public void setCheckEmprego(boolean checkEmprego) {
		this.checkEmprego = checkEmprego;
	}

	public boolean isCheckTaxaEsforco() {
		return checkTaxaEsforco;
	}

	public void setCheckTaxaEsforco(boolean checkTaxaEsforco) {
		this.checkTaxaEsforco = checkTaxaEsforco;
	}

	public Reprovado() {
		super();
		this.motivos = new ArrayList<>();
	}

	public ArrayList<String> getMotivos() {
		return motivos;
	}

	public void setMotivos(ArrayList<String> motivos) {
		this.motivos = motivos;
	}
	public void addMotivo(String motivo) {
		motivos.add(motivo);
	}
	public int getNumberMotivos (){
		return motivos.size();
	}
	public String toString() {
		String returnString = "### Crédito reprovado ####";
		for(int i = 0; i< this.motivos.size(); i++) {
			returnString+= motivos.get(i);
		}
		return returnString;
	}
}
