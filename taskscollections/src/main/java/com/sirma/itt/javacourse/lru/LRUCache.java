package com.sirma.itt.javacourse.lru;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A class that contains a LinkedHashMap and overrides its removeLastEntry
 * method. It has a method for putting new data in the map and for counting its
 * elements.
 * 
 * @author Nikolay Ch
 * 
 * @param <K>
 *            the type of the key in the map
 * @param <V>
 *            the type of the value in the map
 */
public class LRUCache<K, V> {

	private LinkedHashMap<K, V> hashMap;

	/**
	 * The constructor that initializes the capacity of the map.
	 * 
	 * @param capacity
	 *            the capacity of the map
	 */
	@SuppressWarnings("serial")
	public LRUCache(final int capacity) {

		hashMap = new LinkedHashMap<K, V>(capacity, (float) 0.75, true) {
			@Override
			protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
				return size() > capacity;
			}
		};
	}

	/**
	 * Adds an element in the LinkedHashMap.
	 * 
	 * @param key
	 *            the key for the map
	 * @param value
	 *            the value for the map
	 */
	public void addElement(K key, V value) {
		hashMap.put(key, value);
	}

	/**
	 * Counts the elements in the LinkedHashMap.
	 * 
	 * @return the number
	 */
	public int countElements() {
		Iterator<K> keys = hashMap.keySet().iterator();
		int count = 0;
		@SuppressWarnings("unused")
		K code;
		while (keys.hasNext()) {
			count++;
			code = keys.next();
		}

		return count;
	}

}
