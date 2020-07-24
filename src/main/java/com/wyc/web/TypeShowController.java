package com.wyc.web;

import com.wyc.model.Blog;
import com.wyc.model.Type;
import com.wyc.service.BlogService;
import com.wyc.service.TypeService;
import com.wyc.util.FbUtil;
import com.wyc.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class TypeShowController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/types/{id}")
    public String types(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                        @PathVariable Long id, Model model) {
        List<Type> types = typeService.listTypeTop(10000);

        if (id == -1) {
            id = types.get(0).getId();
        }

        BlogQuery blogQuery = new BlogQuery();
        blogQuery.setTypeId(id);
        blogQuery.setPublished(true);
        model.addAttribute("types", FbUtil.qc(types));
        model.addAttribute("page", blogService.listBlogt(pageable, blogQuery));
        model.addAttribute("activeTypeId", id);
//        model.addAttribute("cg",blogService.cglistBlog(pageable));
        return "types";
    }

}
