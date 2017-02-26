package coinpurse;

/**
 * The valuable of every monetary objects.
 * 
 * @author Supisara Chuthathumpitak
 */
public interface Valuable extends Comparable<Valuable>{
	public double getValue();
	public String getCurrency();
}
