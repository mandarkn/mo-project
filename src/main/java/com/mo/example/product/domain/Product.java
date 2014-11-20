package com.mo.example.product.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@Column(name = "ProductID", unique = true, nullable = false)
	@GeneratedValue(generator = "UniqueIdGenerator")
	@GenericGenerator(name = "UniqueIdGenerator", strategy = "native", parameters = {})
	private long id;
	@Column(name = "ProductName", nullable = false)
	private String productName;
	@OneToMany
	@JoinColumn(name="ProductID")
	private Set<Sale> sales;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public Set<Sale> getSales() {
		return sales;
	}
	public void setSales(Set<Sale> sales) {
		this.sales = sales;
	}
}
