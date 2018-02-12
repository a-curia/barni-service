package com.infosys.barni.util;

import com.infosys.barni.entity.TraditionalProduct;

public class PayloadValidator {
	
	public static boolean validateCreatePayload(TraditionalProduct traditionalProduct){
		if (traditionalProduct.getProductId() > 0){
			return false;
		}
		return true;
	}

}