package com.test.managementsite.controller.newmember;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewMemberController {

    @GetMapping("new-member")
    public String getNewMember(
    ){
        return "new-member";
    }

}
