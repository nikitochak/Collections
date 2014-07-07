package com.sirma.itt.javacourse.lru;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the last recently used element deletion.
 * 
 * @author Nikolay Ch
 * 
 */
public class LRUCacheTest {
	private LRUCache<String, String> lrucache;
	private String key = "";
	private String value = "";

	/**
	 * Initializes the maps capacity.
	 */
	@Before
	public void initialize() {
		lrucache = new LRUCache<String, String>(2);

	}

	/**
	 * Puts more elements than the map's capacity. The linked hash map must
	 * delete the last recently used elements. The size of the map must be
	 * equals to the capacity.
	 */
	@Test
	public void testRemovedLastEntry() {
		for (int i = 0; i < 4; i++) {

			key += i;
			value += i;

			lrucache.addElement(key, value);
		}

		assertEquals(2, lrucache.countElements());

	}
}
