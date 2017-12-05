package com.rupen.lab5.prog3;

public enum AccountType {
	CHECKING ("checking"),
	SAVINGS ("savings"),
	RETIREMENT("retirement");
	
	private String acctType;
	
	private AccountType(String acctType) {
		this.acctType=acctType;
	}
	
	@Override
	public String toString() {
		return this.acctType;
	}
}
