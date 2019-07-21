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
public class QuickSortTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		log.info("===========================================================");
	}

	@Test
	public void testQuickSort_WithOneElement() {
		int[] array = { 9 };
		log.info("Array before Quick sorting ==> {}", array);
		QuickSort.sort(array);
		String sorted = Util.toString(array);
		log.info("Array after Quick sorting ==> {}", array);
		assertEquals("[9]", sorted);
	}

	@Test
	public void testQuickSort_WithTwoElements() {
		int[] array = { 9, 6 };
		log.info("Array before Quick sorting ==> {}", array);
		QuickSort.sort(array);
		String sorted = Util.toString(array);
		log.info("Array after Quick sorting ==> {}", array);
		assertEquals("[6, 9]", sorted);
	}

	@Test
	public void testQuickSort_WithThreeElements() {
		int[] array = { 11, 9, 6 };
		log.info("Array before Quick sorting ==> {}", array);
		QuickSort.sort(array);
		String sorted = Util.toString(array);
		log.info("Array after Quick sorting ==> {}", array);
		assertEquals("[6, 9, 11]", sorted);
	}

	@Test
	public void testQuickSort_One() {
		int[] array = { 9, 1, 8, 2, 3, 7, 26, 4, 6, 5, 20, 30 };
		log.info("Array before Quick sorting ==> {}", array);
		QuickSort.sort(array);
		String sorted = Util.toString(array);
		log.info("Array after Quick sorting ==> {}", array);
		assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 20, 26, 30]", sorted);
	}

	@Test
	public void testQuickSort_Two() {
		int[] array = { 989, 99, 111, 288, 812, 108, 743, 367, 464, 696, 515 };
		log.info("Array before Quick sorting ==> {}", array);
		QuickSort.sort(array);
		String sorted = Util.toString(array);
		log.info("Array after Quick sorting ==> {}", array);
		assertEquals("[99, 108, 111, 288, 367, 464, 515, 696, 743, 812, 989]", sorted);
	}

	@Test
	public void testQuickSort_WithDuplicateElements() {
		int[] array = { 9, 1, 8, 2, 3, 7, 9, 1, 8, 2, 3, 7 };
		log.info("Array before Quick sorting ==> {}", array);
		QuickSort.sort(array);
		String sorted = Util.toString(array);
		log.info("Array after Quick sorting ==> {}", array);
		assertEquals("[1, 1, 2, 2, 3, 3, 7, 7, 8, 8, 9, 9]", sorted);
	}

}
