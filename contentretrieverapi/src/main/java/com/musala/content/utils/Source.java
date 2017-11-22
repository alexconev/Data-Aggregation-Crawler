package com.musala.content.utils;

import com.musala.content.registerer.Registerer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Source {

    private static final Logger LOGGER = LoggerFactory.getLogger(Registerer.class);
    private String content;
    private String url;

    public Source(String url) {
        this.url = url;
        this.content = fetchContent();
    }

    private String fetchContent() {
        URL oracle = null;
        BufferedReader input = null;
        StringBuilder sb = new StringBuilder();
        String inputLine;

        try {
            oracle = new URL(url);

            input = new BufferedReader(new InputStreamReader(oracle.openStream()));

            while ((inputLine = input.readLine()) != null) {
                sb.append(inputLine);
            }

            input.close();
        } catch (MalformedURLException e) {
            LOGGER.debug("Invalid URL for retrieving content", e);
        } catch (IOException e) {
            LOGGER.debug("Cannot read content from provided URL", e);
        }

        return sb.toString();
    }

    public String getContent() {
        return content;
    }

    public String getUrl() {
        return url;
    }
}
