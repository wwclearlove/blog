package com.wyc.web.admin;


import com.wyc.model.User;
import com.wyc.service.BlogService;
import com.wyc.service.UserService;
import com.wyc.service.YlService;
import com.wyc.util.CodeUtil;
import com.wyc.util.MD5Utils;
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
public class LoginController {


    @Autowired
    private UserService userService;
    @Autowired
    private BlogService blogService;
    @Autowired
    private YlService ylService;
    @GetMapping
    public String loginPage() {
        return "admin/login";
    }

    @GetMapping("/footer/newblog")
    public String newblogs(Model model) {
        model.addAttribute("newblogs", blogService.listRecommendBlogTop(3));
        return "admin/_fragments :: newblogList";
    }
    @GetMapping("/footer/yl")
    public String yls(Model model) {
        model.addAttribute("yls", ylService.listYlTop(3));
        return "admin/_fragments :: ylList";
    }
    @PostMapping("/login")
    public String login(HttpServletRequest request, @RequestParam String username,
                        @RequestParam String password, HttpSession session, RedirectAttributes attributes) {
        if (! CodeUtil.checkVerifyCode(request)) {
            attributes.addFlashAttribute("message", "验证码错误");
            return "redirect:/admin";
        } else {
            User user = userService.checkUser(username, password);
            if (user != null) {
                user.setPassword(null);
                session.setAttribute("user", user);
                return "admin/index";
            } else {
                attributes.addFlashAttribute("message", "用户名或密码错误");
                return "redirect:/admin";
            }
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
