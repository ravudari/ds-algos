package com.felix.ds.tree;

import com.felix.ds.queue.Queue;

import lombok.extern.log4j.Log4j2;

/**
 * @author rajua
 *
 */
@Log4j2
public class BinaryTree<T extends Comparable<T>> {
	private BtNode<T> root;

	public BinaryTree() {
		log.info("Creating new BinaryTree({})", super.toString());
	}

	public void add(T data) {
		if (data == null) {
			throw new NullPointerException();
		}
		log.info("adding {}", data);
		if (root == null) {
			root = new BtNode<>(data);
			return;
		}

		add(root, data);
	}

	private void add(BtNode<T> node, T data) {
		if (data.compareTo(node.getData()) <= 0) {
			if (node.getLeftNode() != null) {
				add(node.getLeftNode(), data);
			} else {
				node.setLeftNode(new BtNode<>(data));
			}
		} else {
			if (node.getRightNode() != null) {
				add(node.getRightNode(), data);
			} else {
				node.setRightNode(new BtNode<>(data));
			}
		}
	}

	public void printByBreadthFirstTraversing() {
		if (root == null) {
			return;
		}
		@SuppressWarnings({ "unchecked", "rawtypes" })
		// TODO: Use BinaryTree's size as MAX_LENGTH parameter
		Queue<BtNode<T>> queue = (Queue) new Queue<>(BtNode.class, 100);
		queue.enqueue(root);

		StringBuilder sb = new StringBuilder();
		sb.append("[");
		while (!queue.isEmpty()) {
			BtNode<T> node = queue.dequeue();

			log.debug("node data = {}", node.getData());
			sb.append(node.getData());

			if (node.getLeftNode() != null) {
				queue.enqueue(node.getLeftNode());
			}
			if (node.getRightNode() != null) {
				queue.enqueue(node.getRightNode());
			}

			if (!queue.isEmpty()) {
				sb.append(", ");
			}
		}
		sb.append("]");

		log.info("{}", sb.toString());
	}

	public void deleteTree() {
		root = null;
	}

}
