package com.musala.content.urlfetcher;

import com.musala.content.Page;

import java.util.HashSet;
import java.util.Set;

public class MainUrlFetcher implements UrlFetcher{

    @Override
    public Set<String> getUrls(Page page) {
        return new HashSet<String>();
    }
}
