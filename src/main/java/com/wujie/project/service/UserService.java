package com.wujie.project.service;

import com.wujie.project.pojo.User;
import com.wujie.project.utils.vo.UserRegister;

public interface UserService {
    void updateUser(User user);

    User selectByEmail(String email);

    User selectInfoById(Integer uid);

    void updatePassWordByEmail(String email, String password);

    String selectUidByUname(String uname);

    void insertUser(UserRegister userRegister);

    String selectUidByEmail(String email);

    User selectUserByUidWithAu(Integer uid);
}
