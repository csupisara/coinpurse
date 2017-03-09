package coinpurse;

/**
 * The valuable of every monetary objects.
 * 
 * @author Supisara Chuthathumpitak
 */
public interface Valuable extends Comparable<Valuable>{
	
	/**
	 * Get the value of that valuable.
	 * @return value of the valuable we pick.
	 */
	public double getValue();
	
	/**
	 * Get the current of that valuable.
	 * @return a current of the valuable we pick.
	 */
	public String getCurrency();
}
