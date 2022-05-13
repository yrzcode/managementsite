package com.test.managementsite.controller.newmember;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.managementsite.controller.ControllerFunction;
import com.test.managementsite.data.MemberForm;
import com.test.managementsite.service.IMemberManager;

import lombok.RequiredArgsConstructor;
import lombok.var;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AddNewMemberFunction {
	
	// * Field
    private static final String URL = "add-new-member";
    private final IMemberManager memberManager;

    // * Mapping
	@GetMapping (URL)
    public String GetAddNewMember(
    		@ModelAttribute("addMemberFrom")
            MemberForm member
    ){
        return "new-member";
    }

	@PostMapping(URL)
	public String PostAddNewMember(@Validated @ModelAttribute("addMemberFrom") MemberForm memberForm,
			BindingResult result, Model model) {

		// 1. check input error
		if (result.hasErrors()) {

			// print error message if has error
			var errorList = ControllerFunction.getErrorList(result);
			model.addAttribute("validationError", errorList);

//			// 2. check if name is exist
//		} else if (hasUniqueNameError(memberForm)) {
//			var errorMessage = "*入力した名前はすでに存在しています";
//			model.addAttribute("validationError", errorMessage);
			
		} else {
			
			// 3. add new member if input is ok
			memberManager.insertMember(memberForm);

			// 4. print new member message if add new member
			var newMemberInfo = memberForm.getInsertInfoMap();
			model.addAttribute("insertResult", newMemberInfo);
		}
	
		return "new-member";
	}

	private boolean hasUniqueNameError(MemberForm memberForm) {
		var result = memberManager.selectMember(memberForm.name()).size() != 0;
		return result;
	}

}
	
