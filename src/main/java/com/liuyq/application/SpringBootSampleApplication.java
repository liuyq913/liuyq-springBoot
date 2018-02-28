package com.liuyq.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Created by liuyq on 2017/10/18.
 */
@SpringBootApplication //实际@SpringBootApplication 将@Configuration,@ComponentScan, @EnableAutoConfiguration三个有用的注解组合在了一起。
@ServletComponentScan
public class SpringBootSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSampleApplication.class, args);
    }
  /*  @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new MyServlet(), "/xs*//*");// ServletName默认值为首字母小写，即myServlet
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSampleApplication.class, args);
    }*/
}
