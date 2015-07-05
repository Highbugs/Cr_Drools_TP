package com.UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

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
import com.sample.model.Credito;
import com.sample.model.CreditoEstudante;
import com.sample.model.Fiador;
import com.sample.model.Reprovado;

public class StartPanel extends JPanel{

	JButton student_btn, personal_btn, car_btn, home_btn;
	JLabel title;
	JFrame frame;
	
	public StartPanel(JFrame f) {
		
		frame = f;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		setComponents();
		setListeners();
	}
	
	private void setComponents(){
		
		title = new JLabel("Simulador de Empréstimo Bancário");
		title.setFont(new Font("Serif", Font.PLAIN, 30));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		student_btn = new JButton("Estudante");
		student_btn.setAlignmentX(CENTER_ALIGNMENT);
		
		personal_btn = new JButton("Pessoal");
		personal_btn.setAlignmentX(CENTER_ALIGNMENT);
		
		car_btn = new JButton("Automóvel");
		car_btn.setAlignmentX(CENTER_ALIGNMENT);
		
		home_btn = new JButton("Habitação");
		home_btn.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel sel_type = new JLabel("Seleccione o tipo pretendido");
		sel_type.setAlignmentX(CENTER_ALIGNMENT);
		
		add(Box.createRigidArea(new Dimension(15, 50)));
		add(title);
		add(Box.createRigidArea(new Dimension(15, 100)));
		add(sel_type);
		add(Box.createRigidArea(new Dimension(15, 10)));
		add(personal_btn);
		add(Box.createRigidArea(new Dimension(15, 10)));
		add(student_btn);
		add(Box.createRigidArea(new Dimension(15, 10)));
		add(car_btn);
		add(Box.createRigidArea(new Dimension(15, 10)));
		add(home_btn);
	}

	private void setListeners(){
		
		personal_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				new PersonalCredit("Crédito Pessoal", null, 0);
			}
		});
		
		car_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				new PersonalCredit("Crédito Automóvel", null, 1);
			}
		});
		
		home_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			
				new PersonalCredit("Crédito Automóvel", null, 2);
			}
		});
	}
}
