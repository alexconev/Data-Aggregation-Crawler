package com.musala.content.service;

import com.musala.content.parsers.HomesParser;
import com.musala.content.urlfetcher.UrlFetcher;

import com.musala.content.utils.Source;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    private UrlFetcher urlFetcher;

    public UrlServiceImpl () {
        //NO-OP
    }

    @Override
    public String extractUrlContent(String url) {
        Source data = new Source(url);
        JSONObject extractedResults = new JSONObject();

        Set<String> fetchedUrls = urlFetcher.getUrls(data);
        extractedResults.put("urls", fetchedUrls);

        Map<String, String> extractedData = new HomesParser().parse(data);
        extractedResults.put("data", extractedData);

        return extractedResults.toString();
    }
}
