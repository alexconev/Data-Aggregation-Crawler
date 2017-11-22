package com.musala.content;

import com.musala.content.parsers.HomesParser;
import com.musala.content.urlfetcher.UrlFetcher;
import com.musala.content.utils.Source;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
public class MainController {

    @Value("${mainModule.contentUrl}")
    private String contentUrl;

    @Value("${mainModule.queueUrl}")
    private String queueUrl;

    @RequestMapping(value = "/")
    @ResponseBody
    private String home(@RequestParam("url") String url) {
        Source data = new Source(url);
        JSONObject extractedResults = new JSONObject();

        Set<String> fetchedUrls = UrlFetcher.getUrls(data);
        extractedResults.put("urls", fetchedUrls);

        Map<String, String> extractedData = new HomesParser().parse(data);
        extractedResults.put("data", extractedData);

        return extractedResults.toString();
    }

}
