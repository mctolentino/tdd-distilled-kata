package com.makshacks.screencast;

public class SavingsAccountYear {

	private int startingBalance = 0;
	private int interestRate = 0;
	private int capitalGainsAmount = 0;
	private int totalWithdrawn;
	private int startingPrincipal;
	
	public SavingsAccountYear(){}
	
	public SavingsAccountYear(int startingBalance, int interestRate) {
		this.startingBalance = startingBalance;
		this.interestRate = interestRate;
	}

	public SavingsAccountYear(int startingBalance, int startingPrincipal, int interestRate) {
		this.startingBalance = startingBalance;
		this.startingPrincipal = startingPrincipal;
		this.capitalGainsAmount  = startingBalance - startingPrincipal;
		this.interestRate = interestRate;
	}


	public int startingBalance() {
		return startingBalance;
	}
	
	public int startingPrincipal(){
		return startingBalance - capitalGainsAmount; 
	}
	
	public int interestRate() {
		return this.interestRate;
	}
	
	public int totalWithdrawn() {
		return this.totalWithdrawn;
	}

	
	public int endingPrincipal() {
		int result = startingPrincipal() - totalWithdrawn;
		return Math.max(0, result);
	}
	
	public int endingBalance(int capitalGainsTaxRate) {
		int modifiedStart = startingBalance - totalWithdrawn() - capitalGainsTaxIncurred(capitalGainsTaxRate);
		return modifiedStart + (modifiedStart * interestRate / 100);
	}

	public SavingsAccountYear nextYear(int capitalGainsTaxRate) {
		return new SavingsAccountYear(this.endingBalance(capitalGainsTaxRate), interestRate);
	}
	
	public void withdraw(int amount) {
		this.totalWithdrawn += amount;
	}

	public int capitalGainsWithdrawn() {
		int result = -1 * (startingPrincipal() - totalWithdrawn());
		return Math.max(0, result);
	}

	public int capitalGainsTaxIncurred(int taxRate) {
		double dblTaxRate = taxRate / 100.0;
		double dblCapGains = capitalGainsWithdrawn();
	
		return (int)((dblCapGains / (1 - dblTaxRate)) - dblCapGains);
	}

	
	
	
}
