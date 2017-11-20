package com.musala.content.registerer;

import com.musala.content.AppProperties;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class MainRegisterer implements Registerer{

    private static final Logger LOGGER = LoggerFactory.getLogger(MainRegisterer.class);
    private AppProperties properties;

    public MainRegisterer(AppProperties properties) {
        this.properties = properties;
    }

    @Override
    public void register() {
        CloseableHttpClient client = HttpClients.createDefault();

        try {
            HttpPost httpPost = new HttpPost(properties.getMainModuleUrl());

            List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
            params.add(new BasicNameValuePair("moduleUrl", properties.getInputUrl()));
            params.add(new BasicNameValuePair("parseUrl", properties.getMainUrl()));
            params.add(new BasicNameValuePair("source", properties.getSourceName()));
            httpPost.setEntity(new UrlEncodedFormEntity(params));

            CloseableHttpResponse response = client.execute(httpPost);
            LOGGER.info(response.getStatusLine().getStatusCode() == 200 ? "Successfully registered" : "Not registered");

        } catch (IOException e) {
            LOGGER.debug("", e);
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
