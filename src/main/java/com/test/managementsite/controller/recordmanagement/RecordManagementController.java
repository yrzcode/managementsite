package com.test.managementsite.controller.recordmanagement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecordManagementController {

    @GetMapping("record-management")
    public String getRecordManagement(Model model){
        return "record-management";
    }

}
