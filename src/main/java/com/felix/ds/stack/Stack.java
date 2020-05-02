/**
 * 
 */
package com.felix.ds.stack;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

/**
 * @author rajua
 *
 */
@Log4j2
public class Stack<T> {
	private Element<T> top;
	@Getter
	private int size;

	public Stack() {
		log.info("Creating new Stack({})", super.toString());
	}

	public void push(T data) {
		log.info("pushing {}", data);
		Element<T> element = new Element<T>(data);
		element.setNext(top);
		top = element;
		++size;
	}
	
	public T pop() {
		T data = this.peek();
		log.info("poping {}", data);
		top = top.getNext();
		--size;
		return data;
	}

	public T peek() {
		if(top == null) {
			throw new RuntimeException("StackUnderFlow");
		}
		T data = top.getData();
		log.info("peeking {}", data);
		return data;
	}

	public void clear() {
		top = null;
		size = 0;
	}

	@Override
	public String toString() {
		StringBuilder data = new StringBuilder();
		Element<T> start = top;
		while (start != null) {
			data.append(start.getData());
			Element<T> next = start.getNext();
			if (next != null) {
				data.append(", ");
			}
			start = next;
		}
		return "[" + data + "]";
	}
}
