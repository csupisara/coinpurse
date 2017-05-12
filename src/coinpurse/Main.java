package coinpurse;

import java.util.ResourceBundle;

import coinpurse.gui.PurseBalanceObserver;
import coinpurse.gui.PurseListModel;
import coinpurse.gui.PurseStatusObserver;

/**
 * A main class to create objects and connect objects together. The user
 * interface needs a reference to coin purse.
 * 
 * @author Supisara Chuthathumpitak
 */
public class Main {
	/* Capacity of the purse. */
	private static int CAPACITY = 10;

	/**
	 * Configure and start the application.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] arg) {
		Purse purse = new Purse(CAPACITY);
		ConsoleDialog console = new ConsoleDialog(purse);
		PurseObserver observer = new PurseObserver();
		PurseBalanceObserver purseBalanceObserver = new PurseBalanceObserver();
		PurseStatusObserver purseStatusObserver = new PurseStatusObserver();
		PurseListModel purseListModel = new PurseListModel(purse);
		
		purse.addObserver(purseBalanceObserver);
		purse.addObserver(purseStatusObserver);
		purse.addObserver(observer);
		purse.addObserver(purseListModel);
		
		purseBalanceObserver.run();
//		observer.run();
//		purseListModel.run();
//		purseStatusObserver.run();
		console.run();
	}
}
