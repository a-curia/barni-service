package com.infosys.barni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.barni.entity.TraditionalProduct;

@Repository("traditionalProductRepository")
public interface TraditionalProductRepository extends JpaRepository<TraditionalProduct, Long>{

}