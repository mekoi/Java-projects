package com.spring.mvc.jpa;

import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Product{
	@Id
	private int productId;		
	private String brandName;
	private String modelName;				
	private double price;
	
	//getters and setters
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}						
}
	

