package com.mo.example.product.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mo.example.product.domain.Product;
import com.mo.example.product.service.ProductService;
import com.mo.example.to.SalesRecord;

@Component("ProductService")
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<SalesRecord> getProductSales() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
		criteria.createAlias("sales", "s")
		        .setProjection(Projections.projectionList()
		        		.add(Projections.property("productName"))
		        		.add(Projections.count("sales"))
			            .add(Projections.sum("s.amount"))
			            .add(Projections.groupProperty("id")));
		
	@SuppressWarnings("unchecked")
	List<Object> sales =  criteria.list();
	List<SalesRecord> salesRecords = new ArrayList<SalesRecord>();
	
	for (Object object: sales) {
		Object[] salesItem = (Object[]) object;
		SalesRecord salesRecord = new SalesRecord();
		salesRecord.setProductName((String)salesItem[0]);
		salesRecord.setCountOfSales((Long)salesItem[1]);
		salesRecord.setSalesAmount((Double)salesItem[2]);
		salesRecords.add(salesRecord);
		}
	
		return salesRecords;
	}
}
