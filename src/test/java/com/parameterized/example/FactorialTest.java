package com.parameterized.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;



class FactorialTest {
		
/*
 * user @ParameterizedTest(name="")
	@MethodSource("parameterizedInput") with a stream to make Parameterised Test in JUint 5
 * 
 */

	
		public static Stream<Arguments> parameterizedInput(){
			return Stream.of(
					Arguments.of(0,1),
					Arguments.of(1,1),
					Arguments.of(2,2),
					Arguments.of(3,6),
					Arguments.of(4,24)
					
					);
					
		}
			
	@ParameterizedTest(name="{0} should return {1} ")
	@MethodSource("parameterizedInput")
	public void testFactorialParameterized(int input, int expected) {
	assertEquals(expected, Factorial.computeFactorial(input));
		
	}
	
	// not parameterized
	@Test
	void testFactorial() {
		assertEquals(Factorial.computeFactorial(0), 1);
		assertEquals(Factorial.computeFactorial(1), 1);
		assertEquals(Factorial.computeFactorial(2), 2);
		assertEquals(Factorial.computeFactorial(3), 6);
		assertEquals(Factorial.computeFactorial(4), 24);
		assertEquals(Factorial.computeFactorial(5), 120);
	}

}
