package coinpurse;
/**
 * A coin with a monetary value and currency.
 * 
 * @author Supisara Chuthathumpitak
 */
public class Coin implements Comparable<Coin>, Valuable{
	public static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the coin. */
	private final double value;
	/** The currency, of course. */
	private final String currency;

	/**
	 * Initialize a coin with given value using the default currency.
	 * @param value is the monetary value of that coin.
	 */
	public Coin( double value ) {
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
	}

	/**
	 * Initialize a coin with given value and currency.
	 * @param value is the monetary value of that coin.
	 * @param currency is the currency of that coin.
	 */
	public Coin( double value, String currency ) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Get the value of that coin.
	 * @return value of the coin we pick.
	 */
	public double getValue() { 
		return this.value;
	} 

	/**
	 * Get the current of that coin.
	 * @return a current of the coin we pick.
	 */
	public String getCurrency() { 
		return this.currency;
	}

	/**
	 * Compare the coin that it have same value and same currency or not.
	 * @param obj is the coin that want to test.
	 * @return that it equals or not.
	 */
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj.getClass() != this.getClass()) return false;
		Coin other = (Coin) obj;
		if((this.value == other.value) && (this.currency.equals(other.currency))) return true;
		return false;
	}

	/**
	 * Order coin by value, smaller value comes first.
	 * @param other is the coin that want to order.
	 * @return the coin that order from smallest to largest.
	 */
	@Override
	public int compareTo(Coin other){
		if(other == null) return -1;
		return (int) Math.signum(this.value - other.value);
	}

	/**
	 * toString returns a string description of the coin.
	 * @return the value with currency.
	 */
	public String toString() { 
		return value + "-" + this.currency; 
	}
}
