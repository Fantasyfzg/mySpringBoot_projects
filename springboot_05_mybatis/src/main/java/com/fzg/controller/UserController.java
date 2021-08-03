package com.fzg.controller;

import com.fzg.mapper.UserMapper;
import com.fzg.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    //查询所有用户
    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> userList =  userMapper.queryUserList();
        return userList;
    }


    //添加用户
    @GetMapping("/addUser")
    public String addUser(){
        userMapper.addUser(new User(4,"wb","147"));
        return "添加用户成功！";
    }

    //更改用户信息
    @GetMapping("/updateUser")
    public String updateUser(){
        userMapper.updateUser(new User(3,"wb2","000"));
        return "用户信息更改成功！";
    }

    //删除用户
    @GetMapping("/deleteUser")
    public String deleteUser(){
        userMapper.deleteUser(4);
        return "删除用户成功！";
    }

}
