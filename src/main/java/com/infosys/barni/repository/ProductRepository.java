package com.infosys.barni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.barni.entity.Product;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Long>{

}