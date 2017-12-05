package com.musala.content.service.urlfetcher;

import com.musala.content.service.registerer.Registerer;
import com.musala.content.model.Source;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UrlFetcher {

    public UrlFetcher() {
        //NO-OP
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(Registerer.class);

    /**
     * Extract all of the sub-URL of the given url in the @{@link Source}.
     * The return result is in absolute URL form - <protocol>://<web_server_name>/<folder>/<file> (ex:http://www.example.com/index.html).
     *
     * @param source The target url
     * @return Set of URLs
     */
    public Set<String> getUrls(Source source) {
        Document doc = Jsoup.parse(source.getContent());

        Element element = doc.getElementById("content");
        if (element != null) {
            element.setBaseUri(source.getUrl());
            return getUrlForElement(element);
        }

        LOGGER.info(String.format("The current link: %s has not appropriate content tag!", source.getUrl()));
        return null;
    }

    private Set<String> getUrlForElement(Element element) {
        UrlStore store = UrlStore.createStoreFromUrl(element.baseUri());
        Elements links = element.getElementsByTag("a");
        for (Element link : links) {
            store.addUrl(link.attr("href"));
        }


        LOGGER.info(String.format("The url %s contains %d sub-urls", store.getProcessedUrl(), store.getChildUrls().size()));

        return store.getChildUrls();
    }

}
