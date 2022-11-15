package com.CommercialDataProcessing;

public class StockDetails {

	private String stockSymbol;
	private String fileName;
	private String formatDateTimeBuy;
	private String formatDateTimeSell;
	private int numOfShares;
	private int sharePrice;

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public int getNumOfShares() {
		return numOfShares;
	}

	public void setNumOfShares(int numOfShares) {
		this.numOfShares = numOfShares;
	}

	public int getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(int sharePrice) {
		this.sharePrice = sharePrice;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFormatDateTimeBuy() {
		return formatDateTimeBuy;
	}

	public void setFormatDateTimeBuy(String formatDateTimeBuy) {
		this.formatDateTimeBuy = formatDateTimeBuy;
	}

	public String getFormatDateTimeSell() {
		return formatDateTimeSell;
	}

	public void setFormatDateTimeSell(String formatDateTimeSell) {
		this.formatDateTimeSell = formatDateTimeSell;
	}

	@Override
	public String toString() {
		return "StockDetails [stockSymbol=" + stockSymbol + ", fileName=" + fileName + ", formatDateTimeBuy="
				+ formatDateTimeBuy + ", formatDateTimeSell=" + formatDateTimeSell + ", numOfShares=" + numOfShares
				+ ", sharePrice=" + sharePrice + "]";
	}
	
	

}
