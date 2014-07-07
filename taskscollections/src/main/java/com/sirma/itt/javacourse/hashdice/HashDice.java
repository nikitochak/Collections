package com.sirma.itt.javacourse.hashdice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Class which has a map and a method for inserting some data in this map.
 * 
 * @author Nikolay Ch
 * 
 */
public class HashDice {
	private Map<String, ArrayList<Integer>> hashDice = new HashMap<String, ArrayList<Integer>>();

	/**
	 * The method for inserting in a hash map. Gets a string and an integer.
	 * Looks if the string is a key and if it is puts the integer in the end of
	 * the list. If it not makes the string a new key and inputs the integer in
	 * the end of new array list.
	 * 
	 * @param combination
	 *            the combination in type "number1,number2"
	 * @param throwTime
	 *            the number of the time that the combination is thrown
	 */
	public void insert(String combination, int throwTime) {
		if (hashDice.get(combination) == null) {
			ArrayList<Integer> whenThrown = new ArrayList<Integer>();
			whenThrown.add(throwTime);
			hashDice.put(combination, whenThrown);
		} else {
			ArrayList<Integer> update = hashDice.get(combination);
			update.add(throwTime);
			hashDice.replace(combination, update);
		}
	}

	/**
	 * Getter for the list by its key.
	 * 
	 * @param key
	 *            the key for the list
	 * @return the list
	 */
	public ArrayList<Integer> getList(String key) {
		return hashDice.get(key);
	}
}
