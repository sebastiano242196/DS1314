package gui;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame{
	
	private MainPanel mainPanel;
	
	public Window(){
		super();
		this.mainPanel = new MainPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(500,300));
		this.getContentPane().add(mainPanel);
		this.setLayout(new CardLayout());
		this.pack();
		this.setVisible(true);		
	}
}
