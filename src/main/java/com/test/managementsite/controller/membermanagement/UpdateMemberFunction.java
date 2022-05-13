package com.test.managementsite.controller.membermanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.managementsite.controller.ControllerFunction;
import com.test.managementsite.data.Member;
import com.test.managementsite.data.MemberForm;
import com.test.managementsite.data.UpdateMemberForm;
import com.test.managementsite.service.IMemberManager;

import lombok.RequiredArgsConstructor;
import lombok.var;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UpdateMemberFunction {

	private static final String URL = "update-member";
	private final IMemberManager memberManager;

	// * Mapping
	@GetMapping(URL)
	public String getSearchMember(
			) {
		return "member-management";
	}

	@PostMapping(URL)
	public String postSearchMember(
			Model model, 
			@ModelAttribute
			UpdateMemberForm updateMemberForm,
			BindingResult result) {
		
		// 1. check input error
		if (result.hasErrors()) {

			// print error message if has error
			var errorList = ControllerFunction.getErrorList(result);
			model.addAttribute("validationError", errorList);

			// 2. check if name is exist
		} else if (hasNotFindNameError(updateMemberForm)) {
			var errorMessage = "*入力した名前は存在していません";
			model.addAttribute("validationError", errorMessage);
		} else {
			// 3. update member if input is ok
			memberManager.updateMember(updateMemberForm);

			// 4. print member info if update success
			var updateMemberInfo = updateMemberForm.getUpdateInfoMap();
			model.addAttribute("updateResult", updateMemberInfo);
		}

		return "member-management";
	}

	private boolean hasNotFindNameError(UpdateMemberForm updateMemberForm) {
		var result = memberManager.selectMember(updateMemberForm.name()).size() == 0;
		return result;
	}

}
