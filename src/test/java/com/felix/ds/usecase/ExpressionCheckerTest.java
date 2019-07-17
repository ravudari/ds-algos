package com.felix.ds.usecase;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author rajua
 *
 */
public class ExpressionCheckerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsValidExpression() {
		ExpressionChecker expressionChecker = new ExpressionChecker();
		String expressionWithParenthesis = "[a+b(2*ba)+{ke2}]";
		assertEquals(true, expressionChecker.isValidExpression(expressionWithParenthesis));
		
		expressionWithParenthesis = "[a+b(2*ba)+<{ke2}{(<hello>)}>]";
		assertEquals(true, expressionChecker.isValidExpression(expressionWithParenthesis));

		expressionWithParenthesis = "[[a+b<{(<hello>)}>]";
		assertEquals(false, expressionChecker.isValidExpression(expressionWithParenthesis));
		
		expressionWithParenthesis = "[a+b<{(<hello>)}>]]";
		assertEquals(false, expressionChecker.isValidExpression(expressionWithParenthesis));

		expressionWithParenthesis = "][a+b<{(<hello>)}>]";
		assertEquals(false, expressionChecker.isValidExpression(expressionWithParenthesis));

		expressionWithParenthesis = "[a+b<{(<hello>)}>}";
		assertEquals(false, expressionChecker.isValidExpression(expressionWithParenthesis));

		expressionWithParenthesis = "[a+b<{(<hello)>}>]";
		assertEquals(false, expressionChecker.isValidExpression(expressionWithParenthesis));

		expressionWithParenthesis = "";
		assertEquals(true, expressionChecker.isValidExpression(expressionWithParenthesis));
		expressionWithParenthesis = "   ";
		assertEquals(true, expressionChecker.isValidExpression(expressionWithParenthesis));
		expressionWithParenthesis = "raju";
		assertEquals(true, expressionChecker.isValidExpression(expressionWithParenthesis));
	}

}
