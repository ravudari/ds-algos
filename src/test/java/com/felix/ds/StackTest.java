package com.felix.ds;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import lombok.extern.log4j.Log4j2;

/**
 * @author rajua
 *
 */
@Log4j2
public class StackTest {
	private static Stack<String> stack;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		stack = new Stack<>();
	}

	@Before
	public void setUp() throws Exception {
		log.info("===================================================");
		stack.clear();
	}

	@Test
	public void testPush() {
		stack.push("Raju");
		stack.push("Shanmukha");
		stack.push("Venky");
		log.info("Stack is {}", stack.toString());
		assertEquals("[Venky, Shanmukha, Raju]", stack.toString());
		assertEquals(3,stack.getSize());
	}

	@Test
	public void testPop_EmptyStack() {
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("StackUnderFlow");
		stack.pop();
	}

	@Test
	public void testPop() {
		stack.push("Raju");
		stack.push("Shanmukha");
		stack.push("Venky");
		assertEquals("Venky", stack.pop());
		assertEquals("Shanmukha", stack.pop());
		assertEquals("Raju", stack.pop());
		log.info("Stack is {}", stack.toString());
		assertEquals("[]", stack.toString());
		assertEquals(0, stack.getSize());
	}

	@Test
	public void testPeek_EmptyStack() {
		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("StackUnderFlow");
		stack.peek();
	}
	
	@Test
	public void testPeek() {
		stack.push("Raju");
		stack.push("Shanmukha");
		stack.push("Venky");
		assertEquals("Venky", stack.peek());
		assertEquals("Venky", stack.peek());
		log.info("Stack is {}", stack.toString());
		assertEquals("[Venky, Shanmukha, Raju]", stack.toString());
		assertEquals(3, stack.getSize());
	}

}
