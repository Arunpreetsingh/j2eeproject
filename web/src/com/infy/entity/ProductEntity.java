package com.infy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;




@Entity
@Table(name="infyretail_product")
@GenericGenerator(name="PRODUCT_SEQ", strategy="sequence",
parameters={@Parameter(name="sequence",value="INFYRETAIL_PRODUCT_SEQ")})
public class ProductEntity {
	@Id
	@Column(name="product_id")
	
	@GeneratedValue(generator="PRODUCT_SEQ")
	private Integer productId;
	@Column(name="product_name")
	private String name;
	@Column(name="product_category")
	private String category;
	@Column(name="product_brand")
	private String brand;
	@Column(name="product_cost")
	private Double cost;
	@Column(name="product_quantity")
	private Integer quantity;
	@Column(name="product_discount")
	private Double discount;
	@Column(name="product_sellingprice")
	private Double sellingPrice;
	@Column(name="product_specification")
	private String specification;
	@Column(name="product_supplier_id")
	private String supplierId;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
}
