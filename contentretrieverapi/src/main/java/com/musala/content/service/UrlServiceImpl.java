package com.musala.content.service;

import com.musala.content.parsers.HomesParser;
import com.musala.content.urlfetcher.UrlFetcher;
import com.musala.content.utils.Source;
import org.json.JSONObject;

import java.util.Map;
import java.util.Set;

public class UrlServiceImpl implements UrlService {

    private String url;

    public UrlServiceImpl (String url) {
        this.url = url;
    }

    @Override
    public String extractUrlContent() {
        Source data = new Source(url);
        JSONObject extractedResults = new JSONObject();

        Set<String> fetchedUrls = UrlFetcher.getUrls(data);
        extractedResults.put("urls", fetchedUrls);

        Map<String, String> extractedData = new HomesParser().parse(data);
        extractedResults.put("data", extractedData);

        return extractedResults.toString();
    }
}
