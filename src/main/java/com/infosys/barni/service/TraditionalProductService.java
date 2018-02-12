package com.infosys.barni.service;

import java.util.List;

import com.infosys.barni.entity.TraditionalProduct;

public interface TraditionalProductService {
	public List<TraditionalProduct> getAllTraditionalProduct();
	public TraditionalProduct getTraditionalProductById(long id);
	public TraditionalProduct saveTraditionalProduct(TraditionalProduct traditionalProduct);
	public void removeTraditionalProduct(TraditionalProduct traditionalProduct);
}