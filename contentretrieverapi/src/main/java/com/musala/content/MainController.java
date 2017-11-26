package com.musala.content;

import com.musala.content.service.UrlService;
import com.musala.content.service.UrlServiceImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @Value("${mainModule.contentUrl}")
    private String contentUrl;

    @Value("${mainModule.queueUrl}")
    private String queueUrl;

    @RequestMapping(value = "/")
    @ResponseBody
    private String home(@RequestParam("url") String url) {
        UrlService urlService = new UrlServiceImpl(url);
        return urlService.extractUrlContent();
    }

}
