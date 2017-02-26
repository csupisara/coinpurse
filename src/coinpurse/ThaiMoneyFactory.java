package coinpurse;

/**
 * Creating the Thai money with value and currency.
 * 
 * @author Supisara Chuthathumpitak
 *
 */
public class ThaiMoneyFactory extends MoneyFactory{
	double validValue [] = { 0.25, 0.50, 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
	private static long nextSerialNumber = 1000000;
	public final String DEFAULT_CURRENCY = "Baht";
	public final String coinCurrency = "Satang";

	/**
	 * Create a new money object in the local currency.
	 * @param value is the value that input to creating the coin or bank note.
	 * @return the monetary object that are created.
	 * @throws IllegalArgumentException if the value is not valid currency amount.
	 */
	@Override
	protected Valuable createMoney( double value ) {
		if( isValid (value, validValue) ) {
			if( value <= 10 ) {
				if( value <= 0.50 ) {
					Coin coin = new Coin(value, coinCurrency);
					coin.print(value*100, coinCurrency);
					return coin;
				}
				else{
					Coin coin = new Coin(value, DEFAULT_CURRENCY);
					coin.print(value, DEFAULT_CURRENCY);
					return coin;
				}
			}
			else {
				nextSerialNumber++;
				BankNote bankNote = new BankNote(value, DEFAULT_CURRENCY, nextSerialNumber); 
				return bankNote;
			}
		}
		throw new IllegalArgumentException();
	}

	/**
	 * Main class for input the value that want to create.
	 * @param args
	 */
	public static void main (String[] args) {
		MoneyFactory factory = MoneyFactory.getInstance();
		Valuable m = factory.createMoney(5); 
		System.out.println(m.toString()); 
		Valuable m2 = factory.createMoney(1000);
		System.out.println(m2.toString());
		Valuable m3 = factory.createMoney(0.25);
		System.out.println(m3.toString());
	}
}
