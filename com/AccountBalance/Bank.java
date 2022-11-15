package com.AccountBalance;

import java.util.Scanner;

public class Bank extends AccountDetails {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		AccountDetails ad = new Bank();
		boolean run = true;
		while (run) {
			System.out.println("\n Enter 1 to deposit \n Enter 2 to debit \n Enter 3 to checkbalance \n Enter 4 to exit ");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				ad.deposit();
				break;

			case 2:
				ad.debit();
				break;

			case 3:
				ad.checkBalance();
				break;

			case 4:
				run = false;
				break;

			}
		}

	}

}
