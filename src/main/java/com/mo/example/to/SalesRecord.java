package com.mo.example.to;

public class SalesRecord {
	private String productName;
	private Long countOfSales;
	private Double salesAmount;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getCountOfSales() {
		return countOfSales;
	}
	public void setCountOfSales(Long countOfSales) {
		this.countOfSales = countOfSales;
	}
	public Double getSalesAmount() {
		return salesAmount;
	}
	public void setSalesAmount(Double salesAmount) {
		this.salesAmount = salesAmount;
	}

}
