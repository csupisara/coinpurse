package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A purse contains coins, banknotes and other kinds of monetary objects. 
 * You can insert, withdraw money, check the balance, and check if the purse is full. 
 * When you withdraw money, the purse decides which monetary objects to remove.
 * 
 * @author Supisara Chuthathumpitak
 */
public class Purse {
	/** Collection of objects in the purse. */

	/**
	 * Capacity is maximum number of monetary objects the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private final int capacity;
	List<Valuable> money;

	/**
	 * Initialize a purse with a specified capacity.
	 * 
	 * @param capacity is maximum number of monetary objects you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		this.money = new ArrayList<>();
	}

	/**
	 * Count and return the number of monetary objects in the purse. This is the number of
	 * monetary objects, not their value.
	 * 
	 * @return the number of monetary objects in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double sum = 0;
		for (Valuable x : this.money) {
			sum += x.getValue();
		}
		return sum;
	}

	/**
	 * Return the capacity of the purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		return money.size() == capacity;
	}

	/**
	 * Insert a monetary objects into the purse. The monetary objects is only inserted if the purse has
	 * space for it and has positive value. No worthless monetary objects!
	 * 
	 * @param valuable is a monetary object to insert into purse
	 * @return true if monetary object inserted, false if can't insert
	 */
	public boolean insert(Valuable valuable) {
		// if the purse is already full then can't insert anything.
		if (valuable == null)
			return false;
		if (valuable.getValue() <= 0)
			return false;
		if (isFull())
			return false;
		this.money.add(valuable);
		return true;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Valuable
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount is the amount to withdraw
	 * @return array of monetary objects for money withdrawn, or null if cannot withdraw requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		Collections.sort(money, new CompareByCurrency());
		Collections.reverse(money);

		List<Valuable> templist = new ArrayList<>();
		Valuable[] array;
		if(amount < 0) return null;
		if (getBalance() - amount < 0)
			return null;

		for (Valuable x : money) {
			if ((amount - x.getValue()) >= 0) {
				templist.add(x);
				amount -= x.getValue();
			}
		}
		
		if (amount != 0)
			return null;
		
		array = new Valuable[templist.size()];
		if (amount == 0) {
			for (Valuable y : templist) {
				money.remove(y);
			}
			templist.toArray(array);
		}
		return array;
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * @return the number of monetary objects and the total value.
	 */
	public String toString() {
		return count() + " with value " + getBalance();
	}
}
