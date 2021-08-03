package com.fzg.springboot_task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    //在一个特定的时间执行这个方法 Timer
    //cron表达式
    /*
         0 0/5 10,18 * * ?  每天的10点和18点，每隔5分组执行一次
         0 15 10 ？ * 1-6   每个月的周一到周六的10：15执行一次
         0/2 * * * * ?      每两秒执行一次
     */

    //秒 分 时 日 月 周几
    @Scheduled(cron = "0/2 * * * * ?") //表示每一天的17：50：00执行
    public void hello(){
        System.out.println("hello,你被执行了！");
    }
}
