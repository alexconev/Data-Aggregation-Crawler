package com.musala.content.utils;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConnectionUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionUtils.class);

    public static CloseableHttpResponse makePostRequest(String url, Map<String, String> parameters) {
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = null;

        try {
            HttpPost httpPost = new HttpPost(url);

            List<BasicNameValuePair> params = new ArrayList<>();
            for (Map.Entry<String, String> param : parameters.entrySet()) {
                params.add(new BasicNameValuePair(param.getKey(), param.getValue()));
            }

            httpPost.setEntity(new UrlEncodedFormEntity(params));

            response = client.execute(httpPost);

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

        return response;
    }

}
