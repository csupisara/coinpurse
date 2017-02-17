package coinpurse;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.print.DocFlavor.STRING;

/**
 * Some monetary objects utility methods for practice using Lists and Comparator.
 * 
 * @author Supisara Chuthathumpitak
 */
public class CoinUtil {

	/**
	 * Method that examines all the monetary objects in a List and returns
	 * only the monetary objects that have a currency that matches the parameter value.
	 * @param valuelist is a List of monetary objects. This list is not modified.
	 * @param currency is the currency we want. Must not be null.
	 * @return a new List containing only the elements from valuelist
	 *     that have the requested currency.  
	 */
	public static List<Valuable> filterByCurrency(final List<Valuable> valuelist, String currency) {
		List<Valuable> valueCurrent = new ArrayList<>();
		for(Valuable x : valuelist){
			if(x.getCurrency().equals(currency)){
				valueCurrent.add(x);
			}
		}
		return valueCurrent; // return a list of monetary objects references copied from valuelist
	}

	/**
	 * Method to sort a list of monetary objects by currency.
	 * On return, the list (monetary objects) will be ordered by currency.
	 * @param monetary objects is a List of Coin objects we want to sort. 
	 */
	public static void sortByCurrency(List<? extends Valuable> coins) {
		Collections.sort(coins, new CompareByCurrency());
	}

	/**
	 * Sum monetary objects by currency and print the sum for each currency.
	 * Print one line for the sum of each currency.
	 * For example: 
	 * coins = { Coin(1,"Baht"), Coin(20,"Ringgit"), Coin(10,"Baht"), Coin(0.5,"Ringgit") }
	 * then sumByCurrency(coins) would print:
	 * 
	 * 11.00 Baht
	 * 20.50 Ringgit
	 * 
	 * Hint: this is easy if you sort the monetary objects by currency first. :-)
	 * @param values is the collection of coins.
	 */
	public static void sumByCurrency(List<? extends Valuable> values) {
		Map<String, Double> map = new HashMap<String, Double>();

		String cur;
		for(Valuable x : values){
			cur = x.getCurrency();

			if(map.containsKey(cur)){
				map.put(x.getCurrency(), map.get(cur) + x.getValue());
			}
			else{
				map.put(x.getCurrency(), x.getValue());
			}
		}
		for(String x : map.keySet()){
			System.out.println(map.get(x) + " " + x);
		}
	}

	/**
	 * This method contains some code to test the above methods.
	 * @param args not used
	 */
	public static void main(String[] args) {
		String currency = "Rupee";
		System.out.println("Filter values by currency of "+currency);
		List<Valuable> value = makeInternationalCoins();
		int size = value.size();
		System.out.print(" INPUT: "); printList(value," ");
		List<Valuable> rupees = filterByCurrency(value, currency);
		System.out.print("RESULT: "); printList(rupees," ");
		if (value.size() != size) System.out.println("Error: you changed the original list.");
		System.out.println("\nSort values by currency");
		value = makeInternationalCoins();
		System.out.print(" INPUT: "); printList(value," ");
		sortByCurrency(value);
		System.out.print("RESULT: "); printList(value," ");

		System.out.println("\nSum values by currency");
		value = makeInternationalCoins();
		System.out.print("monetary objects= "); printList(value," ");
		sumByCurrency(value);

	}

	/** Make a list of monetary objects containing different currencies. */
	public static List<Valuable> makeInternationalCoins( ) {
		List<Valuable> money = new ArrayList<Valuable>();
		money.addAll( makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0) );
		money.addAll( makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0) );
		money.addAll( makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0) );
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}

	/** Make a list of coins using given values.*/ 
	public static List<Valuable> makeCoins(String currency, double ... values) {
		List<Valuable> list = new ArrayList<Valuable>();
		for(double value : values) list.add(new Coin(value,currency));
		return list;
	}

	/** Print the list on the console, on one line. */
	public static void printList(List items, String separator) {
		Iterator iter = items.iterator();
		while( iter.hasNext() ) { 
			System.out.print(iter.next());
			if (iter.hasNext()) System.out.print(separator);
		}
		System.out.println(); // end the line
	}
}

