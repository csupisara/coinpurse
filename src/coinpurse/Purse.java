package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full. When you withdraw money, the coin
 * purse decides which coins to remove.
 * 
 * @author Supisara Chuthathumpitak
 */
public class Purse {
	/** Collection of objects in the purse. */

	/**
	 * Capacity is maximum number of coins the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private final int capacity;
	List<Coin> money;

	/**
	 * Initialize a purse with a specified capacity.
	 * 
	 * @param capacity is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		this.money = new ArrayList<>();
	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins, not their value.
	 * 
	 * @return the number of coins in the purse
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
		for (Coin x : this.money) {
			sum += x.getValue();
		}
		return sum;
	}

	/**
	 * Return the capacity of the coin purse.
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
	 * Insert a coin into the purse. The coin is only inserted if the purse has
	 * space for it and the coin has positive value. No worthless coins!
	 * 
	 * @param coin is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Coin coin) {
		// if the purse is already full then can't insert anything.
		if (coin == null)
			return false;
		if (coin.getValue() <= 0)
			return false;
		if (isFull())
			return false;

		this.money.add(coin);
		return true;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount is the amount to withdraw
	 * @return array of Coin objects for money withdrawn, or null if cannot withdraw requested amount.
	 */
	public Coin[] withdraw(double amount) {
		Collections.sort(money);
		Collections.reverse(money);

		List<Coin> templist = new ArrayList<>();
		Coin[] array;
		if(amount < 0) return null;
		if (getBalance() - amount < 0)
			return null;

		for (Coin x : money) {
			if ((amount - x.getValue()) >= 0) {
				templist.add(x);
				amount -= x.getValue();
			}
		}
		
		array = new Coin[templist.size()];
		if (amount != 0)
			return null;
		if (amount == 0) {
			for (Coin y : templist) {
				money.remove(y);
			}
			templist.toArray(array);
		}
		return array;
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * @return the number of coin and the total value.
	 */
	public String toString() {
		return count() + " coins with value " + getBalance();
	}
}
