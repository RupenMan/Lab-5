package com.rupen.lab5.prog3;

public class SavingsAccount extends Account{
	private static final double INTEREST_RATE=25 ;
	public SavingsAccount(Employee emp, double bal) {
		super(emp, bal);
	}
	
	@Override
	public double readBalance() {
		this.setBalance(super.getBalance()*(1+(0.01*INTEREST_RATE)));
		return this.getBalance();
	}
	
	@Override
	public String getAcctType() {
		return "savings";
	}
}
