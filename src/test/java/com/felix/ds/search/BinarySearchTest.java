package com.felix.ds.search;

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
public class BinarySearchTest {

	final boolean T = Boolean.TRUE;
	final boolean F = Boolean.FALSE;

	@Before
	public void setUp() throws Exception {
		log.info("===========================================================");
	}

	@Test
	public void testSearch_With1Element() {
		int[] array = { 10 };
		assertEquals(true, BinarySearch.search(array, 10));
		assertEquals(false, BinarySearch.search(array, 20));
		assertEquals(false, BinarySearch.search(array, 5));
	}

	@Test
	public void testSearch_With2Elements() {
		int[] array = { 10, 20 };
		assertEquals(T, BinarySearch.search(array, 10));
		assertEquals(T, BinarySearch.search(array, 20));
		assertEquals(F, BinarySearch.search(array, 5));
		assertEquals(F, BinarySearch.search(array, 15));
		assertEquals(F, BinarySearch.search(array, 30));
	}

	@Test
	public void testSearch_With3Elements() {
		int[] array = { 10, 20, 30 };
		assertEquals(T, BinarySearch.search(array, 10));
		assertEquals(T, BinarySearch.search(array, 20));
		assertEquals(T, BinarySearch.search(array, 30));
		assertEquals(F, BinarySearch.search(array, 5));
		assertEquals(F, BinarySearch.search(array, 15));
		assertEquals(F, BinarySearch.search(array, 25));
		assertEquals(F, BinarySearch.search(array, 35));
	}

	@Test
	public void testSearch_With4Elements() {
		int[] array = { 10, 20, 30, 40 };
		assertEquals(T, BinarySearch.search(array, 10));
		assertEquals(T, BinarySearch.search(array, 20));
		assertEquals(T, BinarySearch.search(array, 30));
		assertEquals(T, BinarySearch.search(array, 40));
		assertEquals(F, BinarySearch.search(array, 5));
		assertEquals(F, BinarySearch.search(array, 15));
		assertEquals(F, BinarySearch.search(array, 25));
		assertEquals(F, BinarySearch.search(array, 35));
		assertEquals(F, BinarySearch.search(array, 45));
	}

	@Test
	public void testSearch_With4Elements_NotSorted() {
		int[] array = { 30, 20, 10, 40 };
		assertEquals(F, BinarySearch.search(array, 10));
		assertEquals(F, BinarySearch.search(array, 30));
	}

	@Test
	public void testSearch_One() {
		int[] array = { 10, 20, 30, 40, 45, 50, 55, 60, 65 };
		assertEquals(T, BinarySearch.search(array, 10));
		assertEquals(T, BinarySearch.search(array, 20));
		assertEquals(T, BinarySearch.search(array, 30));
		assertEquals(T, BinarySearch.search(array, 40));
		assertEquals(F, BinarySearch.search(array, 5));
		assertEquals(F, BinarySearch.search(array, 15));
		assertEquals(F, BinarySearch.search(array, 25));
		assertEquals(F, BinarySearch.search(array, 35));
		assertEquals(T, BinarySearch.search(array, 45));
		assertEquals(T, BinarySearch.search(array, 55));
		assertEquals(T, BinarySearch.search(array, 65));
	}
}
