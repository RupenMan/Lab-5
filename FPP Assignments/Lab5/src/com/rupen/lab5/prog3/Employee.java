package com.rupen.lab5.prog3;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Employee {

	private ArrayList<Account> accounts;
	private String name;
	private GregorianCalendar hireDate;

	public Employee(String name, int yr, int mth, int day) {
		this.name = name;
		GregorianCalendar cal = new GregorianCalendar(yr, mth - 1, day);
		this.hireDate = cal;
		this.accounts = new ArrayList<Account>();
	}

	public String getName() {
		return this.name;
	}
	
	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void createNewChecking(double startAmount) {
		accounts.add(new CheckingAccount(this, startAmount));
	}

	public void createNewSavings(double startAmount) {
		this.accounts.add(new SavingsAccount(this, startAmount));
	}

	public void createNewRetirement(double startAmount) {
		this.accounts.add(new RetirementAccount(this, startAmount));
	}

	public String deposit(String acctType, double amt) {
		if(amt < 0) {
			return "NEGATIVE BALANCE NOT ACCEPTED";
		}
		
		for (Account account : this.accounts) {
			if (acctType.equals(account.getAcctType())) {
				account.setBalance(account.getBalance() + amt);
				return String.format(
						"$%.1f has been deposited in the %s account "
						+ "of %s",amt,acctType, this.getName());
			}
		}
		return String.format("You do not have %s account. Get your cash back.", acctType);
	}

	public boolean withdraw(AccountType acctType, double amt) {
		for (Account account : this.accounts) {
			if (acctType.toString().equals(account.getAcctType())) {
				return account.makeWithdrawal(amt);
			}
		}
		return false;
	}
	
	public String readBalance() {
		return String.format("Your Account Info are:"
				+ "\n%s",this.getFormattedAccountInfo().toString());
	}
	
	//Total balance of an Employee from all accounts
	public double totalBalanceOfAnEmployee() {
		double sum=0;
		for(Account account: this.accounts) {
			sum+=account.getBalance();
		}
		return sum;
	}

	public String getFormattedAccountInfo() {
		StringBuffer accInfo = new StringBuffer();
		for (Account account : this.accounts) {
			accInfo.append(account.toString());
			accInfo.append("\n");
		}
		return accInfo.toString();
	}
}
