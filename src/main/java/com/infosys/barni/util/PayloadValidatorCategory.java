package com.infosys.barni.util;

import com.infosys.barni.entity.Category;

public class PayloadValidatorCategory {
	
	public static boolean validateCreatePayload(Category category){
		if (category.getCategoryId() > 0){
			return false;
		}
		return true;
	}

}