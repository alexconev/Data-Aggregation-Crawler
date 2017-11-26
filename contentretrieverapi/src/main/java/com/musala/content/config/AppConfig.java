package com.musala.content.config;

import com.musala.content.service.UrlService;
import com.musala.content.service.UrlServiceImpl;
import com.musala.content.urlfetcher.UrlFetcher;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UrlService urlService() {
        return new UrlServiceImpl();
    }

    @Bean
    public UrlFetcher urlFetcher() {
        return new UrlFetcher();
    }

}
