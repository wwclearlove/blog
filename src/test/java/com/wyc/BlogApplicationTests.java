package com.wyc;

import com.wyc.model.*;
import com.wyc.service.*;
import com.wyc.vo.BlogQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {
    @Autowired
    PhotoService photoService;
    @Autowired
    private BlogService blogService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;
    @Autowired
    private YlService ylService;

    //相册接口测试
    @Test
    public void index() {
        Pageable pageable1 = new PageRequest(1, 6, new Sort("id", "id"));
        Page<Photo> x = photoService.listPhoto(pageable1);
        System.out.println(x.getContent());
    }


    //归档接口测试
    @Test
    public void archives() {
        Map<String, List<Blog>> map = blogService.archiveBlog();
        for (String key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }
    }

    //评论接口测试
    @Test
    public void comment() {
        Pageable pageable = new PageRequest(1, 6, new Sort("id", "id"));
        Page<Comment> comments = commentService.listCommentyk(pageable);
        System.out.println(comments.getContent());
    }

    //首页博客列表接口测试
    @Test
    public void blogs() {
        Pageable pageable = new PageRequest(1, 6, new Sort("id", "id"));
        Page<Blog> blogs = blogService.cglistBlog(pageable);
        System.out.println(blogs.getContent());
    }


    //推荐博客列表接口测试
    @Test
    public void topBlog() {
        List<Blog> blogs = blogService.listRecommendBlogTop(8);
        System.out.println(blogs);
    }

    //分类接口测试
    @Test
    public void topFl() {
        List<Type> types = typeService.listTypeTop(6);
        System.out.println(types);
    }

    //标签接口测试
    @Test
    public void topBq() {
        List<Tag> tags = tagService.listTagTop(10);
        System.out.println(tags);
    }

}
