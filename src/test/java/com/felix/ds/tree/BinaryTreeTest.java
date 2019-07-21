/**
 * 
 */
package com.felix.ds.tree;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import lombok.extern.log4j.Log4j2;

/**
 * @author rajua
 *
 */
@Log4j2
public class BinaryTreeTest {
	private static BinaryTree<Integer> btree = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		btree = new BinaryTree<>();
	}

	@Before
	public void setUp() throws Exception {
		log.info("===========================================================");
	}

	@Test
	public void testAdd() {
		btree.add(26);
		btree.add(25);
		btree.add(50);
		btree.add(45);
		btree.add(55);
		btree.add(40);
		btree.add(46);
		btree.add(60);
		assertEquals(true, true);
	}

	@Test
	public void testPrintByBreadthFirstTraversing() {
		btree.printByBreadthFirstTraversing();
	}

}
