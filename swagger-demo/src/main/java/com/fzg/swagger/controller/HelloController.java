package com.fzg.swagger.controller;

import com.fzg.swagger.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//operatio接口
@ApiOperation("hello控制类")
@RestController
public class HelloController {
    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    //只要接口中存在实体类，就会被扫描到swagger
    @PostMapping(value = "/User")
    public User user(){
        return new User();
    }

    //operatio接口
    @ApiOperation("hello控制类")//放在方法上
    @GetMapping(value = "/hello2")
    public String hello2(@ApiParam("用户名") String username){
        return "hello" + username;
    }


    @ApiOperation("post测试")//放在方法上
    @GetMapping(value = "/postt")
    public String postt(@ApiParam("用户名") String username){
        return "hello" + username;
    }


}
