package coinpurse;

/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * 
 * @author Supisara Chuthathumpitak
 */
public class Main {
	/* Capacity of the purse.*/
	private static int CAPACITY = 10;
	
	/**
	 * Configure and start the application.
	 * @param args not used
	 */
	public static void main(String[] arg) {
		Purse purse = new Purse(CAPACITY);
		ConsoleDialog console = new ConsoleDialog(purse);
		console.run();
	}
}
