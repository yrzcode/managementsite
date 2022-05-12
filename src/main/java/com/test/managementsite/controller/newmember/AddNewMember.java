package com.test.managementsite.controller.newmember;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.test.managementsite.controller.ControllerFunction;
import com.test.managementsite.data.MemberForm;
import com.test.managementsite.service.IMemberManager;

import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AddNewMember {
	
	// * Field
    private static final String URL = "add-new-member";
    private final IMemberManager memberManager;

    // * Mapping
	@GetMapping (URL)
    public String GetAddNewMember(
    		@ModelAttribute("memberForm")
            MemberForm member
    ){
        return "new-member";
    }

	@PostMapping(URL)
	public String PostAddNewMember(
			@Validated @ModelAttribute("update-member-form") MemberForm memberForm,
			BindingResult result,
			Model model) {

    	// 1. check input error 
        if (result.hasErrors()) {
        	
        	// print error message if has error
            var errorList = ControllerFunction.getErrorList(result);
            model.addAttribute("validationError", errorList);
            
        }else {
        	
        	// 2. add new member if input is ok
            memberManager.insertMember(memberForm);
            
            // 3. print new member message if add new member
            var newMemberInfo = memberForm.getInsertInfoMap();
            model.addAttribute("insertResult", newMemberInfo);
        }
        
        return "new-member";
    }

}
