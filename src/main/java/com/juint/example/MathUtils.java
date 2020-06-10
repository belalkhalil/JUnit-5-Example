package com.juint.example;

public class MathUtils {
	
	public int add(int a, int b) {
		return a+b;
	}
	public int sub(int a, int b) {
		return a-b;
	}
	public int mult(int a, int b) {
		return a*b;
	}
	public int div(int a, int b) {
		return a/b;
	}
	
	//Test Driven Development Method
	public double computeCircleArea(Double raduis) {
		return Math.PI * raduis * raduis;
	}
}
