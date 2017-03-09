package coinpurse;

/**
 * This class will eliminate duplicate code from Coin class and Banknote class.
 * @author Supisara Chuthathumpitak
 * 
 */
public abstract class AbstractValuable implements Valuable{
	protected double value;
	protected String currency;

	/**
	 * Initialize a monetary object.
	 */
	public AbstractValuable() {
		super();
	}

	/**
	 * Initialize a monetary object with given value using the currency.
	 * @param value is the value of that monetary object.
	 * @param currency is the currency of that monetary object.
	 */
	public AbstractValuable( double value, String currency ) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Compare the monetary object that it have same value and same currency or not.
	 * @param obj is the coin that want to test.
	 * @return that it equals or not.
	 */
	public boolean equals(Object obj) {
		if( obj == null ) return false;
		if( obj.getClass() != this.getClass() ) return false;
		Coin other = (Coin) obj;
		if( (this.value == other.value) && (this.currency.equals(other.currency)) ) return true;
		return false;
	}

	/**
	 * Order by value, smaller value comes first.
	 * @param other is the monetary that want to order.
	 * @return the order of the valuable.
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo( Valuable other ) {
		if( this.currency.equalsIgnoreCase(other.getCurrency()) || (this.currency == null && other.getCurrency() == null) ){
			return (int) Math.signum(value - other.getValue());
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * @see coinpurse.Valuable#getValue()
	 */
	public double getValue() {
		return this.value;
	}

	/*
	 * (non-Javadoc)
	 * @see coinpurse.Valuable#getCurrency()
	 */
	public String getCurrency() {
		return this.currency;
	}
}