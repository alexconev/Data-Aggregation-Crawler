package com.musala.content.registerer;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class Registerer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Registerer.class);

    @Value("${mainModule.url}")
    private String mainModuleUrl;

    @Value("${currentModule.inputUrl}")
    private String inputUrl;

    @Value("${currentModule.mainUrl}")
    private String mainUrl;

    @Value("${currentModule.sourceName}")
    private String sourceName;

    @EventListener
    public void register(ContextRefreshedEvent event) {
        final Integer OK = 200;
        CloseableHttpClient client = HttpClients.createDefault();

        try {
            HttpPost httpPost = new HttpPost(mainModuleUrl);

            List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
            params.add(new BasicNameValuePair("moduleUrl", inputUrl));
            params.add(new BasicNameValuePair("parseUrl", mainUrl));
            params.add(new BasicNameValuePair("source", sourceName));
            httpPost.setEntity(new UrlEncodedFormEntity(params));

            CloseableHttpResponse response = client.execute(httpPost);
            LOGGER.info(response.getStatusLine().getStatusCode() == OK ? "Successfully registered" : "Not registered");
        } catch (IOException e) {
            LOGGER.debug(e.getMessage(), e);
        } finally {
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    LOGGER.debug("", e);
                }
            }
        }
    }

}
