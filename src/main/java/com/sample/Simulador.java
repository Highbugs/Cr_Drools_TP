package com.sample;

import java.util.Scanner;

import com.sample.model.*;

public class Simulador {
	 public static final void main(String[] args) {
		System.out.println("Welcome to Simulator|Irá ser em parte gráfica|");
		if(getOpcao() != 4) {
			Cliente cliente = getInformacaoCliente();
			System.out.println(cliente);
		} else {
			Estudante estudante = getInformacaoEstudante();
			System.out.println(estudante);
		}
	 }
	 public static int getOpcao() {
		 int op = 0;
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Escolher crédito para  simulação");
		 System.out.println("1-> Crédito Pessoal");
		 System.out.println("2-> Crédito Automóv3el");
		 System.out.println("3-> Crédito Habitação");
		 System.out.println("4-> Crédito Estudante");
		 System.out.print("opcao : ");
		 op= sc.nextInt();
		 return op;
	 }
	 public static Estudante getInformacaoEstudante(){
		 Scanner sc = new Scanner(System.in);
		 Estudante x = new Estudante(null,0,false,0,0,false,false);
		 System.out.println("Nome:");
		 x.setNome(sc.nextLine());
		 System.out.println("Idade:");
		 x.setIdade(sc.nextInt());
		 System.out.println("Ano de escolaridade:");
		 x.setAnoEscolaridade(sc.nextInt());
		 if (x.getAnoEscolaridade() > 1) {
			 System.out.println("Média:");
			 x.setMediaCurso(sc.nextFloat());
		 }
		 System.out.println("Já tem créditos iguas ? (S/N)");
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
		 System.out.println("Tem fiador ? (S/N)");
		 String fiador = sc.nextLine(); 
		 if(fiador.equalsIgnoreCase("S")) {
			 x.setFiador(getInformacaoCliente());
		 } else {
			 x.setFiador(null);
		 }
		 System.out.println("Tem histórico de incumprimento ?(S/N)");
		 String historicoIncumprimento = sc.nextLine(); 
		 if(historicoIncumprimento.equalsIgnoreCase("S")) {
			 x.setHistoricoIncumprimento(true);
		 } else {
			 x.setHistoricoIncumprimento(false);
		 }
		 return x;
	 }
	 public static Cliente getInformacaoCliente(){
		 Scanner sc = new Scanner(System.in);
		 Cliente x = new Cliente(null, 0, false, 0, 0, 0, null);
		 System.out.println("Nome:");
		 x.setNome(sc.nextLine());
		 System.out.println("Idade:");
		 x.setIdade(sc.nextInt());
		 System.out.println("Ordenado:");
		 x.setOrdenado(sc.nextFloat());
		 System.out.println("Total de despesas em créditos:");
		 x.setTotalDespesasCreditos(sc.nextFloat());
		 System.out.println("Tem histórico de incumprimento ?(S/N)");
		 sc.nextLine();
		 String historicoIncumprimento = sc.nextLine(); 
		 if(historicoIncumprimento.equalsIgnoreCase("S")) {
			 x.setHistoricoIncumprimento(true);
		 } else {
			 x.setHistoricoIncumprimento(false);
		 }
		 return x;
	 }
}
