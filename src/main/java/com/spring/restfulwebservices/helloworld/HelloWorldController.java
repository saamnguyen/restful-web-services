package com.spring.restfulwebservices.helloworld;

import com.spring.restfulwebservices.helloworld.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
@Configuration
@RestController
public class HelloWorldController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello Bean");
    }

    @GetMapping("/hello-world-bean/{name}")
    public HelloWorldBean helloWorldBeanPath(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello Spring, %s", name));
    }

    @GetMapping(path="/hello-world-internationalized")
    public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required=false) Locale locale)
    {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }
}
