package com.shopping.dao;

import java.util.List;

import com.shopping.domain.Invoice;

public interface InvoiceDao {
	
	public boolean save(Invoice invoice);
	
	
	public Invoice select(int orderId);
	
	public boolean update(Invoice invoice);
	
	public boolean delete(int orderId);
	
	public List<Invoice> getAll();

}
