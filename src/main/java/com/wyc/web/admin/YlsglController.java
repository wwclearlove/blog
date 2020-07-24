package com.wyc.web.admin;

import com.wyc.model.Photo;
import com.wyc.model.Yl;
import com.wyc.service.PhotoService;
import com.wyc.service.YlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class YlsglController {

    @Autowired
    private YlService ylService;

    @GetMapping("/yls")
    public String yls(@PageableDefault(size = 6,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        model.addAttribute("page",ylService.listYl(pageable));
        return "admin/Yls";
    }
    @GetMapping("/yls/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes) {
        ylService.deletePh(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/yls";
    }
    @GetMapping("/yls/input")
    public String input(Model model) {
        model.addAttribute("yl", new Yl());
        return "admin/yls-input";
    }

    @GetMapping("/yls/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("yl", ylService.getYl(id));
        return "admin/yls-input";
    }
    @PostMapping("/yls")
    public String post(@Valid Yl yl, RedirectAttributes attributes) {

        Yl yl1 = ylService.saveYl(yl);
        if (yl1 == null ) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/yls";
    }

    @PostMapping("/yls/{id}")
    public String editPost(@Valid Yl yl, @PathVariable Long id, RedirectAttributes attributes) {
        Yl yl1 = ylService.updateYl(id, yl);
        if (yl1 == null ) {
            attributes.addFlashAttribute("message", "更新失败");
        } else {
            attributes.addFlashAttribute("message", "更新成功");
        }
        return "redirect:/admin/yls";
    }


}
