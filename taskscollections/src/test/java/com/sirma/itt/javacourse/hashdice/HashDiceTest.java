package com.sirma.itt.javacourse.hashdice;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the methods in the HashDice class.
 * 
 * @author Nikolay Ch
 * 
 */
public class HashDiceTest {
	private HashDice hashDice;
	private String inside = "1,3";
	private int[] keepTheInserted = new int[2];

	/**
	 * Inserts new data in the table. Saves the same data in another array.
	 */
	@Before
	public void initialize() {
		hashDice = new HashDice();

		hashDice.insert(inside, 3);
		keepTheInserted[0] = 3;
		inside = "1,3";
		hashDice.insert(inside, 5);
		keepTheInserted[1] = 5;
	}

	/**
	 * Tests the insert method in the HashDice class. Inserts some data in the
	 * table by the method and compares this data with another array where it is
	 * saved.
	 */
	@Test
	public void testInsert() {

		ArrayList<Integer> arList = new ArrayList<Integer>();
		arList = hashDice.getList(inside);

		for (int i = 0; i < arList.size(); i++) {
			int num = arList.get(i);
			assertEquals(num, keepTheInserted[i]);
		}

	}

}
