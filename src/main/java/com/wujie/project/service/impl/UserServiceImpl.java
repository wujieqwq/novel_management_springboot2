package com.wujie.project.service.impl;

import com.wujie.project.mapper.UserMapper;
import com.wujie.project.pojo.User;
import com.wujie.project.service.UserService;
import com.wujie.project.utils.vo.UserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void updateUser(User user) {
        userMapper.updateById(user);
    }

    @Override
    public User selectByEmail(String email) {
        return userMapper.selectByEmail(email);
    }

    @Override
    public User selectInfoById(String uid) {
        return userMapper.selectById(uid);
    }

    @Override
    public void updatePassWordByEmail(String email, String password) {
        userMapper.updatePassWordByEmail(email,password);
    }

    @Override
    public String selectUidByUname(String uname) {
        return userMapper.selectUidByUname(uname);
    }

    @Override
    public void insertUser(UserRegister userRegister) {
        User user = new User();
        user.setPassword(userRegister.getPassword());
        user.setEmail(userRegister.getEmail());
        user.setUname(userRegister.getUname());
        user.setUserType(userRegister.getUserType());
        userMapper.insert(user);
    }

    @Override
    public String selectUidByEmail(String email) {

        return userMapper.selectUidByEmail(email);
    }

    @Override
    public User selectUserByUidWithAu(String uid) {
        return null;
    }
}
