package com.stockticker.model;

public class StockData {
private String companyName;
private double price, change;
private boolean isProfit;
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public double getChange() {
	return change;
}
public void setChange(double change) {
	this.change = change;
}
public boolean isProfit() {
	return isProfit;
}
public void setProfit(boolean isProfit) {
	this.isProfit = isProfit;
}
public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}


}
