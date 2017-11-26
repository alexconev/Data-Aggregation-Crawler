package com.musala.content.urlfetcher;

import com.musala.content.registerer.Registerer;
import com.musala.content.utils.Source;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UrlFetcher {

    public UrlFetcher() {
        //NO-OP
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(Registerer.class);

    // TODO add description
    public Set<String> getUrls(Source source) {
        Document doc = Jsoup.parse(source.getContent());
        Set<String> result = new HashSet<>();

        Element content = doc.getElementById("content");

        if (content == null) {
            //TODO: handle this case
            LOGGER.info(String.format("The current link: %s has not appropriate content tag!", source.getUrl()));

        } else {
            Elements links = content.getElementsByTag("a");
            for (Element link : links) {
                result.add(link.attr("href"));
            }
            LOGGER.info(String.format("The url %s contains %d sub-urls", source.getUrl(), result.size()));
        }

        return result;
    }
}
