package com.rupen.lab5.prog3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	ArrayList<Employee> emps = new ArrayList<Employee>();

	public static void main(String[] args) {
		new Main();
	}

	Main() {
		// Enlist all the employees and their accounts
		Employee e1 = new Employee("Jim Daley", 2000, 9, 4);
		e1.createNewChecking(10500);
		e1.createNewRetirement(9300);
		e1.createNewSavings(1000);

		Employee e2 = new Employee("Bob Reuben", 1998, 1, 5);
		e2.createNewChecking(34000);
		e2.createNewSavings(27000);

		Employee e3 = new Employee("Susan Randolph", 1997, 2, 13);
		e3.createNewChecking(10038);
		e3.createNewSavings(12600);
		e3.createNewRetirement(9000);

		emps.add(e1);
		emps.add(e2);
		emps.add(e3);
		

		// for phase I – console output
		Scanner sc = new Scanner(System.in);

		// Display the options that a customer can use
		System.out.println("A. See a report of all accounts.\n" + "B. Make a deposit.\n" + "C. Make a withdrawal.\n"
				+ "Make a selection (A/B/C):");
		String answer = sc.next();

		if (answer.equalsIgnoreCase("A")) {
			String info = getFormattedAccountInfo();
			System.out.print(info.toString());
			System.out.println("--------------------------");
			// Generate total of all Balances
			System.out.printf("Grand Total: $%,.2f", totalOfAllBalances());
		}
		// Process for Deposit
		else if (answer.equalsIgnoreCase("B")) {
			int employeeNumber = getEmployeeNumberFromUser();
			int accountType = getAccountTypeFromUser();
			System.out.println("Deposit Amount:");
			double deposit = sc.nextDouble();
			System.out.println(emps.get(employeeNumber).deposit(AccountType.values()[accountType].toString(), deposit));
		}
		// Process for Withdrawal
		else if (answer.equalsIgnoreCase("C")) {
			int employeeNumber = getEmployeeNumberFromUser();
			int accountType = getAccountTypeFromUser();
			System.out.println("Withdrawal Amount: ");
			double withdrawalAmount = sc.nextDouble();
			if (emps.get(employeeNumber).withdraw(AccountType.values()[accountType], withdrawalAmount)) {
				System.out.println("Receive your cash: " + withdrawalAmount);
			} else {
				System.out.println("INSUFFICIENT FUND");
			}
		} 
		// Information on unavailability of option 
		else {
			System.out.println("OPTION NOT AVAILABLE");
		}
	}

	// Selects name of the employee
	public int getEmployeeNumberFromUser() {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < emps.size(); ++i) {
			if (emps.get(i) != null) {
				System.out.println(i + ". " + emps.get(i).getName());
			}
		}
		System.out.println("Select an employee: (type a number)");
		int employeeNumber = sc.nextInt();
		return employeeNumber;
	}

	// Selects type of account
	public int getAccountTypeFromUser() {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < AccountType.values().length; ++i) {
			System.out.println(i + ". " + AccountType.values()[i].toString());
		}
		System.out.println("Select an account: (type a number)");
		int accountType = sc.nextInt();
		return accountType;
	}

	// Calculates grand total
	public double totalOfAllBalances() {
		double totalOfAllAccounts = 0;
		for (Employee emp : emps) {
			totalOfAllAccounts += emp.totalBalanceOfAnEmployee();
		}
		return totalOfAllAccounts;
	}
	
	String getFormattedAccountInfo() {
		StringBuffer formattedOutput = new StringBuffer();
		for (Employee emp : emps) {
			String nameOfEmployee = "ACCOUNT INFO FOR " + emp.getName() + ":";
			formattedOutput.append(nameOfEmployee);
			formattedOutput.append("\n");
			formattedOutput.append(emp.getFormattedAccountInfo());
			formattedOutput.append('\n');
		}
		return formattedOutput.toString();
	}

}
