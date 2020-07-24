package com.wyc.dao;

import com.wyc.model.Blog;
import com.wyc.model.Type;
import com.wyc.model.User;
import com.wyc.vo.UserQuery;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
    @Modifying
    @Query("update User u set u.password = ?1 where u.username = ?2")
    int updatePassword(String password,String username);

    @Transactional
    @Modifying
    @Query("update User u set u.avatar = ?1,u.nickname=?2,u.email=?3,u.updateTime=?4 where u.username = 'admin'")
    int updateUser(String avatar, String nickname, String email, Date update);

}
