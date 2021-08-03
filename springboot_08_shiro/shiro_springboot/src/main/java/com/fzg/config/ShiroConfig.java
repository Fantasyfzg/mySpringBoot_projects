package com.fzg.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();

        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加Shiro的内置过滤器
        //anon 无需认证就能访问
        //authc 必须认证才能访问
        //user 必须拥有记住我功能才能访问
        //perms 拥有对某个资源的权限才能访问

        Map<String,String> filterMap = new LinkedHashMap<>();

        filterMap.put("/user/add","authc");
        filterMap.put("/user/update","authc");

        //拦截
        bean.setFilterChainDefinitionMap(filterMap);

        //授权
        filterMap.put("/user/add","perms[user:add]");
        filterMap.put("/user/update","perms[user:update]");


        //设置登陆请求
        bean.setLoginUrl("/toLogin");
        
        //设置未授权的请求
        bean.setUnauthorizedUrl("/uoauth");

        return bean;
    }

    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        //关联UserRealm
        securityManager.setRealm(userRealm);


        return securityManager;
    }

    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    //整合ShiroDialect：用来整合Shiro,thymel
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
