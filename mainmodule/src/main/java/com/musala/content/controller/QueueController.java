package com.musala.content.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueueController {
    @RequestMapping(value = "/queue")
    @ResponseBody
    private String home() {
        return "Hello world!";
    }

}
