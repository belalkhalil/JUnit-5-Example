package com.parameterized.example;

public class Factorial {
	
	public static int computeFactorial(int n) {
		
		if(n < 2) {return 1;}
		return n * computeFactorial(n-1);
	}
	

}
