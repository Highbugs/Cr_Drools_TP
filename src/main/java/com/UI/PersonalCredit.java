package com.UI;

import java.awt.BorderLayout;
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
import javax.swing.JTextField;

import com.sample.model.Cliente;
import com.sample.model.Fiador;

public class PersonalCredit extends JFrame {
	
	private JPanel mainPanel;
	private JButton next_btn;
	private ArrayList<FormItemLayout> form_list;
	private Cliente client;
	
	private int credit_type;
	
	public PersonalCredit(String title, Cliente c, int type){  //para fiador, recebe já o cliente, se não recebe null
		
		setSize(500, 520);
		
		credit_type = type;
		client = c;
		
		setPanel(title);
		setListeners();
		
		setVisible(true);
	}
	
	private void setPanel(String t){
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		form_list = new ArrayList<>();
		setList();
		
		JLabel title = new JLabel(t);
		title.setFont(new Font("Serif", Font.PLAIN, 30));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		mainPanel.add(title);
		
		mainPanel.add(Box.createRigidArea(new Dimension(15, 10)));
		
		for(int i = 0; i < form_list.size(); i++)
			mainPanel.add(form_list.get(i));

		next_btn = new JButton("Próximo");
		next_btn.setAlignmentX(CENTER_ALIGNMENT);
		
		mainPanel.add(next_btn);
		
		add(mainPanel);
	}
	
	private void setListeners(){
		
		next_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				if(isFormCompleted()){
					
					String name = form_list.get(0).text.getText();
					int age = Integer.parseInt(String.valueOf(form_list.get(1).text.getText()));
					float wage = Float.parseFloat(String.valueOf(form_list.get(2).text.getText()));
					float expenses = Float.parseFloat(String.valueOf(form_list.get(3).text.getText()));
					boolean history = form_list.get(4).selected;
					boolean account = form_list.get(5).selected;
					boolean job = form_list.get(6).selected;
					
					boolean guarantor = false;
					if(client == null)
						if(credit_type != 2)
							guarantor = form_list.get(7).selected;
						else
							guarantor = form_list.get(8).selected;

					if(client == null){
						client = new Cliente(name, age, history, wage, expenses, 0, null);
						client.setEmprego(job);
						client.setContaBancaria(account);
						
						if(credit_type == 2)
							client.setSeguroVida(form_list.get(7).selected);
						
						if(guarantor)
							new PersonalCredit("Informações do Fiador", client, credit_type);
						else
							new CreditDetails(client, credit_type);
					}else{
						Fiador fiador = new Fiador();
						fiador.setNome(name);
						fiador.setIdade(age);
						fiador.setHistoricoIncumprimento(history);
						fiador.setOrdenado(wage);
						fiador.setTotalDespesasCreditos(expenses);
						client.setFiador(fiador);
						
						new CreditDetails(client, credit_type); 
					}
					
					PersonalCredit.this.hide();
				}
				
			}
		});
	}
	
	private void setList(){
		
		form_list.add(new FormItemLayout("Nome", 0));
		form_list.add(new FormItemLayout("Idade", 0));
		form_list.add(new FormItemLayout("Ordenado", 0));
		form_list.add(new FormItemLayout("Total de Despesas em Créditos", 0));		
		form_list.add(new FormItemLayout("Tem Histórico de Incumprimentos?", 1));
		form_list.add(new FormItemLayout("Tem Conta Bancária?", 1));
		form_list.add(new FormItemLayout("Tem Emprego Há Mais de 3 Meses?", 1));
		
		if(credit_type == 2 && client == null)
			form_list.add(new FormItemLayout("Tem Seguro de Vida?", 1));
		
		if(client == null)
			form_list.add(new FormItemLayout("Tem um Fiador?", 1));
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
				if(i == 1 || i == 2 || i == 3){
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
}
