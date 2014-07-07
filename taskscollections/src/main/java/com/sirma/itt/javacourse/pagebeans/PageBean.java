package com.sirma.itt.javacourse.pagebeans;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageBean {
	private ArrayList<List<?>> book = new ArrayList<List<?>>();
	private static final Logger logger = LoggerFactory
			.getLogger(PageBean.class);
	private int toWhere;

	/**
	 * Constructor for the class. Initializes the book.
	 * 
	 * @param pageSize
	 *            the number of elements each page must contain
	 * @param list
	 *            the list with all elements
	 */
	public PageBean(int pageSize, List<?> list) {

		int counter = 0;
		for (int i = 0; i < list.size(); i += pageSize) {
			if (i + pageSize < list.size()) {
				book.add(counter, list.subList(i, i + pageSize));
			} else {
				book.add(counter, list.subList(i, list.size() - 1));
			}
			counter++;
		}

		this.toWhere = 0;
	}

	/**
	 * Method for returning the next page.
	 * 
	 * @return the next page
	 */
	public List<?> next() {

		if (toWhere != book.size() - 1) {
			toWhere++;
		}
		List<?> out = book.get(toWhere);
		return out;
	}

	/**
	 * Method for getting the previous page.
	 * 
	 * @return the previous page if exists
	 */
	public List<?> previous() {

		if (toWhere != 0) {
			toWhere--;
			return book.get(toWhere);
		} else {
			logger.warn("You are on the first page there are not previous.");
			return null;
		}

	}

	/**
	 * Checks if there is next page.
	 * 
	 * @return true if there is
	 */
	public boolean hasNext() {

		if (toWhere == book.size() - 1) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Checks if there is previous page.
	 * 
	 * @return true if there is
	 */
	public boolean hasPrevious() {

		if (toWhere == 0) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Makes the first page current and returns it.
	 * 
	 * @return the first element
	 */
	public List<?> firstPage() {

		toWhere = 0;
		return book.get(toWhere);
	}

	/**
	 * Makes the last page current and returns it.
	 * 
	 * @return the last page
	 */
	public List<?> lastPage() {
		toWhere = book.size() - 1;
		return book.get(toWhere);
	}

	/**
	 * Gets the current page number.
	 * 
	 * @return the number
	 */
	public int getCurrentPageNumber() {
		return toWhere;
	}

}
