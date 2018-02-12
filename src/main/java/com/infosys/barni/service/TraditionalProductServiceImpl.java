package com.infosys.barni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.barni.entity.TraditionalProduct;
import com.infosys.barni.repository.TraditionalProductRepository;


@Service("traditionalProductService")
public class TraditionalProductServiceImpl implements TraditionalProductService{

	@Autowired
	private TraditionalProductRepository traditionalProductRepository;
	
	@Override
	public List<TraditionalProduct> getAllTraditionalProduct() {
		return traditionalProductRepository.findAll();
	}

	@Override
	public TraditionalProduct getTraditionalProductById(long id) {
		return traditionalProductRepository.findOne(id);
	}

	@Override
	public TraditionalProduct saveTraditionalProduct(TraditionalProduct traditionalProduct) {
		return traditionalProductRepository.save(traditionalProduct);
	}

	@Override
	public void removeTraditionalProduct(TraditionalProduct traditionalProduct) {
		traditionalProductRepository.delete(traditionalProduct);
	}
	

}