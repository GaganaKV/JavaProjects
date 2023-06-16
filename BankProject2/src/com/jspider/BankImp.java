package com.jspider;

public class BankImp implements Bank {
	static int balance;
	
     BankImp(int balance){
    	 this.balance=balance;
     }
	@Override
	public void deposit(int amount) {
		balance +=amount;
		System.out.println("amount deposited successfully"+amount);
		
	}

	@Override
	public void withdraw(int amount) {
		balance -= amount;
		if(balance<=amount)
		{
			System.out.println("amount withdrawn successfully "+amount);
		}
		else {
			try {
				throw new InsufficientBalanceException("insufficient balance");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public int getBalance() {
		return balance;
	}

	@Override
	public String displayErrorMessage() {
		return "Invalid choice";
	}
	

}
