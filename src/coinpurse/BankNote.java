package coinpurse;
/**
 * A banknote with a monetary value and currency.
 * 
 * @author Supisara Chuthathumpitak
 */
public class BankNote extends AbstractValuable{
	public static final String DEFAULT_CURRENCY = "Baht";
	private final long serialNumber;
	
	/**
	 * Initialize a banknote with given value using the default currency.
	 * @param value is the monetary value of that banknote.
	 * @param serialNum is serial number of that banknote.
	 */
	public BankNote(double value,long serialNum){
		this(value, DEFAULT_CURRENCY, serialNum);
	}
	
	/**
	 * Initialize a banknote with value, currency and serial number.
	 * @param value is the monetary value of that banknote.
	 * @param currency is the currency of that banknote.
	 * @param serialNum is serial number of that banknote.
	 */
	public BankNote(double value, String currency, long serialNum){
		this.value = value;
		this.currency = currency;
		this.serialNumber = serialNum;
	}
	
	/**
	 * Get the serial number of that banknote.
	 * @return a serial number of the banknote we pick.
	 */
	public long getSerial(){
		return this.serialNumber;
	}
	
	/**
	 * toString returns a string description of the banknote.
	 * @return the value with currency and serial number.
	 */
	public String toString() { 
		return String.format("%.0f %s note [%d]", this.value, this.currency, this.serialNumber);
	}
}
