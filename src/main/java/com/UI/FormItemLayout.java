package com.UI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.sample.model.Cliente;

public class FormItemLayout extends JPanel{

	public JLabel label;
	public JTextField text;
	public JRadioButton yes_btn, no_btn;
	public boolean selected;
	
	public FormItemLayout(String title, int type){
		
		//Type
//		0 -> textfield	
//		1 -> Y/N
//		2 -> Taxa de Juro
		
		setAlignmentX(CENTER_ALIGNMENT);

		label = new JLabel(title);
		label.setAlignmentX(CENTER_ALIGNMENT);
		add(label);
		
		switch(type){
		
			case 0:
				text = new JTextField();
				text.setPreferredSize(new Dimension(300, 25));
				
				add(text);
				break;
				
			case 1:
				yes_btn = new JRadioButton("Sim");
				no_btn = new JRadioButton("Não");
				
				ButtonGroup group = new ButtonGroup();
				group.add(yes_btn);
				group.add(no_btn);
				
				add(yes_btn);
				add(no_btn);
				break;
			
			case 2:
				yes_btn = new JRadioButton("Fixa");
				no_btn = new JRadioButton("Variavel Euribor a 6 Meses");
				
				ButtonGroup group2 = new ButtonGroup();
				group2.add(yes_btn);
				group2.add(no_btn);
				
				
				add(yes_btn);
				add(no_btn);
		}
		
	}
}
