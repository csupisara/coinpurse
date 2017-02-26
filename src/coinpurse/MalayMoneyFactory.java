package coinpurse;

/**
 * Creating the Malay money with value and currency.
 * @author Supisara Chuthathumpitak
 *
 */
public class MalayMoneyFactory extends MoneyFactory {
	double validValue [] = { 0.05, 0.10, 0.20, 0.50, 1, 2, 5, 10, 20, 50, 100 };
	private static long nextSerialNumber = 1000000;
	public final String DEFAULT_CURRENCY = "Ringgit";
	public final String coinCurrency = "Sen";

	/**
	 * Create a new money object in the local currency.
	 * @param value is the value that input to creating the coin or bank note.
	 * @return the monetary object that are created.
	 * @throws IllegalArgumentException if the value is not valid currency amount.
	 */
	@Override
	protected Valuable createMoney( double value ) {
			if(isValid(value, validValue)){
				if(value <= 0.50) {
					Coin coin = new Coin(value, coinCurrency);
					coin.print(value*100, coinCurrency);
					return coin;
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
	public static void main (String[] args){
		MoneyFactory factory = MoneyFactory.getInstance();
		Valuable mm = factory.createMoney(5); 
		System.out.println(mm.toString()); 
		Valuable mm2 = factory.createMoney(0.05);
		System.out.println(mm2.toString());
		Valuable mm3 = factory.createMoney(20);
		System.out.println(mm3.toString());
	}
}