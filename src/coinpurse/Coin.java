package coinpurse;
/**
 * A coin with a monetary value and currency.
 * 
 * @author Supisara Chuthathumpitak
 */
public class Coin extends AbstractValuable{
	public static final String DEFAULT_CURRENCY = "Baht";
	private double finalValue;
	private String finalCurrency;

	/**
	 * Initialize a coin with given value using the default currency.
	 * @param value is the monetary value of that coin.
	 */
	public Coin( double value ) {
		this(value, DEFAULT_CURRENCY);
	}

	/**
	 * Initialize a coin with given value and currency.
	 * @param value is the monetary value of that coin.
	 * @param currency is the currency of that coin.
	 */
	public Coin( double value, String currency ) {
		super(value, currency);
		this.finalValue = value;
		this.finalCurrency = currency;
	}
	
	/**
	 * Print value and currency.
	 * @param finalValue is the value that want to print out.
	 * @param finalCurrency is the currency that want to print out.
	 */
	public void print(double finalValue, String finalCurrency) {
		this.finalValue = finalValue;
		this.finalCurrency = finalCurrency;
	}

	/**
	 * toString returns a string description of the coin.
	 * @return the value with currency.
	 */
	public String toString() { 
		if(this.finalCurrency.equals("Sen")) return String.format("%.0f %s coin", this.finalValue, this.finalCurrency);
		return String.format("%.0f-%s coin", this.finalValue, this.finalCurrency);
	}
}
