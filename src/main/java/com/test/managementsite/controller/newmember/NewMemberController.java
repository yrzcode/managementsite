package com.test.managementsite.controller.newmember;

import com.test.managementsite.data.MemberForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.Valid;

@Controller
public class NewMemberController {

    @GetMapping("new-member")
    public String getNewMember(
//            @ModelAttribute("memberForm") @Valid
//            MemberForm member,
//            BindingResult bindingResult,
//            Model model
    ){
//        model.addAttribute("member",member);
//        System.out.println(bindingResult);
        return "new-member";
    }

}
