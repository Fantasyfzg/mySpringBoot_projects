package com.fzg.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //配置多个docket
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("魏青波");
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("王博");
    }

    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("郭斌");
    }


    //配置了swagger的Docket的bean实例
    @Bean
    public Docket docket(Environment environment){

        //设置要显示的swagger环境
        Profiles profiles = Profiles.of("dev","test");

        //获取项目的环境
        Boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("范占国")
                .enable(flag)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fzg.swagger.controller"))
                //过滤指定路径
//                .paths(PathSelectors.ant("/fzg/**")) //一个都扫描不到了
                .build();
    }

    //配置swagger信息  apiInfo
    private ApiInfo apiInfo(){
        
        //u
        Contact contact = new Contact("范占国", "", "1840633803@qq.com");
        return new ApiInfo(
                "范占国的swaggerAPI文档",
                "若似月明终皎洁，不辞冰雪为卿热。",
                "v1.0",
                "urn:tos", contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

}
