package com.rupen.lab5.prog3;

public class RetirementAccount extends Account{
	
	public RetirementAccount(Employee emp, double amt) {
		super(emp, amt);
	}
	
	@Override
	public boolean makeWithdrawal(double amount) {
		double amtReduced= amount+0.02*super.getBalance();
		if(super.getBalance()>amtReduced) {
			this.setBalance(super.getBalance()-amtReduced);
			return true;
		}
		return false;
	}
	
	@Override
	public String getAcctType() {
		return "retirement";
	}
}
