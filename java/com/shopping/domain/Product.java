
package com.shopping.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="product")
public class Product {
	
	@Id
	private int id;
	private String name;
	private String description;
	private String categoryId;
	private String supplierId;
	private String price;
	
	
	@ManyToOne
	@JoinColumn(name="categoryId",insertable=false,updatable=false)
	private Category category;
	
	
	@ManyToOne
	@JoinColumn(name="supplierId",insertable=false,updatable=false,nullable=false)
	private Supplier supplier;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	

	
	
}
