package com.infosys.barni.util;

import com.infosys.barni.entity.Product;

public class PayloadValidatorProduct {
	
	public static boolean validateCreatePayload(Product product){
		if (product.getProductId() > 0){
			return false;
		}
		return true;
	}

}