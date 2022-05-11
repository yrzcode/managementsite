package com.test.managementsite.controller.membermanagement;

import com.test.managementsite.service.IMemberManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.managementsite.data.SearchMemberForm;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SearchMember {

	private final IMemberManager memberManager;

	@GetMapping("search-member")
	public String getSearchMember() {
		return "member-management";
	}

	@PostMapping("search-member")
	public String postSearchMember(
			Model model,
			@ModelAttribute
			SearchMemberForm searchMemberForm) {

		//select member from DB
		var hasInputAge = !searchMemberForm.age().equals("");
		var resultList = (hasInputAge)?
				memberManager.selectMember(searchMemberForm.name(),searchMemberForm.age()) :
				memberManager.selectMember(searchMemberForm.name());


		return "member-management";
	}
}
