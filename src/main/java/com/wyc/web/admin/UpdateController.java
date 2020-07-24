package com.wyc.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class UpdateController {

    @RequestMapping("xg1")
    public String update() {
        return "admin/update";
    }
    @RequestMapping("xg2")
    public String update2() {
        return "admin/update2";
    }
    @RequestMapping("xg3")
    public String update3() {
        return "admin/update3";
    }
}
