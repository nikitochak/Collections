package com.sirma.itt.javacourse.pagebeans;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the methods in the PageBean class.
 * 
 * @author Nikolay Ch
 * 
 */
public class PageBeanTest {
	private PageBean pageBean;
	private ArrayList<String> testList;

	/**
	 * Initializes a test list and puts it as a parameter in the constructor in
	 * PageBean class.
	 */
	@Before
	public void initialize() {
		testList = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			String line = "";
			line += i;
			testList.add(line);
			pageBean = new PageBean(2, testList);
		}
	}

	/**
	 * Tests the next and firstPage methods in the PageBean class. First sets
	 * the current page to be the first in the book and then compares the value
	 * returned by the method next and the elements in the test list.
	 */
	@Test
	public void testNext() {

		pageBean.firstPage();
		assertEquals(pageBean.next(), testList.subList(2, 4));
	}

	/**
	 * Tests the previous and lastPage methods in the PageBean class. Sets the
	 * current page to be last one in the book and compares the value returned
	 * by the method previous and the elements in the test list which must
	 * concur.
	 */
	@Test
	public void testPrevious() {
		pageBean.lastPage();
		assertEquals(pageBean.previous(), testList.subList(2, 4));
	}

	/**
	 * Sets the current page to be the last and tests if the method hasNext will
	 * return false.
	 */
	@Test
	public void testHasNext() {
		pageBean.lastPage();
		assertFalse(pageBean.hasNext());
	}

	/**
	 * Sets the current page to be the first and tests if the hasPrevious method
	 * will return false.
	 */
	@Test
	public void testHasPrevious() {
		pageBean.firstPage();
		assertFalse(pageBean.hasPrevious());
	}
}
