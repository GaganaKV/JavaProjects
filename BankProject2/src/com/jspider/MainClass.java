package com.jspider;

import java.util.Scanner;

public class MainClass {
  public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter balance");
	int balance=s.nextInt();
	Bank b=new BankImp(balance);
	while(true) {
		System.out.println("1.Deposit\n2.Withdraw\n3.balance\n4.Exit");
		System.out.println("Enter your choice");
		int choice=s.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter your amount to deposit ");
			int amountToDeposit=s.nextInt();
			b.deposit(amountToDeposit);
			break;
		
		case 2:
			System.out.println("Enter amount to withdraw ");
			int withdraw=s.nextInt();
		     b.withdraw(withdraw);
		     break;
		case 3:
			System.out.println("balance"+b.getBalance());
			break; 
		case 4:
			System.out.println(b.displayErrorMessage());
			break;
		case 5:
			System.out.println("Thank u");
			System.exit(0);
	}
		System.out.println("============================");
}
}
}
