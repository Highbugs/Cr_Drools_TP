package com.UI;

import javax.swing.JFrame;

public class UIMainWindow extends JFrame{

	private StartPanel mainPanel;
	public UIMainWindow(){
		
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel = new StartPanel(this);
		
		add(mainPanel);
		setVisible(true);
	}
}
