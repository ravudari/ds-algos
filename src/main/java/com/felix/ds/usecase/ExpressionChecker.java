package com.felix.ds.usecase;

import java.util.HashMap;
import java.util.Map;

import com.felix.ds.Stack;

import lombok.extern.log4j.Log4j2;

/**
 * @author rajua
 *
 */
@Log4j2
public class ExpressionChecker {
	private static final Map<Character, Character> map = new HashMap<>();

	static {
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		map.put('>', '<');
	}

	public boolean isValidExpression(final String expressionWithParenthesis) {
		Stack<Character> stack = new Stack<>();
		int length = expressionWithParenthesis.length();
		for (int i = 0; i < length; i++) {
			char c = expressionWithParenthesis.charAt(i);
			if (map.containsValue(c)) {
				stack.push(c);
			} else if (map.containsKey(c)) {
				try {
					if (!stack.pop().equals(map.get(c))) {
						return false;
					}
				} catch (RuntimeException e) {
					log.error("RuntimeException :: ", e);
					return false;
				}
			}
		}
		return stack.getSize() == 0;
	}
}
