package coinpurse;
/**
 * A banknote with a monetary value and currency.
 * 
 * @author Supisara Chuthathumpitak
 */
public class BankNote implements Valuable{
	public static final String DEFAULT_CURRENCY = "Baht";
	private static long nextSerialNumber = 1000000;
	private final double value;
	private final String currency;
	private final long serialNumber;
	
	/**
	 * Initialize a banknote with given value using the default currency.
	 * @param value is the monetary value of that banknote.
	 */
	public BankNote(double value){
		this(value, DEFAULT_CURRENCY);
	}
	
	/**
	 * Initialize a banknote with value, currency and serial number.
	 * @param value is the monetary value of that banknote.
	 * @param currency is the currency of that banknote.
	 */
	public BankNote(double value, String currency){
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber;
		nextSerialNumber++;
	}
	
	/**
	 * Get the value of that banknote.
	 * @return value of the banknote we pick.
	 */
	public double getValue(){
		return this.value;
	}
	
	/**
	 * Get the current of that banknote.
	 * @return a current of the banknote we pick.
	 */
	public String getCurrency(){
		return this.currency;
	}
	
	/**
	 * Get the serial number of that banknote.
	 * @return a serial number of the banknote we pick.
	 */
	public long getSerial(){
		return this.serialNumber;
	}
	
	/**
	 * Compare the banknote that it have same value and same currency or not.
	 * @param obj is the banknote that want to test.
	 * @return that it equals or not.
	 */
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj.getClass() != this.getClass()) return false;
		BankNote other = (BankNote) obj;
		if((this.value == other.value) && (this.currency.equals(other.currency))) return true;
		return false;
	}
	/**
	 * toString returns a string description of the banknote.
	 * @return the value with currency and serial number.
	 */
	public String toString() { 
		return value + "-" + this.currency +" note [" + this.serialNumber + "]"; 
	}
	

}
