package com.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import com.sample.Simulador;
import com.sample.model.Cliente;
import com.sample.model.Credito;
import com.sample.model.CreditoAutomovel;
import com.sample.model.CreditoEstudante;
import com.sample.model.CreditoPessoal;
import com.sample.model.Fiador;
import com.sample.model.Reprovado;

public class CreditDetails extends JFrame{

	private JPanel mainPanel;
	private ArrayList<FormItemLayout> form_list;
	private JButton next_btn;
	private Cliente client;
	
	private int credit_type;
	
	public CreditDetails(Cliente c, int type){ //type 0-> pessoal  1-> automóvel
		
		setSize(500, 500);
		
		credit_type = type;
		client = c;
		
		form_list = new ArrayList<>();
		setList();
		setPanel();
		
		setListeners();
		
		setVisible(true);
	}
	
	private void setPanel(){
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel("Crédito - Detalhes");
		title.setFont(new Font("Serif", Font.PLAIN, 30));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		mainPanel.add(title);
		
		mainPanel.add(Box.createRigidArea(new Dimension(15, 10)));
		
		for(int i = 0; i < form_list.size(); i++)
			mainPanel.add(form_list.get(i));
		
		next_btn = new JButton("Simular");
		next_btn.setAlignmentX(CENTER_ALIGNMENT);
		
		mainPanel.add(next_btn);
		
		add(mainPanel);
	}
	
	private void setListeners(){
		
		next_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(isFormCompleted()){
					
					float amount = Float.parseFloat(String.valueOf(form_list.get(0).text.getText()));
					int deadline = Integer.parseInt(String.valueOf(form_list.get(1).text.getText()));
					
					String tax;
					if(form_list.get(2).selected)
						tax = "Fixo";
					else
						tax = "Variavel";
					
					boolean credit_ins = form_list.get(3).selected;
					boolean life_ins = form_list.get(4).selected;
					boolean invest = form_list.get(5).selected;
					if(credit_type == 1) {
						amount = Float.parseFloat(String.valueOf(form_list.get(0).text.getText()));
						deadline = Integer.parseInt(String.valueOf(form_list.get(1).text.getText()));
						boolean auto_ins = form_list.get(3).selected;
						if(form_list.get(2).selected)
							tax = "Fixo";
						else
							tax = "Variavel";
						credit_ins = form_list.get(4).selected;
						life_ins = form_list.get(5).selected;
						invest = form_list.get(6).selected;
						CreditoAutomovel credit = new CreditoAutomovel(client, amount, deadline, tax,0, 0, 0,0, 0,life_ins,credit_ins,invest,auto_ins);
						startTestsAutomovel(credit, client.getFiador());
					} else {
					CreditoPessoal credit = new CreditoPessoal(client, amount, deadline, tax, 0, 0, 0, 0, 0, life_ins, credit_ins, invest);
					startTestsPessoal(credit, client.getFiador());
					}
				}
				
			}
		});
	}
	
	private boolean isFormCompleted(){
		
		boolean fine = false;
		
		for(int i = 0; i < form_list.size(); i++){
			
			//Para ver se tem texto ou não
			if(form_list.get(i).text != null && form_list.get(i).text.getText().equals("")){
				form_list.get(i).label.setForeground(Color.RED);
				return false;
			}else{
				
				//Para ver se foi introduzido um número ou não
				if(i == 0 || i == 1){
					try{
						
						Integer.parseInt(String.valueOf(form_list.get(i).text.getText()));
						fine = true;
					}catch(NumberFormatException e){
						form_list.get(i).label.setForeground(Color.RED);
						fine = false;
					}finally{
						
						if(fine == true)
							form_list.get(i).label.setForeground(Color.BLACK);
						else
							return false;
					}
				}else
					form_list.get(i).label.setForeground(Color.BLACK);
			}
			
			if(form_list.get(i).yes_btn != null && !form_list.get(i).yes_btn.isSelected()){
				
				if(form_list.get(i).no_btn != null && !form_list.get(i).no_btn.isSelected()){
					
					form_list.get(i).label.setForeground(Color.RED);
					return false;
				}else{
					form_list.get(i).label.setForeground(Color.BLACK);
					form_list.get(i).selected = false;
				}
			}else
				form_list.get(i).selected = true;
		}
		
		return true;
	}
	
	private void setList(){
		
		form_list.add(new FormItemLayout("Montante", 0));
		form_list.add(new FormItemLayout("Prazo Amortização(Meses)", 0));
		form_list.add(new FormItemLayout("Taxa de Juro", 2));
		
		if(credit_type == 1)
			form_list.add(new FormItemLayout("Seguro Automóvel", 1));
		
		form_list.add(new FormItemLayout("Seguro Crédito", 1));
		
		if(!client.isSeguroVida())
			form_list.add(new FormItemLayout("Seguro de Vida", 1));
		
		form_list.add(new FormItemLayout("Investir Produto Financeiro", 1));
	}
	 private static void startTestsEstudante(CreditoEstudante credito, Fiador fiador) {
		 try {
	           // load up the knowledge base
	           KnowledgeBase kbase = readKnowledgeBaseEstudante();
	           StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
	           KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
	           // go !
	           ksession.insert(credito);
	           ksession.insert(credito.getEstudante());
	           ksession.insert(new Reprovado());
	           if(fiador != null) {
	               ksession.insert(fiador);
	           }
	           ksession.fireAllRules();
	           logger.close();
	       } catch (Throwable t) {
	           t.printStackTrace();
	       }
		 }
	 private static void startTestsAutomovel(Credito credito, Fiador fiador) {
		 try {
	           // load up the knowledge base
	           KnowledgeBase kbase = readKnowledgeBaseAutomovel();
	           StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
	           KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
	           // go !
	           ksession.insert(credito);
	           ksession.insert(credito.getCliente());
	           ksession.insert(new Reprovado());
	           if(fiador != null) {
	               ksession.insert(fiador);
	           }
	           ksession.fireAllRules();
	           logger.close();
	       } catch (Throwable t) {
	           t.printStackTrace();
	       }
		 }
	 private static void startTestsHabitacao(Credito credito, Fiador fiador) {
		 try {
           // load up the knowledge base
           KnowledgeBase kbase = readKnowledgeBaseHabitacao();
           StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
           KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
           // go !
           ksession.insert(credito);
           ksession.insert(credito.getCliente());
           ksession.insert(new Reprovado());
           if(fiador != null) {
               ksession.insert(fiador);
           }
           ksession.fireAllRules();
           logger.close();
       } catch (Throwable t) {
           t.printStackTrace();
       }
	 }
	 private static void startTestsPessoal(Credito credito, Fiador fiador) {
		 try {
           // load up the knowledge base
           KnowledgeBase kbase = readKnowledgeBasePessoal();
           StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
           KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
           // go !
           ksession.insert(credito);
           ksession.insert(credito.getCliente());
           ksession.insert(new Reprovado());
           if(fiador != null) {
               ksession.insert(fiador);
           }
           ksession.fireAllRules();
           logger.close();
       } catch (Throwable t) {
           t.printStackTrace();
       }
	 }
	 private static KnowledgeBase readKnowledgeBaseEstudante() throws Exception {
	       KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
	       kbuilder.add(ResourceFactory.newClassPathResource("Regras_Estudante.drl"), ResourceType.DRL);
	       KnowledgeBuilderErrors errors = kbuilder.getErrors();
	       if (errors.size() > 0) {
	           for (KnowledgeBuilderError error: errors) {
	               System.err.println(error);
	           }
	           throw new IllegalArgumentException("Could not parse knowledge.");
	       }
	       KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
	       kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
	       return kbase;
	   }
	 private static KnowledgeBase readKnowledgeBaseHabitacao() throws Exception {
	       KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
	       kbuilder.add(ResourceFactory.newClassPathResource("Regras_habitacao.drl"), ResourceType.DRL);
	       KnowledgeBuilderErrors errors = kbuilder.getErrors();
	       if (errors.size() > 0) {
	           for (KnowledgeBuilderError error: errors) {
	               System.err.println(error);
	           }
	           throw new IllegalArgumentException("Could not parse knowledge.");
	       }
	       KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
	       kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
	       return kbase;
	   }
	 private static KnowledgeBase readKnowledgeBaseAutomovel() throws Exception {
	       KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
	       kbuilder.add(ResourceFactory.newClassPathResource("Regras_automovel.drl"), ResourceType.DRL);
	       KnowledgeBuilderErrors errors = kbuilder.getErrors();
	       if (errors.size() > 0) {
	           for (KnowledgeBuilderError error: errors) {
	               System.err.println(error);
	           }
	           throw new IllegalArgumentException("Could not parse knowledge.");
	       }
	       KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
	       kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
	       return kbase;
	   }
 	 private static KnowledgeBase readKnowledgeBasePessoal() throws Exception {
       KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
       kbuilder.add(ResourceFactory.newClassPathResource("Sample.drl"), ResourceType.DRL);
       KnowledgeBuilderErrors errors = kbuilder.getErrors();
       if (errors.size() > 0) {
           for (KnowledgeBuilderError error: errors) {
               System.err.println(error);
           }
           throw new IllegalArgumentException("Could not parse knowledge.");
       }
       KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
       kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
       return kbase;
   }
}
