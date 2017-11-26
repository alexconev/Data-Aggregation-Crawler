package com.musala.content;

import com.musala.content.service.UrlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @Value("${mainModule.contentUrl}")
    private String contentUrl;

    @Value("${mainModule.queueUrl}")
    private String queueUrl;

    @Autowired
    UrlService urlService;

    @RequestMapping(value = "/")
    @ResponseBody
    private String home(@RequestParam("url") String url) {
        return urlService.extractUrlContent(url);
    }

}
