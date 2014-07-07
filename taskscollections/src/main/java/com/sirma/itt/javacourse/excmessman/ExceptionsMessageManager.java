package com.sirma.itt.javacourse.excmessman;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class which has a map that contains some exceptions, a string and a pattern.
 * Contains as well, one method which adds an exception in the string from the
 * map by its value and another by its key. Also has a method for getting the
 * string and other static for getting the messages contained in that string
 * separated.
 * 
 * @author Nikolay Ch
 * 
 */
public class ExceptionsMessageManager {
	private HashMap<String, String> exceptions = new HashMap<String, String>();
	private String message = "";
	private final String SEPARATOR;
	private static Pattern pattern = Pattern.compile("[A-Za-z]++");

	public ExceptionsMessageManager(Map<String, String> getMap, String separator) {
		this.SEPARATOR = separator;
		this.exceptions = (HashMap<String, String>) getMap;
	}

	/**
	 * 
	 * Gets a message with an exception and checks if it is contained in the
	 * map. If it is true adds the message in the end of the string which keeps
	 * all correct exceptions.
	 * 
	 * @param mess
	 *            the string which contains the exception
	 */
	public void addExceptionMessage(String mess) {
		Iterator<String> valueIterator = exceptions.values().iterator();
		while (valueIterator.hasNext()) {
			String value = valueIterator.next();
			if (value.equals(mess)) {
				if (message.equals("")) {
					message += mess;
				} else {
					message += SEPARATOR;
					message += mess;
				}
			}
		}
	}

	/**
	 * Gets a string which represents a key code. If there is a value in the map
	 * with that key, adds the value to the big string. Else throws an
	 * Exception.
	 * 
	 * @param keyCode
	 *            the key which value must be added to the big string
	 * @throws Exception
	 *             when there is no value with that key
	 */
	public void addExceptionMessageUsingCode(String keyCode) throws Exception {
		boolean hasValue = false;
		Iterator<String> valueIterator = exceptions.keySet().iterator();
		while (valueIterator.hasNext()) {
			String code = valueIterator.next();
			if (code.equals(keyCode)) {
				if (message.equals("")) {
					message += exceptions.get(keyCode);
					hasValue = true;
				} else {
					message += SEPARATOR;
					message += exceptions.get(keyCode);
					hasValue = true;
				}
			}
		}
		if (hasValue == false) {
			throw new Exception("The key is wrong.");
		}
	}

	/**
	 * Getter for the big message with all other messages inside him.
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * Sets all the messages divided by the separator in a List and returns it.
	 * 
	 * @param messagesCombination
	 *            the message with all exceptions contained in it
	 * @return the messages each as a value in a list
	 */
	public static Collection<?> getMessages(String messagesCombination) {
		ArrayList<String> outMess = new ArrayList<String>();
		Matcher excMatcher = pattern.matcher(messagesCombination);

		String mess = "";
		while (excMatcher.find()) {
			mess = excMatcher.group();
			outMess.add(mess);
		}

		return outMess;
	}
}
