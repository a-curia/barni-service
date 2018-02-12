package com.infosys.barni.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="prod_id")
	private Long productId;

	@Column(name="prod_image_path")
	private String productImagePath;
	@Column(name="prod_name")
	private String productName;
	@Column(name="prod_description")
	private String productDescription;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cat_id")
	private Category productCategory;

	public Product() {
	}

	public Product(Long productId, String productImagePath, String productName, String productDescription,
			Category productCategory) {
		this.productId = productId;
		this.productImagePath = productImagePath;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productCategory = productCategory;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductImagePath() {
		return productImagePath;
	}

	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	public Category getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productImagePath=" + productImagePath + ", productName="
				+ productName + ", productDescription=" + productDescription + ", productCategory=" + productCategory
				+ "]";
	}
	
}