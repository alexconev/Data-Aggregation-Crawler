package com.musala.content.service.urlfetcher;

import java.util.HashSet;
import java.util.Set;

/**
 * Store responsible for URLs. It stores and returns them in various formats.
 */
class UrlStore {

    private String processedUrl;
    private Set<String> urls;

    private UrlStore(String processedUrl) {
        this.processedUrl = processedUrl;
        urls = new HashSet<>(50);
    }

    static synchronized UrlStore createStoreFromUrl(String rootUrl) {
         return new UrlStore(rootUrl);
    }

    Set<String> getChildUrls() {
        return this.urls;
    }

    void addUrl(String url) {
        UrlNormalizer normalizer = new UrlNormalizer(processedUrl);
        String result = normalizer.normalize(url);
        if (result != null) {
            urls.add(result);
        }
    }

    String getProcessedUrl() {
        return this.processedUrl;
    }

}
