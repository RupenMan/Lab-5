package com.rupen.lab5.prog3;

public class CheckingAccount extends Account {

	public CheckingAccount(Employee emp, double balance) {
		super(emp, balance);
	}

	@Override
	public double readBalance() {
		this.setBalance(super.getBalance() - 5);
		return this.getBalance();
	}

	@Override
	public String getAcctType() {
		return "checking";
	}
}
