/*
 * Purpose: Models the account
 * Author: Rupendra Maharjan
 * Date: December 1, 2017
 * Lab No: 5
 * Program No: 3
 */

package com.rupen.lab5.prog3;

public class Account {
	private final static double DEFAULT_BALANCE = 0.0;
	private double balance;
	private Employee employee;

	public Account(Employee emp, double balance) {
		this.employee = emp;
		this.balance = balance;
	}

	public Account(Employee emp) {
		this.employee = emp;
		this.balance = Account.DEFAULT_BALANCE;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double bal) {
		this.balance = bal;
	}

	public void makeDeposit(double amt) {
		this.balance += amt;
	}

	public boolean makeWithdrawal(double amt) {
		if (balance >= amt) {
			balance -= amt;
			return true;
		}
			return false;
	}

	//User reads the balance (Overriden by child classes)
	public double readBalance() {
		return 0.0;
	}

	public String getAcctType() {
		return "N/A";
	}

	public String toString() {
		return String.format("Account Type: %s\n" + "Current bal:  $%,.2f", this.getAcctType(), balance);
	}
}
