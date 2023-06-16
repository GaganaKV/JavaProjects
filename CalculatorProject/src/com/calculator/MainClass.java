package com.calculator;

import java.util.Scanner;

public class MainClass {
	static Scanner s=new Scanner(System.in);
	static int a;//0
	static int b;//0
	static void acceptInput() {
		System.out.println("Enter first number:");
		a=s.nextInt();
		System.out.println("Enter second number:");
		b=s.nextInt();
	}


	public static void main(String[] args) {
		Calculator calsi=new CalculatorImple();//upcasting-->Abstraction
		while(true) {//infinite
			System.out.println("1:Addition\n2:Subtraction\n3:Multiplication\n4:Division\n5:Exit\n");
			System.out.println("Enter your choice:");
			int choice=s.nextInt();
			if(choice>=1 && choice<=4) {
				acceptInput();
			}
			switch(choice) {
			case 1:System.out.println(calsi.add(a, b));
			break;
			case 2: System.out.println(calsi.sub(a, b));
			break;
			case 3: System.out.println(calsi.mul(a, b));
			break;
			case 4: System.out.println(calsi.div(a, b));
			break;
			case 5: 
				System.out.println("thank you");
				System.exit(0);//Terminates the Program
			default: System.out.println(calsi.displayErrorMessage());
			}
			System.out.println("---------------");
		}
	}
}