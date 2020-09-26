package com.westone.springbootfirstdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author xiongyahui
 */
//@EnableSwagger2Doc
//截止到2020/09/15,swagger还不支持springboot2.3.3版本
@EnableOpenApi
@SpringBootApplication
public class SpringbootfirstdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootfirstdemoApplication.class, args);
    }

}
