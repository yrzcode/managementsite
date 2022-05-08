package com.test.managementsite.controller.membermanagement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberManagementController {

    @GetMapping("member-management")
    public String getMemberManagement(){
        return "member-management";
    }

}
