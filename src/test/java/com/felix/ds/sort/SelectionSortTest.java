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
	public void testSelectionSort_WithOneElement() {
		int[] array = { 9 };
		log.info("Array before Selection sorting ==> {}", array);
		SelectionSort.sort(array);
		String sorted = Util.toString(array);
		log.info("Array after Selection sorting ==> {}", array);
		assertEquals("[9]", sorted);
	}

	@Test
	public void testSelectionSort_WithTwoElements() {
		int[] array = { 9, 6 };
		log.info("Array before Selection sorting ==> {}", array);
		SelectionSort.sort(array);
		String sorted = Util.toString(array);
		log.info("Array after Selection sorting ==> {}", array);
		assertEquals("[6, 9]", sorted);
	}

	@Test
	public void testSelectionSort_WithThreeElements() {
		int[] array = { 11, 9, 6 };
		log.info("Array before Selection sorting ==> {}", array);
		SelectionSort.sort(array);
		String sorted = Util.toString(array);
		log.info("Array after Selection sorting ==> {}", array);
		assertEquals("[6, 9, 11]", sorted);
	}
	
	@Test
	public void testSelectionSort_One() {
		int[] array = {9,1,8,2,3,7,4,6,5};
		log.info("Array before selection sorting ==> {}", array);
		SelectionSort.sort(array);
		String sorted = Util.toString(array);
		log.info("Array after selection sorting ==> {}", array);
		assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9]", sorted);
	}

	@Test
	public void testSelectionSort_Two() {
		int[] array = {989,111,288,812,743,367,464,696,515};
		log.info("Array before selection sorting ==> {}", array);
		SelectionSort.sort(array);
		String sorted = Util.toString(array);
		log.info("Array after selection sorting ==> {}", array);
		assertEquals("[111, 288, 367, 464, 515, 696, 743, 812, 989]", sorted);
	}

	@Test
	public void testSelectionSort_WithDuplicateElements() {
		int[] array = { 9, 1, 8, 2, 3, 7, 9, 1, 8, 2, 3, 7 };
		log.info("Array before Selection sorting ==> {}", array);
		SelectionSort.sort(array);
		String sorted = Util.toString(array);
		log.info("Array after Selection sorting ==> {}", array);
		assertEquals("[1, 1, 2, 2, 3, 3, 7, 7, 8, 8, 9, 9]", sorted);
	}
}
