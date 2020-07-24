package com.wyc.web.admin;

import com.wyc.model.Photo;
import com.wyc.model.Tag;
import com.wyc.service.PhotoService;
import com.wyc.util.HandleUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class PhotoglController {

    @Autowired
    private PhotoService photoService;
    @Autowired
    private HandleUpload handleUpload;
    @Value("${path.fileurl}")
    private String fileServer;
    @GetMapping("/photos")
    public String comment(@PageableDefault(size = 6,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        model.addAttribute("page",photoService.listPhoto(pageable));
        return "admin/photos";
    }
    @GetMapping("/photos/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes) {
        photoService.deletePh(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/photos";
    }
    @GetMapping("/photos/input")
    public String input(Model model) {
        model.addAttribute("photo", new Photo());
        return "admin/photos-input";
    }

    @GetMapping("/photos/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("photo", photoService.getPhoto(id));
        return "admin/photos-input";
    }
    @PostMapping("/photos")
    public String post(@Valid Photo photo, BindingResult result, RedirectAttributes attributes) {

        Photo photo1 = photoService.savePhoto(photo);
        if (photo1 == null ) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/photos";
    }

    @PostMapping("/photos/{id}")
    public String editPost(@Valid Photo photo, BindingResult result, @PathVariable Long id, RedirectAttributes attributes) {
        Photo photo1 = photoService.updatePhoto(id, photo);
        if (photo1 == null ) {
            attributes.addFlashAttribute("message", "更新失败");
        } else {
            attributes.addFlashAttribute("message", "更新成功");
        }
        return "redirect:/admin/photos";
    }


}
