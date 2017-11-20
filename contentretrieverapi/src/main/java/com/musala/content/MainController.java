package com.musala.content;

import com.musala.content.registerer.MainRegisterer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@ComponentScan
@EnableAutoConfiguration
public class MainController {

    @Autowired
    private static AppProperties properties;

    @RequestMapping("/content")
    @ResponseBody
    String home() {
        return "Hello world";
    }

    public static void main(String[] args) {
        SpringApplication.run(MainController.class, args);
        MainRegisterer registerer = new MainRegisterer(properties);
        registerer.register();
    }
}
