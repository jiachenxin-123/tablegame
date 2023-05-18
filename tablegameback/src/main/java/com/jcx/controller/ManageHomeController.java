package com.jcx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jcx.controller.utils.R;
import com.jcx.entity.*;
import com.jcx.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/manageHome")
public class ManageHomeController {
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private LogService logService;
    @Autowired
    private GameService gameService;
    @Autowired
    private RoomService roomService;

    @GetMapping("/user")
    public R getAllUser(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("role",0);

        List list = userService.list(wrapper);
        return new R(true,list);
    }

    @GetMapping("/room")
    public R getAllRoom(){
        List<Room> list = roomService.list();
        return new R(true,list);
    }

    @GetMapping("/game")
    public R getAllGame(){
        List<Game> list = gameService.list();
        return new R(true,list);
    }

    @GetMapping("/comment")
    public R getAllComment(){
        List<Comment> list = commentService.list();
        return new R(true,list);
    }

    @GetMapping("/log")
    public R getAllLog(){
        List<Log> list = logService.list();
        return new R(true,list);
    }

    @PutMapping("/game")
    public R updataGame(@RequestBody Game game){
        boolean b = gameService.updateById(game);
        if (b)
            return new R(true,"修改成功");
        else
            return new R(false,"修改失败");
    }

    @PutMapping("/room")
    public R updata(@RequestBody Room room){
        boolean b = roomService.updateById(room);
        if (b)
            return new R(true,"修改成功");
        else
            return new R(false,"修改失败");
    }

    @DeleteMapping("/user/{account}")
    public R deleteUser(@PathVariable String account){
        boolean b = userService.removeById(account);
        if (b)
            return new R(true,"删除成功");
        else
            return new R(false,"删除失败");
    }

    @DeleteMapping("/room/{id}")
    public R deleteRoom(@PathVariable int id){
        boolean b = roomService.removeById(id);
        if (b)
            return new R(true,"删除成功");
        else
            return new R(false,"删除失败");
    }

    @DeleteMapping("/game/{id}")
    public R deleteGame(@PathVariable int id){
        boolean b = gameService.removeById(id);
        if (b)
            return new R(true,"删除成功");
        else
            return new R(false,"删除失败");
    }

    @DeleteMapping("/comment/{id}")
    public R deleteComment(@PathVariable int id){
        boolean b = commentService.removeById(id);
        if (b)
            return new R(true,"删除成功");
        else
            return new R(false,"删除失败");
    }

    @DeleteMapping("/log/{id}")
    public R deleteLog(@PathVariable int id){
        boolean b = logService.removeById(id);
        if (b)
            return new R(true,"删除成功");
        else
            return new R(false,"删除失败");
    }
}
