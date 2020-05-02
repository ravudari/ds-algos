package com.felix.ds.queue;

import java.lang.reflect.Array;

import lombok.extern.log4j.Log4j2;

/**
 * @author rajua
 *
 */
@Log4j2
public class Queue<T> {
	private static final int SPECIAL_EMPTY_VALUE = -1;
	private final T[] elements;

	private int head = SPECIAL_EMPTY_VALUE;
	private int tail = SPECIAL_EMPTY_VALUE;

	@SuppressWarnings("unchecked")
	public Queue(Class<T> clazz, int MAX_LENGTH) {

		elements = (T[]) Array.newInstance(clazz, MAX_LENGTH);
		log.info("Creating a new Queue({})", super.toString());
	}

	public boolean isEmpty() {
		return head == SPECIAL_EMPTY_VALUE;
	}

	public boolean isFull() {
		int nextIndex = (tail + 1) % elements.length;
		return nextIndex == head;
	}

	public void enqueue(T data) {
		log.info("Tying Enqueuing {}", data);
		if (isFull()) {
			throw new RuntimeException("StackOverFlow");
		}
		tail = (tail + 1) % elements.length;
		elements[tail] = data;
		if (isEmpty()) {
			head = tail;
		}
	}

	public T dequeue() {
		T data = peek();
		log.info("Dequeuing {}", data);
		if (head == tail) {
			head = SPECIAL_EMPTY_VALUE;
		} else {
			head = (head + 1) % elements.length;
		}
		return data;
	}

	public T peek() {
		if (isEmpty()) {
			throw new RuntimeException("StackUnderFlow");
		}
		T data = elements[head];
		log.info("Peeking {}", data);
		return data;
	}

	private void printHeadTail() {
		log.info("head={} :: tail={}", head, tail);
	}

	public int size() {
		printHeadTail();
		if (isEmpty())
			return 0;
		else if (isFull())
			return elements.length;
		else if (head <= tail)
			return tail - head + 1;
		else
			return elements.length - head + tail + 1;
	}

}
