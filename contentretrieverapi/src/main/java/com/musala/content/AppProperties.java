package com.musala.content;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {

    @Value("${mainModule.url}")
    private String mainModuleUrl;

    @Value("${currentModule.inputUrl}")
    private String inputUrl;

    @Value("${currentModule.mainUrl}")
    private String mainUrl;

    @Value("${currentModule.sourceName}")
    private String sourceName;

    public String getMainModuleUrl() {
        return mainModuleUrl;
    }

    public String getInputUrl() {
        return inputUrl;
    }

    public String getMainUrl() {
        return mainUrl;
    }

    public String getSourceName() {
        return sourceName;
    }
}
