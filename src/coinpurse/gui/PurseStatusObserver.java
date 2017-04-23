package coinpurse.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import coinpurse.Purse;

/**
 * Displays "FULL", "EMPTY", or number of objects in the Purse (when not full or empty).
 * Have a progress bar to display the % of objects in the purse.
 * @author Supisara Chuthathumpitak
 */
public class PurseStatusObserver extends JFrame implements Observer{
	private JProgressBar progressBar;
	private JTextField textField;
	
	/** Initialize PurseStatusObserver. */
	public PurseStatusObserver() {
		this.setTitle("Purse Status");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
	}

	/** create the component */
	private void initComponents() {
		textField = new JTextField(10);
		progressBar = new JProgressBar();
		final int FONT_SIZE = 24;
		textField.setFont(new Font(Font.DIALOG, Font.PLAIN, FONT_SIZE));
		this.add(textField, BorderLayout.NORTH);
		this.add(progressBar, BorderLayout.SOUTH);
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
			progressBar.setMaximum(purse.getCapacity());
			progressBar.setValue(purse.count());
			
			if(purse.isFull()) textField.setText("FULL");
			else if(purse.count() == 0) textField.setText("EMPTY");
			else textField.setText(purse.count() + "");
		}
	}
}
