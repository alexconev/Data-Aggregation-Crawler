package com.musala.content.urlfetcher;

import com.musala.content.utils.Source;

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
