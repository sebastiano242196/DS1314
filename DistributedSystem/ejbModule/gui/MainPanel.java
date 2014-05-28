package gui;

import java.awt.CardLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class MainPanel extends JPanel {
	
	private JTabbedPane tabbedPane;
	private JTextField departureTextField;

	public MainPanel(){
		super();
		
		this.departureTextField = new JTextField();
		
		this.setLayout(new CardLayout());
		this.tabbedPane = new JTabbedPane();
		this.tabbedPane.addTab("Fill request", this.getRequestPanel());
		this.add(this.tabbedPane);
	}
	
	private JPanel getRequestPanel(){
		JPanel requestPanel = new JPanel();
		requestPanel.setLayout(new BoxLayout(requestPanel, BoxLayout.Y_AXIS));
		
		JPanel departurePanel = new JPanel();
			departurePanel.add(departureTextField);
			departurePanel.add(new JLabel("Departure airport code"));
		requestPanel.add(departurePanel);
		
		
		return requestPanel;
	}
}
