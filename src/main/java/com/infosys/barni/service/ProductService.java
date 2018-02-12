package com.infosys.barni.service;

import java.util.List;

import com.infosys.barni.entity.Product;

public interface ProductService {
	public List<Product> getAllProduct();
	public Product getProductById(long id);
	public Product saveProduct(Product product);
	public void removeProduct(Product product);
}