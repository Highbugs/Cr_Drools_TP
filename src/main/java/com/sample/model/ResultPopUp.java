package com.sample.model;

import javax.swing.JOptionPane;
public class ResultPopUp {
	    public static void infoBox(String infoMessage, String titleBar)
	    {
	        JOptionPane.showMessageDialog(null, infoMessage, "Cr�dito: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	    }
}
