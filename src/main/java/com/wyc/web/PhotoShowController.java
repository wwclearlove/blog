package com.wyc.web;


import com.wyc.service.PhotoService;
import com.wyc.util.FbUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PhotoShowController {
    @Autowired
    PhotoService photoService;

    @RequestMapping("photo")
    public String index(@PageableDefault(size = 6, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable, Model model){
        model.addAttribute("page",photoService.listPhoto(pageable));
        return "photo";
    }
}
