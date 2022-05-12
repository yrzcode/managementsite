package com.test.managementsite.controller.membermanagement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.managementsite.controller.ControllerFunction;
import com.test.managementsite.data.MemberForm;

@Controller
public class UpdateMemberForm {
	
	//* Mapping
	@GetMapping("update-member-form")
	public String getUpdateMemberForm(
			Model model,
			@ModelAttribute("updateMemberForm")
			MemberForm updateMemberForm
			){
		
		return "member-management";
	}
	
	@PostMapping("update-member-form")
	public String postUpateMemberForm(
			Model model,
			@ModelAttribute("updateMemberForm")
			MemberForm updateMemberForm
			){
		
		//* Add select search info to update form 
		model.addAttribute("updateMemberFormInfo", updateMemberForm);
		
		return "member-management";
	}
	
}
