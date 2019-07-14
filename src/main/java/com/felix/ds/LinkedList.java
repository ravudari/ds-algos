/**
 * 
 */
package com.felix.ds;

import lombok.extern.log4j.Log4j2;

/**
 * @author rajua
 *
 */
@Log4j2
public class LinkedList<T> {
	private Node<T> head;

	public LinkedList() {
		log.info("Creating new LinkedList({})", super.toString());
	}

	public void add(T data) {
		log.info("Adding {} to list", data);
		final Node<T> dataNode = new Node<T>(data);
		if (isEmpty()) {
			head = dataNode;
			return;
		}

		Node<T> lastNode = head;
		while (lastNode.getNext() != null) {
			lastNode = lastNode.getNext();
		}
		lastNode.setNext(dataNode);
	}

	public void addAtFront(T data) {
		log.info("Adding {} to list at front", data);
		final Node<T> dataNode = new Node<T>(data);
		dataNode.setNext(head);
		head = dataNode;
	}

	public boolean remove() {
		if (isEmpty()) {
			log.info("This list({}) is empty", super.toString());
			return Boolean.FALSE;
		} else if (isNodeNull(head.getNext())) {
			log.info("Removing the only value {} in the list({})", head.getNext().getData(), super.toString());
			head = null;
			return Boolean.TRUE;
		}

		Node<T> prevNode = head;
		Node<T> lastNode = head.getNext();
		while (lastNode.getNext() != null) {
			prevNode = lastNode;
			lastNode = lastNode.getNext();
		}

		log.info("Removing the value {} at end in the list({})", lastNode.getData(), super.toString());
		prevNode.setNext(null);
		return Boolean.TRUE;
	}

	public boolean remove(T data) {
		if (isEmpty()) {
			log.info("This list({}) is empty", super.toString());
			return Boolean.FALSE;
		} else {
			if ((data == head.getData()) || (data != null && data.equals(head.getData()))) {
				log.info("Removing the value {} in the list({})", head.getData(), super.toString());
				head = head.getNext();
				return Boolean.TRUE;
			}
		}

		@SuppressWarnings("unused")
		Node<T> prevNode = head;
		Node<T> currNode = head.getNext();
		while (currNode != null) {
			if ((data == currNode.getData()) || (data != null && data.equals(currNode.getData()))) {
				log.info("Removing the value {} at end in the list({})", currNode.getData(), super.toString());
				prevNode.setNext(currNode.getNext());
				return Boolean.TRUE;
			}
			prevNode = currNode;
			currNode = currNode.getNext();
		}
		return Boolean.FALSE;
	}

	public boolean removeAtFront() {
		if (isEmpty()) {
			log.info("This list({}) is empty", super.toString());
			return Boolean.FALSE;
		}

		log.info("Removing the value {} at front in the list({})", head.getData(), super.toString());
		head = head.getNext();
		return Boolean.TRUE;
	}

	private boolean isNodeNull(Node<T> node) {
		return node == null;
	}

	public boolean isEmpty() {
		return isNodeNull(head);
	}

	public int size() {
		int count = 0;
		if (isEmpty()) {
			return count;
		}
		count++;
		Node<T> nextNode = head.getNext();
		while (nextNode != null) {
			count++;
			nextNode = nextNode.getNext();
		}
		return count;
	}

	public void clear() {
		log.info("clearing the list({})", super.toString());
		head = null;
	}

	@Override
	public String toString() {
		StringBuilder data = new StringBuilder();
		if (head != null) {
			data.append(head.getData());
			Node<T> nextNode = head.getNext();
			while (nextNode != null) {
				data.append(", ").append(nextNode.getData());
				nextNode = nextNode.getNext();
			}
		}
		return "[" + data + "]";
	}
}
