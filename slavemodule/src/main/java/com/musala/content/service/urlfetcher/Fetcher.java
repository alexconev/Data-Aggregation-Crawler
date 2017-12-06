package com.musala.content.service.urlfetcher;

import com.musala.content.model.Source;

import java.util.Set;

/**
 *
 */
public interface Fetcher {

    /**
     *
     * @param page
     * @return
     */
    Set<String> retrieveURLs (Source page);

}
