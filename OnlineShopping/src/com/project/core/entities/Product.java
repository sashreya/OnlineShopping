package com.project.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(scopeName="prototype")
@Entity(name="prods")
@Table(name="prods")
public class Product {
	@Id
	@Column(name="PRODUCTID")
	private int productId;
	@Column(name="PRODUCTNAME")
	private String productName;
	@Column(name="BRAND")
	private String brand;
	@Column(name="PRODUCTPRICE")
	private long productPrice;
	@Column(name="PRODUCTDESC")
	private String productDesc;
	@Column(name="CATEGORY")
	private String category;
	@Column(name="PRODUCTSTATUS")
	private String productStatus;
	@Column(name="QUANTITY")
	private int quantity;
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public long getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Product(int productId, String productName, String brand, long productPrice, String productDesc,
			String category, String productStatus, int quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.brand = brand;
		this.productPrice = productPrice;
		this.productDesc = productDesc;
		this.category = category;
		this.productStatus = productStatus;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", brand=" + brand
				+ ", productPrice=" + productPrice + ", productDesc=" + productDesc + ", category=" + category
				+ ", productStatus=" + productStatus + ", quantity=" + quantity + "]";
	}
}
