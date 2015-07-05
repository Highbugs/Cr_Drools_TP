//package com.UI;
//
//import org.drools.KnowledgeBase;
//import org.drools.KnowledgeBaseFactory;
//import org.drools.builder.KnowledgeBuilder;
//import org.drools.builder.KnowledgeBuilderError;
//import org.drools.builder.KnowledgeBuilderErrors;
//import org.drools.builder.KnowledgeBuilderFactory;
//import org.drools.builder.ResourceType;
//import org.drools.io.ResourceFactory;
//import org.drools.logger.KnowledgeRuntimeLogger;
//import org.drools.logger.KnowledgeRuntimeLoggerFactory;
//import org.drools.runtime.StatefulKnowledgeSession;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//import UI.UIMainWindow;
//
//import com.sample.model.*;
//
//public class Simulador {
//	 public static final void main(String[] args) {
//		 
//		 UIMainWindow mainFrame = new UIMainWindow();
//		 
//		 Scanner sc = new Scanner(System.in);
//		System.out.println("Welcome to Simulator|Ir� ser em parte gr�fica|");
//		switch(getOpcao()) {
//		case 1:
//			Fiador fiador = new Fiador();
//			Cliente clientePessoal = getInformacaoCliente("############################# Dados Cliente #################");
//			System.out.println("Tem fiador?(S/N)");
//			 String Sfiador = sc.nextLine(); 
//			 if(Sfiador.equalsIgnoreCase("S")) {
//				 fiador = getInformacaoFiador();
//			 } else {
//				 fiador = null;
//			 }
//			CreditoPessoal creditoPessoal = getCreditoPessoal();
//			creditoPessoal.setCliente(clientePessoal);
//			
//			startTestsPessoal(creditoPessoal,new Simulador(),fiador);
//			break;
//		case 2:
//			Fiador fiadorAuto = new Fiador();
//			Cliente clienteAutomovel = getInformacaoCliente("############################# Dados Cliente #################");
//			System.out.println("Tem fiador?(S/N)");
//			 String fiadorOpAuto = sc.nextLine(); 
//			 if(fiadorOpAuto.equalsIgnoreCase("S")) {
//				 fiadorAuto = getInformacaoFiador();
//			 } else {
//				 fiadorAuto = null;
//			 }
//			CreditoAutomovel creditoautomovel = getCreditoAutomovel();
//			creditoautomovel.setCliente(clienteAutomovel);
//			
//			startTestsAutomovel(creditoautomovel,new Simulador(),fiadorAuto);
//			break;
//		case 3:
//			Fiador fiadorHabit = new Fiador();
//			Cliente clienteHabitacao = getInformacaoClienteHabitacao();
//			System.out.println("Tem fiador?(S/N)");
//			 String fiadorOpHabit = sc.nextLine(); 
//			 if(fiadorOpHabit.equalsIgnoreCase("S")) {
//				 fiadorHabit = getInformacaoFiador();
//			 } else {
//				 fiadorHabit = null;
//			 }
//			CreditoHabitacao creditoHabitacao = getCreditoHabitacao(clienteHabitacao);
//			creditoHabitacao.setCliente(clienteHabitacao);
//			
//			startTestsHabitacao(creditoHabitacao, new Simulador(), fiadorHabit);
//			break;
//		case 4:
//			Estudante estudante = getInformacaoEstudante();
//			Fiador fiadorEstudante = new Fiador();
//			System.out.println("Tem fiador?(S/N)");
//			 String fiadorOpEst = sc.nextLine(); 
//			 if(fiadorOpEst.equalsIgnoreCase("S")) {
//				 fiadorEstudante = getInformacaoFiador();
//			 } else {
//				 fiadorEstudante = null;
//			 }
//			CreditoEstudante creditoEstudante = getCreditoEstudante();
//			creditoEstudante.setEstudante(estudante);
//			startTestsEstudante(creditoEstudante, new Simulador(), fiadorEstudante);
//			break;
//		default:
//			System.out.println("Op��o errada");
//			break;
//		}
//	 }
//	 private static void startTestsEstudante(CreditoEstudante credito, Simulador simulador, Fiador fiador) {
//		 try {
//	           // load up the knowledge base
//	           KnowledgeBase kbase = readKnowledgeBaseEstudante();
//	           StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
//	           KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
//	           // go !
//	           ksession.insert(credito);
//	           ksession.insert(credito.getEstudante());
//	           ksession.insert(new Reprovado());
//	           if(fiador != null) {
//	               ksession.insert(fiador);
//	           }
//	           ksession.fireAllRules();
//	           logger.close();
//	       } catch (Throwable t) {
//	           t.printStackTrace();
//	       }
//		 }
//	 private static void startTestsAutomovel(Credito credito, Simulador simulador, Fiador fiador) {
//		 try {
//	           // load up the knowledge base
//	           KnowledgeBase kbase = readKnowledgeBaseAutomovel();
//	           StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
//	           KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
//	           // go !
//	           ksession.insert(credito);
//	           ksession.insert(credito.getCliente());
//	           ksession.insert(new Reprovado());
//	           if(fiador != null) {
//	               ksession.insert(fiador);
//	           }
//	           ksession.fireAllRules();
//	           logger.close();
//	       } catch (Throwable t) {
//	           t.printStackTrace();
//	       }
//		 }
//	 private static void startTestsHabitacao(Credito credito, Simulador simulador, Fiador fiador) {
//		 try {
//           // load up the knowledge base
//           KnowledgeBase kbase = readKnowledgeBaseHabitacao();
//           StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
//           KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
//           // go !
//           ksession.insert(credito);
//           ksession.insert(credito.getCliente());
//           ksession.insert(new Reprovado());
//           if(fiador != null) {
//               ksession.insert(fiador);
//           }
//           ksession.fireAllRules();
//           logger.close();
//       } catch (Throwable t) {
//           t.printStackTrace();
//       }
//	 }
//	 private static void startTestsPessoal(Credito credito, Simulador simulador, Fiador fiador) {
//		 try {
//           // load up the knowledge base
//           KnowledgeBase kbase = readKnowledgeBasePessoal();
//           StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
//           KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
//           // go !
//           ksession.insert(credito);
//           ksession.insert(credito.getCliente());
//           ksession.insert(new Reprovado());
//           if(fiador != null) {
//               ksession.insert(fiador);
//           }
//           ksession.fireAllRules();
//           logger.close();
//       } catch (Throwable t) {
//           t.printStackTrace();
//       }
//	 }
//	 private static KnowledgeBase readKnowledgeBaseEstudante() throws Exception {
//	       KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
//	       kbuilder.add(ResourceFactory.newClassPathResource("Regras_Estudante.drl"), ResourceType.DRL);
//	       KnowledgeBuilderErrors errors = kbuilder.getErrors();
//	       if (errors.size() > 0) {
//	           for (KnowledgeBuilderError error: errors) {
//	               System.err.println(error);
//	           }
//	           throw new IllegalArgumentException("Could not parse knowledge.");
//	       }
//	       KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
//	       kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
//	       return kbase;
//	   }
//	 private static KnowledgeBase readKnowledgeBaseHabitacao() throws Exception {
//	       KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
//	       kbuilder.add(ResourceFactory.newClassPathResource("Regras_habitacao.drl"), ResourceType.DRL);
//	       KnowledgeBuilderErrors errors = kbuilder.getErrors();
//	       if (errors.size() > 0) {
//	           for (KnowledgeBuilderError error: errors) {
//	               System.err.println(error);
//	           }
//	           throw new IllegalArgumentException("Could not parse knowledge.");
//	       }
//	       KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
//	       kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
//	       return kbase;
//	   }
//	 private static KnowledgeBase readKnowledgeBaseAutomovel() throws Exception {
//	       KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
//	       kbuilder.add(ResourceFactory.newClassPathResource("Regras_automovel.drl"), ResourceType.DRL);
//	       KnowledgeBuilderErrors errors = kbuilder.getErrors();
//	       if (errors.size() > 0) {
//	           for (KnowledgeBuilderError error: errors) {
//	               System.err.println(error);
//	           }
//	           throw new IllegalArgumentException("Could not parse knowledge.");
//	       }
//	       KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
//	       kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
//	       return kbase;
//	   }
// 	 private static KnowledgeBase readKnowledgeBasePessoal() throws Exception {
//       KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
//       kbuilder.add(ResourceFactory.newClassPathResource("Sample.drl"), ResourceType.DRL);
//       KnowledgeBuilderErrors errors = kbuilder.getErrors();
//       if (errors.size() > 0) {
//           for (KnowledgeBuilderError error: errors) {
//               System.err.println(error);
//           }
//           throw new IllegalArgumentException("Could not parse knowledge.");
//       }
//       KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
//       kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
//       return kbase;
//   }
// 	 public static CreditoEstudante getCreditoEstudante() {
//		 Scanner sc = new Scanner(System.in);
//		 CreditoEstudante credito = new CreditoEstudante(null, 0,0,"Variavel",0,0,0,0,0,false);
//		 System.out.println("########### Dados Cr�dito Estudante ####################");
//		 System.out.println("Montante escolhido");
//		 credito.setMontanteEscolhido(sc.nextFloat());
//		 System.out.println("Prazo Amortiza��o(meses)");
//		 credito.setPrazoAmortizacao(sc.nextInt());
//		 System.out.println("Investir Produto Finaceiro (S/N)");
//		 String produto = sc.next();
//		 if(produto.equalsIgnoreCase("S")) {
//			 credito.setProdutofinanceiro(true);
//		 } else {
//			 credito.setProdutofinanceiro(false);
//		 }
//		 System.out.println("##############################################"); 
//		 return credito;
//		 
//	 }
// 	 public static CreditoHabitacao getCreditoHabitacao(Cliente cliente) {
//		 Scanner sc = new Scanner(System.in);
//		 CreditoHabitacao credito = new CreditoHabitacao(null,0,0,null,0,0,0,0,0,false,false,false);
//		 System.out.println("########### Dados Cr�dito ####################");
//		 System.out.println("Montante escolhido");
//		 credito.setMontanteEscolhido(sc.nextFloat());
//		 System.out.println("Prazo Amortiza��o(meses)");
//		 credito.setPrazoAmortizacao(sc.nextInt());
//		 System.out.println("Valor Imovel");
//		 credito.setValorImovel(sc.nextFloat());
//		 System.out.println("Taxa de Juro -> Fixa(F)/Variavel Euribor a 6 meses(V)");
//		 String tipoTaxa = sc.next();
//		 if(tipoTaxa.equalsIgnoreCase("F")) {
//			 credito.setTipoJuros("Fixo");
//		 } else {
//			 credito.setTipoJuros("Variavel");
//		 }
//		 System.out.println("Seguro Cr�dito (S/N)");
//		 String seguro = sc.next();
//		 if(seguro.equalsIgnoreCase("S")) {
//			 credito.setSeguroCredito(true);
//		 } else {
//			 credito.setSeguroCredito(false);
//		 }
//		 if(!cliente.isSeguroVida()) {
//			 System.out.println("Seguro Vida (S/N)");
//			 seguro = sc.next();
//			 if(seguro.equalsIgnoreCase("S")) {
//				 credito.setSeguroVida(true);
//				 cliente.setSeguroVida(true);
//			 } else {
//				 credito.setSeguroVida(false);
//			 }
//		 }
//		 System.out.println("Investir Produto Finaceiro (S/N)");
//		 seguro = sc.next();
//		 if(seguro.equalsIgnoreCase("S")) {
//			 credito.setProdutofinanceiro(true);
//		 } else {
//			 credito.setProdutofinanceiro(false);
//		 }
//		 System.out.println("##############################################");
//		 
//		 return credito;
//		 
//	 }
//	 public static CreditoPessoal getCreditoPessoal() {
//		 Scanner sc = new Scanner(System.in);
//		 CreditoPessoal credito = new CreditoPessoal(null,0,0,null,0,0,0,0,0,false,false,false);
//		 System.out.println("########### Dados Cr�dito ####################");
//		 System.out.println("Montante escolhido");
//		 credito.setMontanteEscolhido(sc.nextFloat());
//		 System.out.println("Prazo Amortiza��o(meses)");
//		 credito.setPrazoAmortizacao(sc.nextInt());
//		 System.out.println("Taxa de Juro -> Fixa(F)/Variavel Euribor a 6 meses(V)");
//		 String tipoTaxa = sc.next();
//		 if(tipoTaxa.equalsIgnoreCase("F")) {
//			 credito.setTipoJuros("Fixo");
//		 } else {
//			 credito.setTipoJuros("Variavel");
//		 }
//		 System.out.println("Seguro Cr�dito (S/N)");
//		 String seguro = sc.next();
//		 if(seguro.equalsIgnoreCase("S")) {
//			 credito.setSeguroCredito(true);
//		 } else {
//			 credito.setSeguroCredito(false);
//		 }
//		 System.out.println("Seguro Vida (S/N)");
//		 seguro = sc.next();
//		 if(seguro.equalsIgnoreCase("S")) {
//			 credito.setSeguroVida(true);
//		 } else {
//			 credito.setSeguroVida(false);
//		 }
//		 System.out.println("Investir Produto Finaceiro (S/N)");
//		 seguro = sc.next();
//		 if(seguro.equalsIgnoreCase("S")) {
//			 credito.setProdutofinanceiro(true);
//		 } else {
//			 credito.setProdutofinanceiro(false);
//		 }
//		 System.out.println("##############################################");
//		 return credito;
//	 }
//	 public static CreditoAutomovel getCreditoAutomovel()
//	 {
//		 Scanner sc = new Scanner(System.in);
//		 CreditoAutomovel credito = new CreditoAutomovel(null,0,0,null,0, 0, 0,0,0,false,false,false,false);
//		 System.out.println("########### Dados Cr�dito ####################");
//		 System.out.println("Montante escolhido");
//		 credito.setMontanteEscolhido(sc.nextFloat());
//		 System.out.println("Prazo Amortiza��o(meses)");
//		 credito.setPrazoAmortizacao(sc.nextInt());
//		 System.out.println("Taxa de Juro -> Fixa(F)/Variavel Euribor a 6 meses(V)");
//		 String tipoTaxa = sc.next();
//		 if(tipoTaxa.equalsIgnoreCase("F")) {
//			 credito.setTipoJuros("Fixo");
//		 } else {
//			 credito.setTipoJuros("Variavel");
//		 }
//		 System.out.println("Seguro Autom�vel (S/N)");
//		 String seguro = sc.next();
//		 if(seguro.equalsIgnoreCase("S")) {
//			 credito.setSeguroCarro(true);
//		 } else {
//			 credito.setSeguroCarro(false);
//		 }
//		 System.out.println("Seguro Cr�dito (S/N)");
//		 seguro = sc.next();
//		 if(seguro.equalsIgnoreCase("S")) {
//			 credito.setSeguroCredito(true);
//		 } else {
//			 credito.setSeguroCredito(false);
//		 }
//		 System.out.println("Seguro Vida (S/N)");
//		 seguro = sc.next();
//		 if(seguro.equalsIgnoreCase("S")) {
//			 credito.setSeguroVida(true);
//		 } else {
//			 credito.setSeguroVida(false);
//		 }
//		 System.out.println("Investir Produto Finaceiro (S/N)");
//		 seguro = sc.next();
//		 if(seguro.equalsIgnoreCase("S")) {
//			 credito.setProdutofinanceiro(true);
//		 } else {
//			 credito.setProdutofinanceiro(false);
//		 }
//		 System.out.println("##############################################");
//		 return credito;
//	 }
//	 public static int getOpcao() {
//		 int op = 0;
//		 Scanner sc = new Scanner(System.in);
//		 System.out.println("Escolher cr�dito para  simula��o");
//		 System.out.println("1-> Cr�dito Pessoal");
//		 System.out.println("2-> Cr�dito Autom�v3el");
//		 System.out.println("3-> Cr�dito Habita��o");
//		 System.out.println("4-> Cr�dito Estudante");
//		 System.out.print("opcao : ");
//		 op= sc.nextInt();
//		 return op;
//	 }
//	 public static Estudante getInformacaoEstudante(){
//		 System.out.println("########### DADOS ESTUDANTE ####################");
//		 Scanner sc = new Scanner(System.in);
//		 Estudante x = new Estudante(null,0,false,0,0,false,false);
//		 System.out.println("Nome:");
//		 x.setNome(sc.nextLine());
//		 System.out.println("Idade:");
//		 x.setIdade(sc.nextInt());
//		 System.out.println("Ano de escolaridade:");
//		 x.setAnoEscolaridade(sc.nextInt());
//		 if (x.getAnoEscolaridade() > 1) {
//			 System.out.println("M�dia:");
//			 x.setMediaCurso(sc.nextFloat());
//		 }
//		 System.out.println("J� tem cr�ditos iguas ? (S/N)");
//		 sc.nextLine();
//		 String creditosIguais = sc.nextLine(); 
//		 if(creditosIguais.equalsIgnoreCase("S")) {
//			 x.setCreditosIguais(true);
//		 } else {
//			 x.setCreditosIguais(false);
//		 }
//		 System.out.println("Encontra-se matriculado na universidade ? (S/N)");
//		 String matriculaUniversidade = sc.nextLine(); 
//		 if(creditosIguais.equalsIgnoreCase("S")) {
//			 x.setMatriculadoUniversidade(false);
//		 } else {
//			 x.setMatriculadoUniversidade(true);
//		 }
//		 System.out.println("Tem hist�rico de incumprimento ?(S/N)");
//		 String historicoIncumprimento = sc.nextLine(); 
//		 if(historicoIncumprimento.equalsIgnoreCase("S")) {
//			 x.setHistoricoIncumprimento(true);
//		 } else {
//			 x.setHistoricoIncumprimento(false);
//		 }
//		 System.out.println("Tem nacionalidade Portuguesa ?(S/N)");
//		 String nacionalidade = sc.nextLine(); 
//		 if(nacionalidade.equalsIgnoreCase("S")) {
//			 x.setNacionalidadePortuguesa(true);
//		 } else {
//			 x.setNacionalidadePortuguesa(false);
//		 }
//		 System.out.println("Tem Conta Banc�ria ?(S/N)");
//		 String conta = sc.nextLine(); 
//		 if(conta.equalsIgnoreCase("S")) {
//			 x.setContaBancaria(true);
//		 } else {
//			 x.setContaBancaria(false);
//		 }
//		 return x;
//	 }
//	 public static Cliente getInformacaoClienteHabitacao() {
//		 System.out.println("################## Cliente Cr�dito Habita��o ############");
//		 Scanner sc = new Scanner(System.in);
//		 Cliente x = new Cliente(null, 0, false, 0, 0, 0, null);
//		 System.out.println("Nome:");
//		 x.setNome(sc.nextLine());
//		 System.out.println("Idade:");
//		 x.setIdade(sc.nextInt());
//		 System.out.println("Ordenado:");
//		 x.setOrdenado(sc.nextFloat());
//		 System.out.println("Total de despesas em cr�ditos:");
//		 x.setTotalDespesasCreditos(sc.nextFloat());
//		 System.out.println("Tem Seguro Vida (S/N)");
//		 String seguro = sc.next();
//		 if(seguro.equalsIgnoreCase("S")) {
//			 x.setSeguroVida(true);
//		 } else {
//			 x.setSeguroVida(false);
//		 }
//		 System.out.println("Tem hist�rico de incumprimento ?(S/N)");
//		 sc.nextLine();
//		 String historicoIncumprimento = sc.nextLine(); 
//		 if(historicoIncumprimento.equalsIgnoreCase("S")) {
//			 x.setHistoricoIncumprimento(true);
//		 } else {
//			 x.setHistoricoIncumprimento(false);
//		 }
//		 System.out.println("Tem Conta Banc�ria ?(S/N)");
//		 String conta = sc.nextLine(); 
//		 if(conta.equalsIgnoreCase("S")) {
//			 x.setContaBancaria(true);
//		 } else {
//			 x.setContaBancaria(false);
//		 }
//		 System.out.println("Tem Empreso a mais de 3 meses?(S/N)");
//		 String emprego = sc.nextLine(); 
//		 if(emprego.equalsIgnoreCase("S")) {
//			 x.setEmprego(true);
//		 } else {
//			 x.setEmprego(false);
//		 }
//		 System.out.println("##########################################################");
//		 return x;
//	 }
//	 public static Fiador getInformacaoFiador(){
//		 System.out.println("################## informacao fiador ##################");
//		 Scanner sc = new Scanner(System.in);
//		 Fiador x = new Fiador();
//		 System.out.println("Nome:");
//		 x.setNome(sc.nextLine());
//		 System.out.println("Idade:");
//		 x.setIdade(sc.nextInt());
//		 System.out.println("Ordenado:");
//		 x.setOrdenado(sc.nextFloat());
//		 System.out.println("Total de despesas em cr�ditos:");
//		 x.setTotalDespesasCreditos(sc.nextFloat());
//		 System.out.println("Tem hist�rico de incumprimento ?(S/N)");
//		 sc.nextLine();
//		 String historicoIncumprimento = sc.nextLine(); 
//		 if(historicoIncumprimento.equalsIgnoreCase("S")) {
//			 x.setHistoricoIncumprimento(true);
//		 } else {
//			 x.setHistoricoIncumprimento(false);
//		 }
//		 System.out.println("Tem Conta Banc�ria ?(S/N)");
//		 String conta = sc.nextLine(); 
//		 if(conta.equalsIgnoreCase("S")) {
//			 x.setContaBancaria(true);
//		 } else {
//			 x.setContaBancaria(false);
//		 }
//		 System.out.println("Tem Empreso a mais de 3 meses?(S/N)");
//		 String emprego = sc.nextLine(); 
//		 if(emprego.equalsIgnoreCase("S")) {
//			 x.setEmprego(true);
//		 } else {
//			 x.setEmprego(false);
//		 }
//		 System.out.println("##########################################################");
//		 return x;
//	 }
//	 public static Cliente getInformacaoCliente(String titulo){
//		 System.out.println(titulo);
//		 Scanner sc = new Scanner(System.in);
//		 Cliente x = new Cliente(null, 0, false, 0, 0, 0, null);
//		 System.out.println("Nome:");
//		 x.setNome(sc.nextLine());
//		 System.out.println("Idade:");
//		 x.setIdade(sc.nextInt());
//		 System.out.println("Ordenado:");
//		 x.setOrdenado(sc.nextFloat());
//		 System.out.println("Total de despesas em cr�ditos:");
//		 x.setTotalDespesasCreditos(sc.nextFloat());
//		 System.out.println("Tem hist�rico de incumprimento ?(S/N)");
//		 sc.nextLine();
//		 String historicoIncumprimento = sc.nextLine(); 
//		 if(historicoIncumprimento.equalsIgnoreCase("S")) {
//			 x.setHistoricoIncumprimento(true);
//		 } else {
//			 x.setHistoricoIncumprimento(false);
//		 }
//		 System.out.println("Tem Conta Banc�ria ?(S/N)");
//		 String conta = sc.nextLine(); 
//		 if(conta.equalsIgnoreCase("S")) {
//			 x.setContaBancaria(true);
//		 } else {
//			 x.setContaBancaria(false);
//		 }
//		 System.out.println("Tem Empreso a mais de 3 meses?(S/N)");
//		 String emprego = sc.nextLine(); 
//		 if(emprego.equalsIgnoreCase("S")) {
//			 x.setEmprego(true);
//		 } else {
//			 x.setEmprego(false);
//		 }
//		 System.out.println("##########################################################");
//		 return x;
//	 }
//}
