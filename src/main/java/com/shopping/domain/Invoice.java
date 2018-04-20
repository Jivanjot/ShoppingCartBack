package com.shopping.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="invoice")
public class Invoice {

	@Id

	private int orderId;
	private long invoiceId;
	private String products;
	private Timestamp orderDate;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getProducts() {
		return products;
	}
	public void setProducts(String products) {
		this.products = products;
	}
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate() {
		 this.orderDate=new Timestamp(System.currentTimeMillis());	}
	
	public long getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}
	
	
	
	
}
