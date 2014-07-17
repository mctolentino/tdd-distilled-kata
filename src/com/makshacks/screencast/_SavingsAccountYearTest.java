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
		

		private SavingsAccountYear newAccount() {
			SavingsAccountYear account = new SavingsAccountYear(10000, 10);
			return account;
		}

		
	
}
