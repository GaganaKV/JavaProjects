package com.calculator;

public class CalculatorImple implements Calculator {
	@Override
	public String add(int a,int b) {
		return "sum of "+a+" & "+b+" is "+(a+b);
				}
	@Override
	public String sub(int a,int b) {
		return "Difference of "+a+" & "+b+" is "+(a-b);
	}
	@Override
	public String mul(int a,int b) {
		return "Multiplication of "+a+" & "+b+" is "+(a*b);
	}
	@Override
	public String div(int a,int b) {
		if(b!=0) {
		return "Division of "+a+" & "+b+" is "+(a/b);
	}
		else {
			return "invalid denominator";
		}
	}
		@Override
		public String displayErrorMessage() {
			return "Invalid Choice,please enter valid ,choice";
		}

	}	
