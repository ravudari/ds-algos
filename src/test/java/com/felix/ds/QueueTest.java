/**
 * 
 */
package com.felix.ds;

import static org.junit.Assert.*;

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
public class QueueTest {
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		log.info("====================================================");
	}

	@Test
	public void testEnqueue_Basic() {
		Queue<Integer> queue = new Queue<>(Integer.class);
		assertEquals(true, queue.isEmpty());
		assertEquals(false, queue.isFull());
		
		queue.enqueue(10);
		assertEquals(false, queue.isEmpty());
		assertEquals(false, queue.isFull());
		
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.enqueue(60);
		assertEquals(false, queue.isEmpty());
		assertEquals(true, queue.isFull());

//		expectedException.expect(RuntimeException.class);
		expectedException.expectMessage("StackOverFlow");
		queue.enqueue(100);
	}

	@Test
	public void testDequeue_Basic() {
		Queue<String> queue = new Queue<>(String.class);
		assertEquals(true, queue.isEmpty());
		assertEquals(false, queue.isFull());
		
		queue.enqueue("A");
		queue.enqueue("B");
		assertEquals(false, queue.isEmpty());
		assertEquals(false, queue.isFull());
		
		assertEquals("A", queue.dequeue());
		assertEquals("B", queue.dequeue());
		assertEquals(true, queue.isEmpty());
		assertEquals(false, queue.isFull());
		
		expectedException.expectMessage("StackUnderFlow");
		queue.dequeue();
	}
	
	@Test
	public void testPeek() {
		Queue<Double> queue = new Queue<>(Double.class);
		assertEquals(true, queue.isEmpty());
		assertEquals(false, queue.isFull());
		
		queue.enqueue(10.5);
		assertEquals(new Double(10.5), queue.peek());
		queue.enqueue(20.5);
		assertEquals(new Double(10.5), queue.peek());
		assertEquals(new Double(10.5), queue.dequeue());
		assertEquals(new Double(20.5), queue.peek());
		
		assertEquals(false, queue.isEmpty());
		assertEquals(false, queue.isFull());
		
		assertEquals(new Double(20.5), queue.dequeue());
		assertEquals(true, queue.isEmpty());
		assertEquals(false, queue.isFull());
		expectedException.expectMessage("StackUnderFlow");
		queue.peek();
	}
	
	@Test
	public void testEnqueueDequeuePeekCombination() {
		Queue<Integer> queue = new Queue<>(Integer.class);
		queue.enqueue(0);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.peek();
		queue.peek();
		queue.peek();
		queue.enqueue(30);
		queue.enqueue(40);
		queue.peek();
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(null);
		queue.enqueue(100);
		queue.enqueue(1000);
		assertEquals(false, queue.isEmpty());
		assertEquals(true, queue.isFull());
		
		queue.peek();
		queue.peek();
		assertEquals(false, queue.isEmpty());
		assertEquals(true, queue.isFull());
		
		queue.dequeue();
		assertEquals(false, queue.isFull());

		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		assertEquals(true, queue.isEmpty());
		assertEquals(false, queue.isFull());
	}

}
