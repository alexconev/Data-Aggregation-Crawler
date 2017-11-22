package com.musala.content.urlfetcher;

import com.musala.content.utils.Source;

import java.util.HashSet;
import java.util.Set;

public class UrlFetcher {

    // TODO
    public static Set<String> getUrls(Source source) {
        Set<String> links = new HashSet<>();

        links.add("https://www.homes.bg/as957180");
        links.add("https://www.homes.bg/as957179");
        links.add("https://www.homes.bg/as957178");

        return links;
    }
}
