package com.juint.calculator;

public class Calculator implements IMultiplyer,IAdder {
	
	public int sum(int num1, int num2) {
		return num1 + num2;
	}
	
	public int sub(int num1, int num2) {
		return num1-num2;
	}
	
	public int mult(int num1, int num2) {
		return num1 * num2;
	}
	
	public int div(int num1, int num2) {
		return num1/num2;
	}
}
