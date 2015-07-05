package com.sample.model;

import javax.swing.JOptionPane;
public class ResultPopUp {
	    public static void infoBox(String infoMessage, String titleBar)
	    {
	        JOptionPane.showMessageDialog(null, infoMessage, "Crédito: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	    }
}
