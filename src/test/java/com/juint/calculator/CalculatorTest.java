package com.juint.calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

//Testgetriebene Entwicklung: Bei der testgetriebenen Entwicklung erstellt der Programmierer Softwaretests konsequent vor den zu testenden Komponenten. wiki.

class CalculatorTest {
	
	public Calculator calculator;
	
	@BeforeEach	
	void init(){
		calculator= new Calculator();
	}
	
	@DisplayName("add two numbers")
	@Test
	void testSum() {
		
		int actual = calculator.sum(15, 5);
		int expected =20;
		assertEquals(actual,expected, "should return right sum");
	}
	
	@DisplayName("subtract two numbers")
	@Test
	void testSub() {
		
		int actual = calculator.sub(-15, 5);
		int expected =-20;
		assertEquals(actual,expected, "should return right substraction");
	}
	
	//Asserting exceptions with assertThrows
	@DisplayName("divide two numbers")
	@Test
	void testDivide() {
		//Asserting exceptions with assertThrows
		assertThrows(ArithmeticException.class, () -> calculator.div(1, 0), "divide by zero should throw");
	}
	
	// using @AssertAll
	@Test
	@DisplayName("multiply two numbers")
	void testMultiply() {
		
		//takes collection on lamdas(assert statments
		assertAll(	
			() ->	assertEquals(4, calculator.mult(2, 2)),
			() ->	assertEquals(0, calculator.mult(2, 0)),
			() ->	assertEquals(-2, calculator.mult(2, -1))		
			);
	}
		
	

}
