package com.wyc.service;

import com.wyc.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
    Page<Comment> listComment(Pageable pageable);
    Page<Comment> listCommentwd (Pageable pageable);
    Page<Comment> listCommentyk  (Pageable pageable);
    void deleteComment(Long id);
}
