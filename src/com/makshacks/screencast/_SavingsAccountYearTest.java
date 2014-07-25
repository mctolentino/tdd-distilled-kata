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
			assertEquals(11000, newAccount().endingBalance(25));
		}
		
		@Test
		public void nextYearStartingBalanceEqualsThisYearsEndingBalance(){
			SavingsAccountYear account = newAccount();
			assertEquals(account.endingBalance(25), newAccount().nextYear(25).startingBalance());
		}
		
		@Test
		public void nextYearsInterestRateEqualsThisYearsInterestRate(){
			SavingsAccountYear thisYear = newAccount();
			assertEquals(thisYear.interestRate(), thisYear.nextYear(25).interestRate());
		}
		
		@Test
		public void withdrawingFundsOccursAtTheBeginningOfTheYear(){
			SavingsAccountYear year = new SavingsAccountYear(10000, 10);
			year.withdraw(1000);
			assertEquals(9900, year.endingBalance(25));
		}
		
		@Test
		public void startingPrincipal(){
			SavingsAccountYear year = new SavingsAccountYear(10000, 3000, 10);
			assertEquals("starting principal", 3000, year.startingPrincipal());
		}
		
		@Test
		public void endingPrincipal(){
			SavingsAccountYear year = new SavingsAccountYear(10000, 3000, 10);
			year.withdraw(2000);
			assertEquals("ending principal", 1000, year.endingPrincipal());
		}
		
		@Test
		public void endingPrincipalNeverGoesBelowZero(){
			SavingsAccountYear year = new SavingsAccountYear(10000, 3000, 10);
			year.withdraw(4000);
			assertEquals("ending principal",  0, year.endingPrincipal());
		}
		
		@Test
		public void multipleWithdrawalsInAYear(){
			SavingsAccountYear year = new SavingsAccountYear(10000, 10);
			year.withdraw(1000);
			year.withdraw(2000);
			assertEquals(3000, year.totalWithdrawn());
		}
		
		@Test
		public void capitalGainsWithdrawn() {
			SavingsAccountYear year = new SavingsAccountYear(10000, 3000, 10);
 			year.withdraw(1000);
			assertEquals(0, year.capitalGainsWithdrawn());
			year.withdraw(3000);
			assertEquals(1000, year.capitalGainsWithdrawn());
		}
		
		@Test
		public void capitalGainsTaxIncurred(){
			SavingsAccountYear year = new SavingsAccountYear(10000, 3000, 10);
	 		year.withdraw(5000);
	 		assertEquals(2000, year.capitalGainsWithdrawn());
	 		assertEquals(666, year.capitalGainsTaxIncurred(25));
		}
		
		@Test
		public void capitalGainsTaxIncurred_NeedsToCoverCapitalGainsWithdrawn_AND_theAdditionalCapitalGainsWithdrawnToPayCapitalGainsTax(){
			SavingsAccountYear year = new SavingsAccountYear(10000, 3000, 10);
			year.withdraw(5000);
			assertEquals(2000, year.capitalGainsWithdrawn());
			assertEquals(666, year.capitalGainsTaxIncurred(25));
			
		}
		
		@Test
		public void capitalGainsTaxIsIncludedInEndingBalance(){
			SavingsAccountYear year = new SavingsAccountYear(10000, 3000, 10);
	 		year.withdraw(5000);
	 		assertEquals(2000, year.capitalGainsWithdrawn());
	 		assertEquals(666, year.capitalGainsTaxIncurred(25));
	 		int expectedStartingBalanceAfterWithdrawals = 10000 - 5000 - 666;
	 		assertEquals((int)(expectedStartingBalanceAfterWithdrawals * 1.10), year.endingBalance(25));
			
		}
		
		private SavingsAccountYear newAccount() {
			SavingsAccountYear account = new SavingsAccountYear(10000, 10);
			return account;
		}

		
	
}
