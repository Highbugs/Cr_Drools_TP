package com.sample;

import java.util.Scanner;

import com.sample.model.*;

public class Simulador {
	 public static final void main(String[] args) {
		System.out.println("Welcome to Simulator|Ir� ser em parte gr�fica|");
		switch(getOpcao()) {
		case 1:
			Cliente clientePessoal = getInformacaoCliente("############################# Dados Cliente #################");
			CreditoPessoal creditoPessoal = getCreditoPessoal();
			creditoPessoal.setCliente(clientePessoal);
			break;
		case 2:
			Cliente clienteAutomovel = getInformacaoCliente("############################# Dados Cliente #################");
			CreditoAutomovel creditoAutomovel = getCreditoAutomovel();
			creditoAutomovel.setCliente(clienteAutomovel);
			break;
		case 3:
			Cliente clienteHabitacao = getInformacaoClienteHabitacao();
			CreditoHabitacao creditoHabitacao = getCreditoHabitacao();
			creditoHabitacao.setCliente(clienteHabitacao);
			break;
		case 4:
			Estudante estudante = getInformacaoEstudante();
			break;
		default:
			System.out.println("Op��o errada");
			break;
		}
	 }
	 public static CreditoHabitacao getCreditoHabitacao() {
		 Scanner sc = new Scanner(System.in);
		 CreditoHabitacao credito = new CreditoHabitacao(null,0,0,null,0,0,0,0,0,false,false,false);
		 System.out.println("########### Dados Cr�dito ####################");
		 System.out.println("Montante escolhido");
		 credito.setMontanteEscolhido(sc.nextFloat());
		 System.out.println("Prazo Amortiza��o(meses)");
		 credito.setPrazoAmortizacao(sc.nextInt());
		 System.out.println("Taxa de Juro -> Fixa(F)/Variavel Euribor a 6 meses(V)");
		 String tipoTaxa = sc.next();
		 if(tipoTaxa.equalsIgnoreCase("F")) {
			 credito.setTipoJuros("Fixa");
		 } else {
			 credito.setTipoJuros("Variavel");
		 }
		 System.out.println("Seguro Cr�dito (S/N)");
		 String seguro = sc.next();
		 if(seguro.equalsIgnoreCase("S")) {
			 credito.setSeguroCredito(true);
		 } else {
			 credito.setSeguroCredito(false);
		 }
		 System.out.println("Investir Produto Finaceiro (S/N)");
		 seguro = sc.next();
		 if(seguro.equalsIgnoreCase("S")) {
			 credito.setProdutofinanceiro(true);
		 } else {
			 credito.setProdutofinanceiro(false);
		 }
		 System.out.println("##############################################");
		 return credito;
		 
	 }
	 public static CreditoPessoal getCreditoPessoal() {
		 Scanner sc = new Scanner(System.in);
		 CreditoPessoal credito = new CreditoPessoal(null,0,0,null,0,0,0,0,0,false,false,false);
		 System.out.println("########### Dados Cr�dito ####################");
		 System.out.println("Montante escolhido");
		 credito.setMontanteEscolhido(sc.nextFloat());
		 System.out.println("Prazo Amortiza��o(meses)");
		 credito.setPrazoAmortizacao(sc.nextInt());
		 System.out.println("Taxa de Juro -> Fixa(F)/Variavel Euribor a 6 meses(V)");
		 String tipoTaxa = sc.next();
		 if(tipoTaxa.equalsIgnoreCase("F")) {
			 credito.setTipoJuros("Fixa");
		 } else {
			 credito.setTipoJuros("Variavel");
		 }
		 System.out.println("Seguro Cr�dito (S/N)");
		 String seguro = sc.next();
		 if(seguro.equalsIgnoreCase("S")) {
			 credito.setSeguroCredito(true);
		 } else {
			 credito.setSeguroCredito(false);
		 }
		 System.out.println("Seguro Vida (S/N)");
		 seguro = sc.next();
		 if(seguro.equalsIgnoreCase("S")) {
			 credito.setSeguroVida(true);
		 } else {
			 credito.setSeguroVida(false);
		 }
		 System.out.println("Investir Produto Finaceiro (S/N)");
		 seguro = sc.next();
		 if(seguro.equalsIgnoreCase("S")) {
			 credito.setProdutofinanceiro(true);
		 } else {
			 credito.setProdutofinanceiro(false);
		 }
		 System.out.println("##############################################");
		 return credito;
	 }
	 public static CreditoAutomovel getCreditoAutomovel()
	 {
		 Scanner sc = new Scanner(System.in);
		 CreditoAutomovel credito = new CreditoAutomovel(null,0,0,null,0, 0, 0,0,0,false,false,false,false);
		 System.out.println("########### Dados Cr�dito ####################");
		 System.out.println("Montante escolhido");
		 credito.setMontanteEscolhido(sc.nextFloat());
		 System.out.println("Prazo Amortiza��o(meses)");
		 credito.setPrazoAmortizacao(sc.nextInt());
		 System.out.println("Taxa de Juro -> Fixa(F)/Variavel Euribor a 6 meses(V)");
		 String tipoTaxa = sc.next();
		 if(tipoTaxa.equalsIgnoreCase("F")) {
			 credito.setTipoJuros("Fixa");
		 } else {
			 credito.setTipoJuros("Variavel");
		 }
		 System.out.println("Seguro Autom�vel (S/N)");
		 String seguro = sc.next();
		 if(seguro.equalsIgnoreCase("S")) {
			 credito.setSeguroCarro(true);
		 } else {
			 credito.setSeguroCarro(false);
		 }
		 System.out.println("Seguro Cr�dito (S/N)");
		 seguro = sc.next();
		 if(seguro.equalsIgnoreCase("S")) {
			 credito.setSeguroCredito(true);
		 } else {
			 credito.setSeguroCredito(false);
		 }
		 System.out.println("Seguro Vida (S/N)");
		 seguro = sc.next();
		 if(seguro.equalsIgnoreCase("S")) {
			 credito.setSeguroVida(true);
		 } else {
			 credito.setSeguroVida(false);
		 }
		 System.out.println("Investir Produto Finaceiro (S/N)");
		 seguro = sc.next();
		 if(seguro.equalsIgnoreCase("S")) {
			 credito.setProdutofinanceiro(true);
		 } else {
			 credito.setProdutofinanceiro(false);
		 }
		 System.out.println("##############################################");
		 return credito;
	 }
	 public static int getOpcao() {
		 int op = 0;
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Escolher cr�dito para  simula��o");
		 System.out.println("1-> Cr�dito Pessoal");
		 System.out.println("2-> Cr�dito Autom�v3el");
		 System.out.println("3-> Cr�dito Habita��o");
		 System.out.println("4-> Cr�dito Estudante");
		 System.out.print("opcao : ");
		 op= sc.nextInt();
		 return op;
	 }
	 public static Estudante getInformacaoEstudante(){
		 System.out.println("########### DADOS ESTUDANTE ####################");
		 Scanner sc = new Scanner(System.in);
		 Estudante x = new Estudante(null,0,false,0,0,false,false);
		 System.out.println("Nome:");
		 x.setNome(sc.nextLine());
		 System.out.println("Idade:");
		 x.setIdade(sc.nextInt());
		 System.out.println("Ano de escolaridade:");
		 x.setAnoEscolaridade(sc.nextInt());
		 if (x.getAnoEscolaridade() > 1) {
			 System.out.println("M�dia:");
			 x.setMediaCurso(sc.nextFloat());
		 }
		 System.out.println("J� tem cr�ditos iguas ? (S/N)");
		 sc.nextLine();
		 String creditosIguais = sc.nextLine(); 
		 if(creditosIguais.equalsIgnoreCase("S")) {
			 x.setCreditosIguais(true);
		 } else {
			 x.setCreditosIguais(false);
		 }
		 System.out.println("Encontra-se matriculado na universidade ? (S/N)");
		 String matriculaUniversidade = sc.nextLine(); 
		 if(creditosIguais.equalsIgnoreCase("S")) {
			 x.setMatriculadoUniversidade(true);
		 } else {
			 x.setMatriculadoUniversidade(false);
		 }
		 System.out.println("Tem hist�rico de incumprimento ?(S/N)");
		 String historicoIncumprimento = sc.nextLine(); 
		 if(historicoIncumprimento.equalsIgnoreCase("S")) {
			 x.setHistoricoIncumprimento(true);
		 } else {
			 x.setHistoricoIncumprimento(false);
		 }
		 System.out.println("Tem fiador ? (S/N)");
		 String fiador = sc.nextLine();
		 System.out.println("##########################################################");
		 if(fiador.equalsIgnoreCase("S")) {
			 x.setFiador(getInformacaoCliente("############################# Dados Fiador #################"));
		 } else {
			 x.setFiador(null);
		 }
		 return x;
	 }
	 public static Cliente getInformacaoClienteHabitacao() {
		 System.out.println("################## Cliente Cr�dito Habita��o ############");
		 Scanner sc = new Scanner(System.in);
		 Cliente x = new Cliente(null, 0, false, 0, 0, 0, null);
		 System.out.println("Nome:");
		 x.setNome(sc.nextLine());
		 System.out.println("Idade:");
		 x.setIdade(sc.nextInt());
		 System.out.println("Ordenado:");
		 x.setOrdenado(sc.nextFloat());
		 System.out.println("Total de despesas em cr�ditos:");
		 x.setTotalDespesasCreditos(sc.nextFloat());
		 System.out.println("Tem Seguro Vida (S/N)");
		 String seguro = sc.next();
		 if(seguro.equalsIgnoreCase("S")) {
			 x.setSeguroVida(true);
		 } else {
			 x.setSeguroVida(false);
		 }
		 System.out.println("Tem hist�rico de incumprimento ?(S/N)");
		 sc.nextLine();
		 String historicoIncumprimento = sc.nextLine(); 
		 if(historicoIncumprimento.equalsIgnoreCase("S")) {
			 x.setHistoricoIncumprimento(true);
		 } else {
			 x.setHistoricoIncumprimento(false);
		 }
		 System.out.println("##########################################################");
		 return x;
	 }
	 public static Cliente getInformacaoCliente(String titulo){
		 System.out.println(titulo);
		 Scanner sc = new Scanner(System.in);
		 Cliente x = new Cliente(null, 0, false, 0, 0, 0, null);
		 System.out.println("Nome:");
		 x.setNome(sc.nextLine());
		 System.out.println("Idade:");
		 x.setIdade(sc.nextInt());
		 System.out.println("Ordenado:");
		 x.setOrdenado(sc.nextFloat());
		 System.out.println("Total de despesas em cr�ditos:");
		 x.setTotalDespesasCreditos(sc.nextFloat());
		 System.out.println("Tem hist�rico de incumprimento ?(S/N)");
		 sc.nextLine();
		 String historicoIncumprimento = sc.nextLine(); 
		 if(historicoIncumprimento.equalsIgnoreCase("S")) {
			 x.setHistoricoIncumprimento(true);
		 } else {
			 x.setHistoricoIncumprimento(false);
		 }
		 System.out.println("##########################################################");
		 return x;
	 }
}
