package com.wyc.service.impl;

import com.wyc.dao.UserRepository;
import com.wyc.model.User;
import com.wyc.service.UserService;
import com.wyc.util.MD5Utils;
import com.wyc.vo.UserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.provider.MD5;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));

        return user;
    }

    @Override
    public String selectPhone(String username) {
        User user = userRepository.findByUsername(username);
        return user.getPhone();
    }
    @Transactional
    @Override
    public int updatePassword(String password) {
        int i = userRepository.updatePassword(MD5Utils.code(password),"admin");
        return i;
    }

    @Override
    public User selectUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public int updateUser(User user) {
        return userRepository.updateUser(user.getAvatar(),user.getNickname(),user.getEmail(),user.getUpdateTime());
    }
}
