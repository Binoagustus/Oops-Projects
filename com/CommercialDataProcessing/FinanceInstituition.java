package com.CommercialDataProcessing;

public interface FinanceInstituition {
	
	public void createStockAccount(String fileName);
	
	public double valueOf();

	public void buy(int amount, String symbol);

	public void sell(int amount, String symbol);

	public void save(String fileName);

	public void printReport();

}
