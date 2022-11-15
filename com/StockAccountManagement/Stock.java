package com.StockAccountManagement;

//import java.util.ArrayList;
import java.util.Scanner;

public class Stock {

	String shareName;
	int numOfShares;
	float sharePrice;
	float totalStockValue;
	float eachStockValue;

	// ArrayList<StockPortfolio> stock = new ArrayList<StockPortfolio>();
	Scanner sc = new Scanner(System.in);
	StockPortfolio stockPfObj = new StockPortfolio();

	public void addStock() {

		System.out.println("Enter Share Name ");
		shareName = sc.next();
		stockPfObj.setShareName(shareName);

		System.out.println("Enter number of shares ");
		numOfShares = sc.nextInt();
		stockPfObj.setNumOfShares(numOfShares);

		System.out.println("Enter share price ");
		sharePrice = sc.nextFloat();
		stockPfObj.setSharePrice(sharePrice);

		// stock.add(stockObj);
	}

	public void calcValueOfStock() {
		eachStockValue = stockPfObj.getNumOfShares() * stockPfObj.getSharePrice();
		stockPfObj.setEachStockValue(eachStockValue);
	}

	public void calcTotalStocks() {
		totalStockValue = stockPfObj.getTotalStockValue() + stockPfObj.getEachStockValue();
		stockPfObj.setTotalStockValue(totalStockValue);
	}

	public void displayStocks() {
		System.out.println(" Share Name : " + stockPfObj.getShareName());
		System.out.println(" Number of Shares : " + stockPfObj.getNumOfShares());
		System.out.println(" Share Price : " + stockPfObj.getSharePrice());
		System.out.println(" Stock Price : " + stockPfObj.getEachStockValue());
		System.out.println("\n Total Stock Value : " + stockPfObj.getTotalStockValue()+"\n");
		System.out.println("*****************");
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println(" Welcome to Stock Account Management ");

		System.out.println(" Input number of stocks to add ");
		int stocks = sc.nextInt();

		// array of stocks number of elements holding null values
		Stock[] stockObj = new Stock[stocks];

		// class Stock is instantiated stock number of times and stock details are added
		for (int i = 0; i < stocks; i++) {

			stockObj[i] = new Stock();
			stockObj[i].addStock();
			System.out.println("*******************");

		}

		// calculate value of each stock and total stack value
		for (int i = 0; i < stocks; i++) {

			stockObj[i].calcValueOfStock();
			stockObj[i].calcTotalStocks();
		}
		System.out.println("\n");

		// display Stock value
		for (int i = 0; i < stocks; i++) {
			stockObj[i].displayStocks();
		}
	}
}
