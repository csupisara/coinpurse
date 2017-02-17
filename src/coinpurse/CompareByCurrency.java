package coinpurse;

import java.util.Comparator;
/**
 * Class for compare each valuable.
 * @author Supisara Chuthathumpitak
 */
public class CompareByCurrency implements Comparator<Valuable>{

	/**
	 * Order monetary objects by currency.
	 * @param o1 is the monetary objects that want to compare
	 * @param o2 is the monetary objects that want to compare with
	 */
	@Override
	public int compare(Valuable o1, Valuable o2) {
		return o1.getCurrency().compareToIgnoreCase(o2.getCurrency());
	}

}
