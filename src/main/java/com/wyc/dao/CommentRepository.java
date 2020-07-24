package com.wyc.dao;


import com.wyc.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByBlogIdAndParentCommentNull(Long blogId, Sort sort);
    @Query("select c from Comment c where c.adminComment = true")
    Page<Comment> findwd(Pageable pageable);
    @Query("select c from Comment c where c.adminComment = false ")
    Page<Comment> findyk(Pageable pageable);

    @Transactional
    @Modifying
    @Query("update Comment c set c.parentComment = null where c.id = ?1")
    int updateViews(Long id);
    @Query("select c from Comment c where c.parentComment = ?1 ")
    Comment findO(Comment comment);

}
