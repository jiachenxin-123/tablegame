package com.jcx.controller;


import com.jcx.controller.utils.R;
import com.jcx.entity.User;
import com.jcx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("{account}/{password}")
    public R login(@PathVariable String account,@PathVariable String password){
        User user = userService.getById(account);
        if (user == null){
            return new R(false,"不存在该用户!");
        }
        else if (!password.equals(user.getPassword())){
            return new R(false,"密码错误,请重新输入!");
        }
        else
            return new R(true,user.getRole());
    }
}
