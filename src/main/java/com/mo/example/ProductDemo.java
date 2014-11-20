package com.mo.example;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mo.example.product.service.ProductService;
import com.mo.example.to.SalesRecord;

public class ProductDemo {

	public static void main(String[] args) {
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("applicationContext.xml");
    	ProductService productService = context.getBean("ProductService", ProductService.class);
    	
    	List<SalesRecord> salesRecords = productService.getProductSales();
    	
    	//I could have used a velocity template but that would be unnecessary 
    	//over engineering for a simple assignment
		System.out.println("Product Name \t Total # Sold \t Total Amount");
		System.out.println("---------------------------------------------");		
		for (SalesRecord salesRecord: salesRecords) {
			
			System.out.println(salesRecord.getProductName() + "\t\t" + salesRecord.getCountOfSales() + "\t$" + salesRecord.getSalesAmount());
		}

    	
	}

}
