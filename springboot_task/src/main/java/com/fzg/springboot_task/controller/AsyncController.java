package com.fzg.springboot_task.controller;

import com.fzg.springboot_task.service.AsyncService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AsyncController {

    @RequestMapping("/hello")
    public String hello(){
        AsyncService asyncService = new AsyncService();
        asyncService.hello();
        return "OK";
    }
}
