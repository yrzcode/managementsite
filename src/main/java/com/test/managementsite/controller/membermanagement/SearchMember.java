package com.test.managementsite.controller.membermanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.managementsite.data.SearchMemberForm;
import com.test.managementsite.service.IMemberManager;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SearchMember {

	private final IMemberManager memberManager;

	// * Mapping
	@GetMapping("search-member")
	public String getSearchMember() {
		return "member-management";
	}

	@PostMapping("search-member")
	public String postSearchMember(
			Model model,
			@ModelAttribute
			SearchMemberForm searchMemberForm) {

		//* search member from DB
		var hasInputAge = !searchMemberForm.age().equals("");
		var resultList = (hasInputAge)?
				memberManager.selectMember(
						searchMemberForm.name(),
						searchMemberForm.sex(),
						searchMemberForm.age()) :
				memberManager.selectMember(
						searchMemberForm.name(),
						searchMemberForm.sex());
		
		//* trans search result to front
		model.addAttribute("search_result_list", resultList);

		return "member-management";
	}
}
