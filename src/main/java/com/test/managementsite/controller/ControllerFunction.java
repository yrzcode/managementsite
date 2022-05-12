package com.test.managementsite.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public final class ControllerFunction {
	
public static List<String> getErrorList(BindingResult result) {
		List<String> errorList = new ArrayList<>();
		for (ObjectError error : result.getAllErrors()) {
			errorList.add(error.getDefaultMessage());
		}
		return errorList;
	}

}
