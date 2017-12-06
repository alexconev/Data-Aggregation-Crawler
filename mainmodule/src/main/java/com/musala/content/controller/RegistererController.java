package com.musala.content.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class RegistererController {
    @RequestMapping(value = "/registerer")
    @ResponseBody
    private String home() {
        return "Hello world!";
    }

}
