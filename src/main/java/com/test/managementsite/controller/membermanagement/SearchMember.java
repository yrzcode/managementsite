package com.test.managementsite.controller.membermanagement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.managementsite.data.SearchMemberForm;

@Controller
public class SearchMember {

	@GetMapping("search-member")
	public String getSearchMember() {
		return "member-management";
	}

	@PostMapping("search-member")
	public String postSearchMember(Model model, @ModelAttribute SearchMemberForm searchMemberForm) {

		return "member-management";
	}
}
