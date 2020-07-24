package com.wyc.web.admin;


import com.wyc.model.User;
import com.wyc.service.UserService;
import com.wyc.util.CodeUtil;
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


@Controller
@RequestMapping("/admin")
public class ChangeController {

    @Autowired
    private UserService userService;

    @GetMapping("/changepwd")
    public String changePwd() {
        return "admin/changepwd";
    }
    @PostMapping("/change")
    public String change( String username, String password,
                          String newpassword1, String newpassword2,
                         HttpSession session, Model attributes) {
        System.out.println(username);
        System.out.println(password);
        System.out.println(newpassword1);
        System.out.println(newpassword2);
        if(newpassword1.equals(newpassword2)){
            User user = userService.checkUser(username, password);
            if (user != null) {
                int i = userService.updatePassword(newpassword1);
                if(i==1){
                    session.removeAttribute("user");
                    return "redirect:/admin";
                }else {
                    attributes.addAttribute("message", "修改密码失败");
                    return "admin/changepwd";
                }

            } else {
                attributes.addAttribute("message", "您输入的原密码错误");
                return "admin/changepwd";
            }
        }else {
            attributes.addAttribute("message","你两次输入的新密码不一致");
        }
        return "admin/changepwd";
    }
}
