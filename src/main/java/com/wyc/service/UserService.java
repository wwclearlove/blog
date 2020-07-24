package com.wyc.service;

import com.wyc.model.User;
import com.wyc.vo.UserQuery;

public interface UserService {
    User checkUser(String username,String password);
    String selectPhone(String username);
    int updatePassword(String password);
    User selectUser(String username);
    int updateUser(User user);
}
