package com.test.managementsite.controller.newrecord;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewRecordController {

    @GetMapping("new-record")
    public String getNewRecord(Model model){
        return "new-record";
    }

}
