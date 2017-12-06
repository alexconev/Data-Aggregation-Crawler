package com.musala.content.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentController {
    @RequestMapping(value = "/content")
    @ResponseBody
    private String home() {
        return "Hello world!";
    }

}
