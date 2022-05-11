package com.test.managementsite.controller.newmember;

import org.jetbrains.annotations.NotNull;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.test.managementsite.data.MemberForm;
import com.test.managementsite.service.IMemberManager;

import lombok.var;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AddNewMember {
	
	// field
    private static final String URL = "add-new-member";
    private final IMemberManager memberManager;
    
    @Autowired
    public AddNewMember(IMemberManager memberManager) {
		this.memberManager = memberManager;
	}

    
    // mapping
	@GetMapping (URL)
    public String GetAddNewMember(
            @ModelAttribute("memberForm")
                    MemberForm member
    ){
        return "new-member";
    }

	@PostMapping(URL)
	public String PostAddNewMember(
			@Validated @ModelAttribute("memberForm") MemberForm member, 
			BindingResult result,
			@NotNull Model model) {

    	// check input error 
        if (result.hasErrors()) {
        	
        	// print error message if has error
            var errorList = getErrorList(result);
            model.addAttribute("validationError", errorList);
            
        }else {
        	
        	// add new member if input is ok
            memberManager.insertMember(member);
            
            // print new member message if add new member
            var newMemberInfo = member.getInsertInfoMap();
            model.addAttribute("insertResult", newMemberInfo);
        }
        
        return "new-member";
    }


	private List<String> getErrorList(BindingResult result) {
		List<String> errorList = new ArrayList<>();
		for (ObjectError error : result.getAllErrors()) {
			errorList.add(error.getDefaultMessage());
		}
		return errorList;
	}
}
