package com.musala.content.registerer;

import com.musala.content.utils.ConnectionUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Registerer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Registerer.class);

    @Value("${mainModule.registerUrl}")
    private String mainModuleUrl;

    @Value("${currentModule.moduleUrl}")
    private String moduleUrl;

    @Value("${currentModule.mainUrl}")
    private String mainUrl;

    @Value("${currentModule.sourceName}")
    private String sourceName;

    @EventListener
    public void register(ContextRefreshedEvent event) {

        Map<String, String> parameters = new HashMap<>();
        parameters.put("moduleUrl", moduleUrl);
        parameters.put("parseUrl", mainUrl);
        parameters.put("source", sourceName);

        CloseableHttpResponse response = ConnectionUtils.makePostRequest(mainModuleUrl, parameters);

        LOGGER.info(isSuccessful(response) ? "Successfully registered" : "Not registered");
    }

    private boolean isSuccessful(CloseableHttpResponse response) {
        final Integer ok = 200;
        return response != null && response.getStatusLine().getStatusCode() == ok;
    }


}
