package com.wyc.web.admin;

import com.wyc.model.Tag;
import com.wyc.service.CommentService;
import com.wyc.service.TagService;
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
public class CommentglController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comment")
    public String comment(@PageableDefault(size = 10,sort = {"id"},direction = Sort.Direction.DESC)
                               Pageable pageable, Model model) {
        model.addAttribute("page",commentService.listCommentyk(pageable));
        return "admin/comment";
    }
    @GetMapping("/authercomment")
    public String authercomment(@PageableDefault(size = 6,sort = {"id"},direction = Sort.Direction.DESC)
                               Pageable pageable, Model model) {
        model.addAttribute("page",commentService.listCommentwd(pageable));
        return "admin/authercomment";
    }

    @GetMapping("/comment/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes) {

        commentService.deleteComment(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/comment";
    }

}
