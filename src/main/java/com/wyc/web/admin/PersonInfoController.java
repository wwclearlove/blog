package com.wyc.web.admin;


import com.wyc.model.User;
import com.wyc.service.UserService;
import com.wyc.util.CodeUtil;
import com.wyc.vo.UserQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;


@Controller
@RequestMapping("/admin")
public class PersonInfoController {


    @Autowired
    private UserService userService;

    @GetMapping("/changezi")
    public String changezi(Model model) {
        User user = userService.selectUser("admin");
        model.addAttribute("userinfo",user);
        System.out.println(user.getPhone());
        return "admin/personinfo";
    }
    @PostMapping ("/changeinfo")
    public String changeinfo(User user, Model model, HttpSession session) {
        System.out.println(user.toString());
        int i = userService.updateUser(user);
        if (i==1){
            User user1 = userService.selectUser("admin");
            user1.setPassword(null);
            model.addAttribute("userinfo",user1);
            session.setAttribute("user", user1);
            model.addAttribute("message","修改成功");
        }else {
            model.addAttribute("message","修改失败");
        }
        return "admin/personinfo";
    }

}
