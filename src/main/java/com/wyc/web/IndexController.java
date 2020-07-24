package com.wyc.web;

import com.wyc.NotFoundException;
import com.wyc.model.Tag;
import com.wyc.model.Type;
import com.wyc.service.*;
import com.wyc.util.FbUtil;
import com.wyc.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private PhotoService photoService;
    @Autowired
    private TagService tagService;
    @Autowired
    private YlService ylService;
    @RequestMapping("/")
    public String index(@PageableDefault(size = 8, sort = {"updateTime"},
            direction = Sort.Direction.DESC) Pageable pageable, Model model){
        model.addAttribute("page",blogService.cglistBlog(pageable));
        List<Type> types = typeService.listTypeTop(6);
        List<Tag> tags = tagService.listTagTop(10);
        model.addAttribute("types", FbUtil.qc(types) );
        model.addAttribute("tags",FbUtil.tag(tags) );
        model.addAttribute("photos", photoService.listPhotoTop(4));
        model.addAttribute("recommendBlogs", blogService.listRecommendBlogTop(8));
        return "index";
    }
    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id,Model model) {
        model.addAttribute("blog", blogService.getAndConvert(id));
        return "blog";
    }

    @PostMapping("/search")
    public String search(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                         @RequestParam String query, Model model) {
        model.addAttribute("page", blogService.listBlog("%"+query+"%", pageable));
        model.addAttribute("query", query);
        return "search";
    }
    @GetMapping("/footer/newblog")
    public String newblogs(Model model) {
        model.addAttribute("newblogs", blogService.listRecommendBlogTop(3));
        return "_fragments :: newblogList";
    }
    @GetMapping("/footer/yl")
    public String yls(Model model) {
        model.addAttribute("yls", ylService.listYlTop(3));
        return "admin/_fragments :: ylList";
    }

}