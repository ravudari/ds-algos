package com.felix.ds.sort;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import lombok.extern.log4j.Log4j2;

/**
 * @author rajua
 *
 */
@Log4j2
public class SelectionSortTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		log.info("===========================================================");
	}

	@Test
	public void testSort_One() {
		int[] array = {9,1,8,2,3,7,4,6,5};
		log.info("Array before sorting ==> {}", array);
		SelectionSort.sort(array);
		String sorted = Util.toString(array);
		log.info("Array after sorting ==> {}", array);
		assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9]", sorted);
	}

	@Test
	public void testSort_Two() {
		int[] array = {989,111,288,812,743,367,464,696,515};
		log.info("Array before sorting ==> {}", array);
		SelectionSort.sort(array);
		String sorted = Util.toString(array);
		log.info("Array after sorting ==> {}", array);
		assertEquals("[111, 288, 367, 464, 515, 696, 743, 812, 989]", sorted);
	}

}