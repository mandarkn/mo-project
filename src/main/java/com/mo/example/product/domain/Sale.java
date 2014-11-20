package com.mo.example.product.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "salesentry")
public class Sale {
	@Id
	@Column(name = "SalesId", unique = true, nullable = false)
	@GeneratedValue(generator = "UniqueIdGenerator")
	@GenericGenerator(name = "UniqueIdGenerator", strategy = "native", parameters = {})
	private long id;
	@Column(name = "DateOfSale", nullable = false)	
	private Date dateOfSale;
	@Column(name = "ProductID", nullable = false)
	private long productId;
	@Column(name = "SaleAmount", nullable = false)
	private Double amount;
		
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public Date getDateOfSale() {
		return dateOfSale;
	}
	public void setDateOfSale(Date dateOfSale) {
		this.dateOfSale = dateOfSale;
	}
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
