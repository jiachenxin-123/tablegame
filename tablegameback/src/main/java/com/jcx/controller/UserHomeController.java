package com.jcx.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.jcx.controller.utils.R;
import com.jcx.entity.*;
import com.jcx.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/userHome")
public class UserHomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private GameService gameService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private LogService logService;

    @GetMapping("/game")
    public R getAllGame(){
        List<Game> list = gameService.list();
        return new R(true,list);
    }

    @GetMapping("/room")
    public R getAllRoom(){
        List<Room> list = roomService.list();
        return new R(true,list);
    }

    @GetMapping("/{account}")
    public R getUser(@PathVariable String account){
        User byId = userService.getById(account);
        return new R(true,byId);
    }

    @GetMapping("/comment")
    public R getAllComment(){
        List<Comment> list = commentService.list();
        return new R(true,list);
    }

    @PostMapping("/comment")
    public R addComment(@RequestBody Comment comment){
        if (comment.getComment().isEmpty()){
            return new R(false,"评论不能为空");
        }
        else if (comment.getStar() == 0){
            return new R(false,"");
        }
        boolean save = commentService.save(comment);
        if (save)
            return new R(true,"添加成功");
        else
            return new R(false,"添加失败");
    }

    //查询某个用户的记录
    @GetMapping("/log/{account}")
    public R getOneLog(@PathVariable String account){
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("account",account);

        List<Log> logs = logService.listByMap(hashMap);
        if (!logs.isEmpty())
            return new R(true,logs);
        else
            return new R(false,"查询失败");
    }

    @PostMapping("/log")
    public R addLog(@RequestBody Log log){
        boolean save = logService.save(log);
        if (save)
            return new R(true,"添加成功");
        else
            return new R(false,"添加失败");
    }

    @PutMapping
    public R updateUser(@RequestBody User user){
        boolean b = userService.updateById(user);
        if (b){
            return new R(true,"修改成功");
        }
        else
            return new R(false,"修改失败");
    }
}
