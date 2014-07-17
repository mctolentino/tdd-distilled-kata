package com.makshacks.screencast;

public class SavingsAccountYear {

	private int startingBalance = 0;
	private int interestRate = 0;
	
	public SavingsAccountYear(){}
	
	public SavingsAccountYear(int startingBalance, int interestRate) {
		this.startingBalance = startingBalance;
		this.interestRate = interestRate;
	}


	public int startingBalance() {
		return startingBalance;
	}

	public int interestRate() {
		return this.interestRate;
	}

	public SavingsAccountYear nextYear() {
		return new SavingsAccountYear(this.endingBalance(), interestRate);
	}
	
	public int endingBalance(){
		return startingBalance() + (startingBalance() * interestRate / 100);
	}

	
}
