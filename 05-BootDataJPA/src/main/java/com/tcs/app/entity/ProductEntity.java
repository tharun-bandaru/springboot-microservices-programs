package com.tcs.app.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table( name="PROD_TBL")
@NamedQuery(name="ProductEntity.getProductsByQuantity", 
query="FROM ProductEntity p where p.quantity=?1")


public class ProductEntity {

	@Id
	@Column( name="PRODUT_ID")
	private Integer productId;
	
	@Column( name="PRODUCT_NAME" )
	private String productName;
	
	@Column( name="QUANTITY")
	private Integer quantity;
	
	@Column( name="UNITPRICE" )
	private Double unitprice;
	
	@Column( name="CREATED_ON")
	@CurrentTimestamp
	private LocalDateTime createOn;
	
	@Column( name="UPDATED_ON")
	@UpdateTimestamp
	private LocalDateTime updatedOn;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}

	public LocalDateTime getCreateOn() {
		return createOn;
	}

	public void setCreateOn(LocalDateTime createOn) {
		this.createOn = createOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "ProductEntity [productId=" + productId + ", productName=" + productName + ", quantity=" + quantity
				+ ", unitprice=" + unitprice + ", createOn=" + createOn + ", updatedOn=" + updatedOn + "]";
	}
	
	
}
