package com.infosys.barni.util;

import com.infosys.barni.entity.User;

public class PayloadValidatorUser {
	
	public static boolean validateCreatePayload(User user){
		if (user.getId() > 0){
			return false;
		}
		return true;
	}

}