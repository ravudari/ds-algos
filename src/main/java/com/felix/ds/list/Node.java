/**
 * 
 */
package com.felix.ds.list;

import lombok.Getter;
import lombok.Setter;

/**
 * @author rajua
 *
 */
public class Node<T> {
	@Getter
	private T data;
	@Setter
	@Getter
	private Node<T> next;

	public Node(T data) {
		this.data = data;
	}
}
