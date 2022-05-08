package com.test.managementsite.controller.newmember;

import org.jetbrains.annotations.NotNull;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.test.managementsite.data.MemberForm;
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

    private static final String URL = "add-new-member";

    @GetMapping (URL)
    public String GetAddNewMember(
            @ModelAttribute("memberForm")
                    MemberForm member
    ){
        return "new-member";
    }

    @PostMapping(URL)
    public String PostAddNewMember(
            @Validated
            @ModelAttribute("memberForm")
                    MemberForm member,
                    BindingResult result,
            @NotNull
                    Model model
    ){


        if (result.hasErrors()) {
            List<String> errorList = new ArrayList<>();
            for (ObjectError error : result.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
            }
            model.addAttribute("validationError", errorList);
        }

        System.out.println(member);
        System.out.println(result);


        return "new-member";
    }
}
