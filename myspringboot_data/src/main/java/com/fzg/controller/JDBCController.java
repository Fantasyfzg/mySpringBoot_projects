package com.fzg.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询数据库的所有信息
    @GetMapping("/userList")
    public List<Map<String,Object>> userList(){
        String sql = "select * from mybatis.users";
        List<Map<String,Object>> list_maps = jdbcTemplate.queryForList(sql);
        return list_maps;
    }
    //增加
    @GetMapping("/addUser")
    public String addUser(){
        String sql = "insert into mybatis.users(id,name,password) values(4,'dgb',021)";
        jdbcTemplate.update(sql);
        return "update-ok";
    }

    //改
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql = "update mybatis.users set name=?,password=? where id=" + id;

        //封装
        Object[] objects = new Object[2];
        objects[0] = "gb";
        objects[1] = "145";
        jdbcTemplate.update(sql,objects);
        return "updateUser-ok";
    }

    //删
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String sql = "delete from mybatis.users where id =?";
        jdbcTemplate.update(sql,id);
        return "deleteUser-ok";
    }

}
