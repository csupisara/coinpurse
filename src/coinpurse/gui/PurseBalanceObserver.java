package coinpurse.gui;

import java.awt.Font;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import coinpurse.Purse;

/**
 * Display the balance in the Purse.
 * @author Supisara Chuthathumpitak
 *
 */
public class PurseBalanceObserver extends JFrame implements Observer{
	private JTextArea textarea;
	
	/** Initialize PurseBalanceObserver. */
	public PurseBalanceObserver() {
		this.setTitle("Purse Balance");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
	}

	/** create the component */
	private void initComponents() {
		textarea = new JTextArea(5, 15);
		final int FONT_SIZE = 24;
		textarea.setFont(new Font(Font.DIALOG, Font.PLAIN, FONT_SIZE));
		this.add(textarea);
		this.pack();
	}
	
	/** Start the program */
	public void run(){
		this.setVisible(true);
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable subject, Object info) {
		if(subject instanceof Purse) {
			Purse purse = (Purse)subject;
			textarea.setText(purse.getBalance() + " Baht\n");
		}
	}
}
