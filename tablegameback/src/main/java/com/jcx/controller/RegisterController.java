package com.jcx.controller;


import com.jcx.controller.utils.R;
import com.jcx.entity.User;
import com.jcx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping
    public R addUser(@RequestBody User user){
        if(user.isEmpty()){
            return new R(false,"信息为空，请输入有效信息");
        }
        User user1 = userService.getById(user.getAccount());
        if (user1 != null){
            return new R(false,"该账号已被使用，请更换账号信息");
        }
        else {
            userService.save(user);
            return new R(true,"注册成功，请登录");
        }
    }
}
