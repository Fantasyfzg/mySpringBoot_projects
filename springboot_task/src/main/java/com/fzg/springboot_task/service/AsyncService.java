package com.fzg.springboot_task.service;

import org.springframework.scheduling.annotation.Async;

public class AsyncService {

    //告诉spring，这是一个异步的方法
    @Async
    public void hello(){
        //CTRL + alt + t  => try ... catch 的快捷键
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("数据正在处理....");
    }
}
