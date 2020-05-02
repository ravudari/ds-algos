package com.felix.ds;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.felix.ds.list.LinkedList;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class LinkedListTest {

	private static LinkedList<Integer> list = null;

	@BeforeClass
	public static void setup() {
		log.info("inside setup()");
		list = new LinkedList<>();
	}

	@Before
	public void before() {
		list.clear();
	}

	@Test
	public void testAdd_Basic() {
		list.add(10);
		list.add(20);
		list.add(30);
		log.info("List is {}", list);
		assertEquals("[10, 20, 30]", list.toString());
		assertEquals(3, list.size());
	}

	@Test
	public void testAdd_Empty() {
		log.info("List is {}", list);
		assertEquals("[]", list.toString());
		assertEquals(0, list.size());
	}

	@Test
	public void testAdd_Duplicates() {
		list.add(0);
		list.add(20);
		list.add(30);
		list.add(20);
		list.add(30);
		log.info("List is {}", list);
		assertEquals("[0, 20, 30, 20, 30]", list.toString());
		assertEquals(5, list.size());
	}

	@Test
	public void testAdd_Null() {
		list.add(null);
		list.add(10);
		list.add(null);
		list.add(30);
		log.info("List is {}", list);
		assertEquals("[null, 10, null, 30]", list.toString());
		assertEquals(4, list.size());
	}

	@Test
	public void testAddAtFront_Basic() {
		list.add(null);
		list.add(26);
		log.info("List is {}", list);
		assertEquals("[null, 26]", list.toString());
		assertEquals(2, list.size());
		list.addAtFront(16);
		log.info("List is {}", list);
		assertEquals("[16, null, 26]", list.toString());
		assertEquals(3, list.size());
	}

	@Test
	public void testAddAtFront_Adv() {
		log.info("List is {}", list);
		assertEquals("[]", list.toString());
		assertEquals(0, list.size());
		list.addAtFront(36);
		log.info("List is {}", list);
		assertEquals("[36]", list.toString());
		assertEquals(1, list.size());
		list.add(46);
		list.addAtFront(26);
		log.info("List is {}", list);
		assertEquals("[26, 36, 46]", list.toString());
		assertEquals(3, list.size());

	}

	@Test
	public void testRemove() {
		log.info("List is {}", list);
		assertEquals(false, list.remove());
		assertEquals("[]", list.toString());
		assertEquals(0, list.size());
		
		list.addAtFront(36);
		list.add(46);
		list.addAtFront(26);
		assertEquals(true, list.remove());
		assertEquals(true, list.remove());
		log.info("List is {}", list);
		assertEquals("[26]", list.toString());
		assertEquals(1, list.size());
	}

	@Test
	public void testRemove_Element() {
		log.info("List is {}", list);
		assertEquals(false, list.remove(10));
		assertEquals("[]", list.toString());
		assertEquals(0, list.size());
		
		list.addAtFront(36);
		list.add(46);
		list.addAtFront(26);
		list.addAtFront(16);
		assertEquals(true, list.remove(36));
		log.info("List is {}", list);
		assertEquals("[16, 26, 46]", list.toString());
		assertEquals(3, list.size());
		
		list.clear();
		list.add(10);
		assertEquals(false, list.remove(100));
		assertEquals(true, list.remove(10));
		list.add(10);
		list.add(20);
		list.add(30);
		assertEquals(true, list.remove(30));
		
	}

	@Test
	public void testRemoveAtFront() {
		log.info("List is {}", list);
		assertEquals(false, list.removeAtFront());
		
		list.addAtFront(36);
		list.add(46);
		list.addAtFront(26);
		assertEquals(true, list.removeAtFront());
		assertEquals(true, list.removeAtFront());
		log.info("List is {}", list);
		assertEquals("[46]", list.toString());
		assertEquals(1, list.size());
	}

	@Test
	public void testClear() {
		list.add(null);
		list.add(10);
		list.add(null);
		list.add(30);
		log.info("List is {}", list);
		assertEquals("[null, 10, null, 30]", list.toString());
		assertEquals(4, list.size());
		list.clear();
		log.info("After clear List is {}", list);
		assertEquals("[]", list.toString());
		assertEquals(0, list.size());

	}

}
