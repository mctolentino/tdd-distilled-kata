package com.makshacks.screencast;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class _SavingsAccountYearTest {
	
		@Test
		public void startingBalanceMatchesConstructor(){
			assertEquals(10000, newAccount().startingBalance());
		}

		@Test
		public void startingBalance(){
			assertEquals(10000, newAccount().startingBalance());
		}		
		
		@Test
		public void endingBalance(){
			assertEquals(11000, newAccount().endingBalance());
		}
		
		@Test
		public void nextYearStartingBalanceEqualsThisYearsEndingBalance(){
			SavingsAccountYear account = newAccount();
			assertEquals(account.endingBalance(), newAccount().nextYear().startingBalance());
		}
		
		@Test
		public void nextYearsInterestRateEqualsThisYearsInterestRate(){
			SavingsAccountYear thisYear = newAccount();
			assertEquals(thisYear.interestRate(), thisYear.nextYear().interestRate());
		}
		
		@Test
		public void withdrawingFundsOccursAtTheBeginningOfTheYear(){
			SavingsAccountYear year = new SavingsAccountYear(10000, 10);
			year.withdraw(1000);
			assertEquals(9900, year.endingBalance());
		}
		
		@Test
		public void startingPrincipal(){
			SavingsAccountYear year = new SavingsAccountYear(10000, 7000, 10);
			assertEquals("starting principal", 3000, year.startingPrincipal());
		}
		
		@Test
		public void endingPrincipal(){
			SavingsAccountYear year = new SavingsAccountYear(10000, 7000, 10);
			assertEquals("starting principal", 3000, year.startingPrincipal());
			year.withdraw(2000);
			assertEquals("ending principal", 1000, year.endingPrincipal());
		}
		
		@Test
		public void endingPrincipalNeverGoesBelowZero(){
			SavingsAccountYear year = new SavingsAccountYear(10000, 7000, 10);
			assertEquals("starting principal", 3000, year.startingPrincipal());
			year.withdraw(4000);
			assertEquals("ending principal",  0, year.endingPrincipal());
		}
		
		@Test
		public void multipleWithdrawalsInAYear(){
			// TODO
		}
		
		
		
//		@Test
//		public void withdrawingMoreThanPrincipalIncursCapitalGainsTax() {
//			SavingsAccountYear year = new SavingsAccountYear(10000, 7000, 10);
//			year.withdraw(3000);
//			assertEquals(7700, year.endingBalance());
//			year.withdraw(5000);
//			assertEquals(2000+200- (5000 *.25), year.endingBalance()); 
//		}

		private SavingsAccountYear newAccount() {
			SavingsAccountYear account = new SavingsAccountYear(10000, 10);
			return account;
		}

		
	
}
