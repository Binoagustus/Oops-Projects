package com.CommercialDataProcessing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StockAccount implements FinanceInstituition {

	String stockSymbol;
	String fileName;
	String formatDateTimeBuy;
	String formatDateTimeSell;
	int numOfShares;
	int sharePrice;
	int accountValue;

	ArrayList<StockDetails> stockList = new ArrayList<StockDetails>();
	HashMap<String, ArrayList<StockDetails>> stockMap = new HashMap<String, ArrayList<StockDetails>>();

	Scanner sc = new Scanner(System.in);

	public void createStockAccount(String fileName) {

		this.save(fileName);

	}

	@Override
	public double valueOf() {
		System.out.println(" Enter Account Name ");
		fileName = sc.next();
		System.out.println(" Enter Stock Symbol ");
		stockSymbol = sc.next();
		for (int i = 0; i < stockList.size(); i++) {
			if (stockList.get(i).getFileName().equalsIgnoreCase(fileName)
					&& stockList.get(i).getStockSymbol().equalsIgnoreCase(stockSymbol)) {

				accountValue = stockList.get(i).getNumOfShares() * stockList.get(i).getSharePrice();
			} else {
				System.out.println("");
			}
		}
		return accountValue;
	}

	@Override
	public void buy(int numOfShares, String stockSymbol) {

		this.stockSymbol = stockSymbol;

		LocalDateTime ldtObj = LocalDateTime.now();
		DateTimeFormatter dtfObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		System.out.println(" Enter account name to verify ");
		fileName = sc.next();

		// check if company have shares
		if (stockList.size() > 0) {
			for (int i = 0; i < stockList.size(); i++) {
				if (stockMap.containsKey(fileName) && stockList.get(i).getStockSymbol().equalsIgnoreCase(stockSymbol)
						&& stockList.get(i).getFileName().equalsIgnoreCase(fileName)) {

					this.numOfShares = stockList.get(i).getNumOfShares() + numOfShares;
					formatDateTimeBuy = ldtObj.format(dtfObj);
					stockList.get(i).setFormatDateTimeBuy(formatDateTimeBuy);
					stockList.get(i).setNumOfShares(this.numOfShares);
					System.out.println(" Bought the shares ");

				}
			}
		}
	}

	@Override
	public void sell(int numOfShares, String stockSymbol) {

		this.stockSymbol = stockSymbol;
		LocalDateTime ldtObj2 = LocalDateTime.now();
		DateTimeFormatter dtfObj2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		System.out.println(" Enter account name to verify ");
		fileName = sc.next();

		if (stockList.size() > 0) {
			for (int i = 0; i < stockList.size(); i++) {
				if (stockMap.containsKey(fileName) && stockList.get(i).getStockSymbol().equalsIgnoreCase(stockSymbol)
						&& stockList.get(i).getNumOfShares() > numOfShares
						&& stockList.get(i).getFileName().equalsIgnoreCase(fileName)) {

					this.numOfShares = stockList.get(i).getNumOfShares() - numOfShares;
					formatDateTimeSell = ldtObj2.format(dtfObj2);
					stockList.get(i).setFormatDateTimeSell(formatDateTimeSell);
					stockList.get(i).setNumOfShares(this.numOfShares);
					System.out.println(" Sold the shares ");

				}
			}
		}

	}

	@Override
	public void save(String fileName) {

		this.fileName = fileName;

		if (stockMap.containsKey(fileName)) {
			System.out.println(" Account already exist \n");
		} else {

			StockDetails mainObj = new StockDetails();

			mainObj.setFileName(fileName);

			System.out.println(" Enter Stock Symbol ");
			stockSymbol = sc.next();
			mainObj.setStockSymbol(stockSymbol);

			System.out.println(" Enter number of Shares ");
			numOfShares = sc.nextInt();
			mainObj.setNumOfShares(numOfShares);

			System.out.println(" Enter Share Price ");
			sharePrice = sc.nextInt();
			mainObj.setSharePrice(sharePrice);

			stockList.add(mainObj);

			stockMap.put(fileName, stockList);
			System.out.println(" Account created ");
		}
	}

	@Override
	public void printReport() {
		for (int i = 0; i < stockList.size(); i++) {

			System.out.println(" Stock Name : " + stockList.get(i).getFileName());
			System.out.println(" Stock Symbol : " + stockList.get(i).getStockSymbol());
			System.out.println(" Number of Shares : " + stockList.get(i).getNumOfShares());
			System.out.println(" Share Price : " + stockList.get(i).getSharePrice());
			if (stockList.get(i).getFormatDateTimeBuy() == null) {
				System.out.println(" No new Stocks bought at this moment ");
			} else {
				System.out.println(" Shares Bought Date and Time : " + stockList.get(i).getFormatDateTimeBuy());
			}
			if (stockList.get(i).getFormatDateTimeSell() == null) {
				System.out.println(" No Stocks sold at this moment \n");
			} else {
				System.out.println(" Shares Sold Date and Time : " + stockList.get(i).getFormatDateTimeSell() + "\n");
			}

		}

	}

	public static void main(String[] args) {

		StockAccount myObj = new StockAccount();
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		while (run) {
			System.out.println(" Enter 1 to create Stock Account \n Enter 2 to buy shares \n Enter 3 to sell shares "
					+ "\n Enter 4 to get value of Stock Account \n Enter 5 to print Report \n Enter 6 to Exit ");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				System.out.println(" Enter a Name to create account ");
				String fileName = sc.next();
				myObj.createStockAccount(fileName);
				break;

			case 2:
				System.out.println(" Enter Stock Symbol ");
				String stockSymbol = sc.next();
				System.out.println(" Input number of shares to buy ");
				int numOfShares = sc.nextInt();
				myObj.buy(numOfShares, stockSymbol);
				break;

			case 3:
				System.out.println(" Enter Stock Symbol ");
				stockSymbol = sc.next();
				System.out.println(" Input number of shares to sell ");
				numOfShares = sc.nextInt();
				myObj.sell(numOfShares, stockSymbol);
				break;

			case 4:
				double value = myObj.valueOf();
				System.out.println(" Value of Stock Account is " + value + " dollars ");
				break;

			case 5:
				myObj.printReport();
				break;

			case 6:
				run = false;
				break;
			}
		}
	}
}
