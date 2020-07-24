package com.wyc.web.admin;

import com.wyc.service.UserService;
import com.wyc.sms.IndustrySMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
@RequestMapping("/send")
public class YzmController {
    @Autowired
    UserService userService;
    @RequestMapping("sz")
    @ResponseBody
    public String sz(String password1,String password2, HttpServletRequest request){
      String msg=null;
      if (password1.equals(password2)){
          int i = userService.updatePassword(password1);
          System.out.println("更新记录数"+i);
          if(i==1){
              msg="success";
          }else {
              msg="更新密码失败";
          }
      }else {
          msg="你两次输入的密码不一致";
      }
        return msg;
    }

    @RequestMapping("wj")
    @ResponseBody
    public String wj(String number,String username, HttpServletRequest request){
        String s = userService.selectPhone(username);
        String msg;
        if (number.equals(s)){
          String  code = "" + (int) ((Math.random()) * 1000000);
          request.getSession().setAttribute("code",code);
           msg= IndustrySMS.getRequest2(s,code);
        }else {
            msg="此号码不是你所绑定的号码";
        }
        return msg;
    }
    @RequestMapping("yz")
    @ResponseBody
    public String yz(String yzm,  HttpServletRequest request,RedirectAttributes model){
        String msg=null;
        String code=null;
        System.out.println(yzm);
        try {
            code = (String) request.getSession().getAttribute("code");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(code==null){
            msg="您还未获取验证码";
            model.addFlashAttribute("message",msg);
            return msg;
        }
        System.out.println(code);
        if(yzm.equals(code)&&!yzm.isEmpty()){
            msg="success";
            request.getSession().setAttribute("check",true);
            return msg;
        }else {
            msg="你的验证码错误";
            model.addFlashAttribute("message",msg);
            return msg;
        }


    }
}
