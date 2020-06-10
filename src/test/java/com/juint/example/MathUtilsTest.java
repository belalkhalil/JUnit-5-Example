package com.juint.example;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assumptions.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

 
/*
 * JUint 5 creates a new instance of each Test method to avoid dependency
 * 
 *with @TestInstance you can control num of instances of class MathUtilstest 
 * 
 * create instance PER_METHOD or PER_CLASS
 * 
 * @EnabledOnOs enables test on specific OS
 * */
@EnabledOnOs(OS.WINDOWS)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("When running MathUtils")
class MathUtilsTest {
	
	
	MathUtils mathUtils;
	TestInfo testInfo;
	TestReporter testReporter;
		
	//JUnit lifecycle hook annotations( @BeforeAll, @BeforeEach, @AfterAll, @AfterEach)
	// Using @BeforeEach to initialise new MathUtils instance for each Test methods
	@BeforeEach
	void init(TestInfo testInfo, TestReporter testReporter){
		
		this.testInfo=testInfo;
		this.testReporter= testReporter;
		mathUtils= new MathUtils();
		
		//using testInfo to get Data, testReporter to publish Data
		System.out.println("Running " + testInfo.getDisplayName() + " withTags" + testInfo.getTags());
		testReporter.publishEntry("Running " + testInfo.getDisplayName() + " withTags" + testInfo.getTags());
	}
	
	// Nested test the parent test
	@Nested
	@DisplayName("add method")
	@Tag("Math")
	class addTest{
		// we can put the @Test on multiple Methods and have them run all at once
		@DisplayName("when adding two positive numbers correctely")
		@Test
		@RepeatedTest(1)
		void testAddPositiv() {
			
			int actual = mathUtils.add(15, 5);
			int expected =20;
			/* there is also anther methods like, assertArrayEquals, assertIterableEquals
			 * for more methods visit https://junit.org/junit5/docs/5.4.1/api/org/junit/jupiter/api/Assertions.html
			 * 
			 * using Lamda in third arg lets JUit construct string only if test fails
			 */ 
			
			assertEquals(actual,expected, () -> "should return sum " + expected +"but was " + actual);
		}
		
		@DisplayName("when adding two negativ numbers correctely")
		@Test
		void testAddNegativ() {
			
			int actual = mathUtils.add(-15, -5);
			int expected =-20;
			assertEquals(actual,expected, "should return right sum");
		}
	}
	
	//Asserting exceptions with assertThrows
	@Test
	@Tag("Math")
	void testDivide() {
		
		//if the assumption not correct. method won't be tested
		boolean ifServerUp= false;
		assumeTrue(ifServerUp);
		//Asserting exceptions with assertThrows
		assertThrows(ArithmeticException.class, () -> mathUtils.div(1, 0), "divide by zero should throw");
	}
	
	// using @AssertAll
	@Test
	@DisplayName("test multipley")
	@Tag("Math")
	void testMultiply() {
		
		//takes collection on lamdas(assert statments
		assertAll(	
			() ->	assertEquals(4, mathUtils.mult(2, 2)),
			() ->	assertEquals(0, mathUtils.mult(2, 0)),
			() ->	assertEquals(-2, mathUtils.mult(2, -1))		
			);
	}
	
	//TDD Method
	@Test
	@Tag("Circle")
	void testCircleArea() {
		double actual = mathUtils.computeCircleArea(10.0);
		double expected = Math.PI * 10 * 10;
				
		assertEquals(actual, expected, "return Circle Area");
	}
		
	
	// skip test when run
	@Disabled
	@DisplayName("disabled test")
	void disableTest() {
		System.out.println("clean up ...");
		}
	
	// the methods thats annotated with @BeforeAll @AfterAll has to be static
	// if we have @TestInstance(TestInstance.Lifecycle.PER_CLASS) we don't need static word
	@AfterAll
	void cleanUp() {
		System.out.println("clean up ...");
		}
		

}
