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
	private boolean checkSeguroVida;
	private boolean checkValorHabitacao;
	private boolean checkTempoAmortizacao;
	private boolean checkMatricula;
	private boolean checkFiador;
	private boolean checkCreditosIguais;
	private boolean checkNacionalidade;
	
	public boolean isCheckNacionalidade() {
		return checkNacionalidade;
	}

	public void setCheckNacionalidade(boolean checkNacionalidade) {
		this.checkNacionalidade = checkNacionalidade;
	}

	public boolean isCheckCreditosIguais() {
		return checkCreditosIguais;
	}

	public void setCheckCreditosIguais(boolean checkCreditosIguais) {
		this.checkCreditosIguais = checkCreditosIguais;
	}

	public boolean isCheckFiador() {
		return checkFiador;
	}

	public void setCheckFiador(boolean checkFiador) {
		this.checkFiador = checkFiador;
	}

	public boolean isCheckMatricula() {
		return checkMatricula;
	}

	public void setCheckMatricula(boolean checkMatricula) {
		this.checkMatricula = checkMatricula;
	}

	public boolean isCheckTempoAmortizacao() {
		return checkTempoAmortizacao;
	}

	public void setCheckTempoAmortizacao(boolean checkTempoAmortizacao) {
		this.checkTempoAmortizacao = checkTempoAmortizacao;
	}

	public boolean isCheckValorHabitacao() {
		return checkValorHabitacao;
	}

	public void setCheckValorHabitacao(boolean checkValorHabitacao) {
		this.checkValorHabitacao = checkValorHabitacao;
	}

	public boolean isCheckSeguroVida() {
		return checkSeguroVida;
	}

	public void setCheckSeguroVida(boolean checkSeguroVida) {
		this.checkSeguroVida = checkSeguroVida;
	}

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
