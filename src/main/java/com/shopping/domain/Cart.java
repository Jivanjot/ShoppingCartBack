package com.shopping.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="cart")
public class Cart {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String email;
private String productname;
private int price;
private int quantity;
private String productId;
private String supplierId;
private char status;
@Transient
private int total;








@Override
public String toString() {
	return "Cart [id=" + id + ", email=" + email + ", productname=" + productname + ", price=" + price + ", quantity="
			+ quantity + ", productId=" + productId + ", supplierId=" + supplierId + ", status=" + status + ", total="
			+ total + "]";
}



public String getSupplierId() {
	return supplierId;
}



public void setSupplierId(String supplierId) {
	this.supplierId = supplierId;
}



public char getStatus() {
	return status;
}
public void setStatus() {
	this.status = 'N';
}
public String getProductId() {
	return productId;
}
public void setProductId(String productId) {
	this.productId = productId;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
	


}
