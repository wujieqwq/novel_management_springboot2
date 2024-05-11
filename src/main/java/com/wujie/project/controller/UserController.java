package com.wujie.project.controller;

import com.wujie.project.pojo.User;
import com.wujie.project.service.UserService;
import com.wujie.project.utils.JwtUtil;
import com.wujie.project.utils.MailUtils;
import com.wujie.project.utils.ResultInfo;
import com.wujie.project.utils.vo.UserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public ResultInfo login(String email,String password){
        User user = userService.selectByEmail(email);
        if(user==null||!user.getPassword().equals(password)){
            return new ResultInfo(400,"邮箱或密码错误");
        }
        String token = JwtUtil.generateToken(user.getUid());
        return new ResultInfo(200,"登录成功",user.getUserType(),token);
    }

    @RequestMapping("/register")
    public ResultInfo register(@RequestBody UserRegister userRegister, HttpSession session){
        String c = (String) session.getAttribute("code");
        if(!userRegister.getCode().equals(c)){
            return new ResultInfo(4000,"验证码错误");
        }
        userService.insertUser(userRegister);
        return new ResultInfo(200,"注册成功");
    }

    @RequestMapping("/sendCode")
    public ResultInfo sendCode(String email, HttpSession session){
        Random random = new Random();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        MailUtils.sendMail(email, String.valueOf(str),"注册验证码");
        session.setAttribute("code",str);
        return new ResultInfo(200,"发送成功");
    }

    @RequestMapping("/alterPassWorld")
    public ResultInfo alterPassWorld(String email,String code,String password,HttpServletRequest request){
        String c = (String) request.getAttribute("code");
        if(!c.equals(code)){
            return new ResultInfo(4000,"验证码错误");
        }
        userService.updatePassWordByEmail(email,password);
        return new ResultInfo(200,"修改成功");
    }

    @RequestMapping("/alterInfo")
    public ResultInfo alterInfo(@RequestBody User user,HttpServletRequest request){
        user.setUid((String) request.getAttribute("uid"));
        userService.updateUser(user);
        return new ResultInfo(200,"修改成功");
    }

    @RequestMapping("/selectInfo")
    public ResultInfo selectInfo(HttpServletRequest request){
        String uid = (String) request.getAttribute("uid");
        User user = userService.selectInfoById(uid);
        user.setPassword("");
        return new ResultInfo(200,"查询成功",user);
    }

    @RequestMapping("/unameIsExist")
    public ResultInfo selectUidByUname(String uname) {
        String uid = userService.selectUidByUname(uname);
        if (uid!=null) {
            return new ResultInfo(4000, "用户名重复");
        }
        return new ResultInfo(200, "用户名可用");
    }

    @RequestMapping("/emailIsExist")
    public ResultInfo selectUidByEmail(String email){
        String uid = userService.selectUidByEmail(email);
        if (uid!=null) {
            return new ResultInfo(4000, "邮箱已注册");
        }
        return new ResultInfo(200, "邮箱可用");
    }

}
