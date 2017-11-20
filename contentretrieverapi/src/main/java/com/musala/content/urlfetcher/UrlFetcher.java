package com.musala.content.urlfetcher;

import com.musala.content.Page;

import java.util.Set;

interface UrlFetcher {

    Set<String> getUrls(Page page);

}
