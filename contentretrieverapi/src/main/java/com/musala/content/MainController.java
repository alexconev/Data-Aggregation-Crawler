package com.musala.content;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping("/content")
    @ResponseBody
    String home() {
        return "Hello world";
    }
}
