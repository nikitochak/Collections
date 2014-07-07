package com.sirma.itt.javacourse.excmessman;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the methods in the ExceptionMessageManager class.
 * 
 * @author Nikolay Ch
 * 
 */
public class ExceptionMessageManagerTest {
	ExceptionsMessageManager manager; // manager
	Map<String, String> testMap;
	String howItShouldBe = "";

	/**
	 * Initializes the class map.
	 */
	@Before
	public void initialize() {
		testMap = new HashMap<String, String>();
		testMap.put("water", "There is no water.");
		testMap.put("food", "The food is ending.");
		testMap.put("fuel", "We are going out of fuel.");

		manager = new ExceptionsMessageManager(testMap);
	}

	/**
	 * Adds a correct value to the string. At the beginning the message string
	 * must be empty, so it compares the message string with the inputed value.
	 */
	@Test
	public void testAddException() {
		manager.addExceptionMessage("There is no water.");
		howItShouldBe = "There is no water.";
		assertEquals(manager.getMessage(), howItShouldBe);
	}

	/**
	 * Tests the method for inserting a value by its key.
	 * 
	 * @throws Exception
	 *             when the key is non-existing
	 */
	@Test
	public void testAddExceptionMessageUsingCode() throws Exception {
		manager.addExceptionMessageUsingCode("food");
		howItShouldBe += testMap.get("food");
		assertEquals(howItShouldBe, manager.getMessage());
	}

	/**
	 * Tests the method for inserting a value with non existing key. Must throw
	 * Exception.
	 * 
	 * @throws Exception
	 *             when the key is non-existing
	 */
	@Test(expected = Exception.class)
	public void testAddExceptionMessageUsingCodeWithWrongCode()
			throws Exception {
		manager.addExceptionMessageUsingCode("asdf");
	}
}
