package com.StockAccountManagement;

public class StockPortfolio {

	private String shareName;
	private int numOfShares;
	private float sharePrice;
	private float totalStockValue = 0;
	private float eachStockValue;

	public float getTotalStockValue() {
		return totalStockValue;
	}

	public void setTotalStockValue(float totalStockValue) {
		this.totalStockValue = totalStockValue;
	}

	public float getEachStockValue() {
		return eachStockValue;
	}

	public void setEachStockValue(float eachStockValue) {
		this.eachStockValue = eachStockValue;
	}

	public String getShareName() {
		return shareName;
	}

	public void setShareName(String shareName) {
		this.shareName = shareName;
	}

	public int getNumOfShares() {
		return numOfShares;
	}

	public void setNumOfShares(int numOfShares) {
		this.numOfShares = numOfShares;
	}

	public float getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(float sharePrice) {
		this.sharePrice = sharePrice;
	}

}
