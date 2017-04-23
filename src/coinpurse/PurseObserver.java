package coinpurse;

import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PurseObserver extends JFrame implements Observer{
	private JTextArea textarea;
	
	public PurseObserver() {
		initComponents();
	}
	
	private void initComponents() {
		textarea = new JTextArea(5, 40);
		final int FONT_SIZE = 24;
		textarea.setFont(new Font(Font.DIALOG, Font.PLAIN, FONT_SIZE));
		JScrollPane scrollPane = new JScrollPane(textarea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.add(scrollPane);
		this.add(textarea);
		this.pack();
	}
	
	public void run(){
		this.setVisible(true);
	}
	
	@Override
	public void update(Observable subject, Object info) {
		//what happen
		if(info != null) textarea.append(info + "\n");
		if(subject instanceof Purse) {
			Purse purse = (Purse) subject;
			textarea.append("Balance is " + purse.getBalance() + "\n");
		}
	}
}
