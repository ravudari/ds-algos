package com.felix.ds.tree;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * @author rajua
 *
 */
@Setter
@Getter
@RequiredArgsConstructor
public class BtNode<T> {
	@NonNull
	@Setter(AccessLevel.NONE)
	private T data;
	private BtNode<T> leftNode;
	private BtNode<T> rightNode;

	@Override
	public String toString() {
		return new StringBuffer().append("BtNode(").append(data).append(")").toString();
	}
}
