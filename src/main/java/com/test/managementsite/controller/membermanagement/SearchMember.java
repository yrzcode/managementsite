package com.test.managementsite.controller.membermanagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchMember {

	@GetMapping("search-member")
	public String getSearchMember(){
		return "member-management";
	}
	
	@PostMapping("search-member")
	public String postSearchMember(){
		return "member-management";
	}
}
