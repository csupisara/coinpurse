package coinpurse;

import java.util.ResourceBundle;

/**
 * Creating the money which specific to each country.
 * @author Supisara Chuthathumpitak
 */
public abstract class MoneyFactory {
	private static MoneyFactory moneyFactory;
	
	/**
	 * Get an instance of MoneyFactory.
	 * @return an object of a subclass.
	 */
	public static MoneyFactory getInstance() {
		setMoneyFactory();
		return moneyFactory;
	}

	/**
	 * Create a new money object in the local currency.
	 * @param value is the value that input to creating the coin or bank note.
	 */
	protected abstract Valuable createMoney( double value );

	/**
	 * Create a new money object in the local currency.
	 * @param value is the value that input to creating the coin or bank note.
	 * @return the value that input but in int not String.
	 * @throws if
	 */
	protected Valuable createMoney ( String value ) {
		try{
			double newValue = Double.parseDouble(value);
			return createMoney(newValue);
		}catch (NumberFormatException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	/**
	 * Choose the country to reading the file purse.properties.
	 */
	public static void setMoneyFactory() {
		ResourceBundle bundle = ResourceBundle.getBundle("purse");
		String factoryclass = bundle.getString("moneyfactory");
		
		if (factoryclass == null) {
			factoryclass = "coinpurse.ThaiMoneyFactory";
		}
		
		try {
			moneyFactory = (MoneyFactory) Class.forName(factoryclass).newInstance();
		} catch (ClassCastException cce) {
			System.out.println(factoryclass + " is not type MoneyFactory");
		} catch (Exception ex) {
			System.out.println("Error creating MoneyFactory " + ex.getMessage());

		}
		if (moneyFactory == null) System.exit(1);
	}
	
	/**
	 * To tell that the value that want to create is having in the country or not.
	 * @param value is the value that input to creating the coin or bank note.
	 * @param validValue is the value that can creating.
	 * @return whether it is valid or not.
	 */
	public boolean isValid( double value, double[] validValue ) {
		for(double x : validValue){
			if(x == value){
				return true;
			}
		}
		return false;
	}
}
