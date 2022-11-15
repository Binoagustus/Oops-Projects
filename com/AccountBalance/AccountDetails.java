package com.AccountBalance;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AccountDetails {
	private String accountName;
	private float balance;
	private float amount;

	HashMap<String, Float> account = new HashMap<String, Float>();
	Scanner sc = new Scanner(System.in);

	public void deposit() {

		System.out.println(" Enter the amount to be deposited");
		amount = sc.nextFloat();
		balance = balance + amount;
		System.out.println(" Enter account name");
		accountName = sc.next();
		if (account.containsKey(accountName)) {
			account.put(accountName, balance);
			System.out.println(" Amount credited to "+accountName);
		} else {
			account.put(accountName, balance);
			System.out.println(" Account is created ");
		}
	}

	public void checkBalance() {
		for (Map.Entry<String, Float> mapName : account.entrySet()) {
			System.out.println(" Account Name " + mapName.getKey() + "\n Available Balance " + mapName.getValue());
		}
	}

	public void debit() {
		System.out.println("\n Enter account name to debit ");
		accountName = sc.next();
		if (account.containsKey(accountName)) {

			System.out.println(" Enter amount to be debited ");
			amount = sc.nextFloat();
			balance = account.get(accountName);

			if (amount > balance) {
				System.out.println(" Insufficient balance ");
			} else if (amount <= balance) {
				balance = balance - amount;
				System.out.println(" Amount debited ");
				account.put(accountName, balance);
			}
		} else {
			System.out.println(" No account found with name "+accountName);
		}
	}
}
