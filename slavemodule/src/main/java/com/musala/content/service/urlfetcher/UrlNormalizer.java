package com.musala.content.service.urlfetcher;

import org.apache.commons.validator.routines.UrlValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class UrlNormalizer {

    private String domain;

    UrlNormalizer(String domain) {
        this.domain = domain;
    }


    String normalize(String url) {
        String[] schemes = {"http", "https"};
        UrlValidator urlValidator = new UrlValidator(schemes);
        if (urlValidator.isValid(url)) {
            return url.contains(getDomain(this.domain)) ? url : null;
        } else {
            if (!containsPatterns(url)) {
                return String.format("%s%s", getDomain(this.domain), url);
            } else {
                return null;
            }
        }
    }
    
    private String getDomain(String url) {
        Pattern pattern = Pattern.compile("https?:\\/\\/(www.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}");
        Matcher matcher = pattern.matcher(url);
        return matcher.find() ?  matcher.group(0) : null;
    }

    private boolean containsPatterns(String url) {
        List<String> patterns = new ArrayList<>(Arrays.asList("#", "Category:", "Help:", "Wikipedia:", "google.com"));

        return patterns.stream().anyMatch(s -> url.contains(s));
    }

}
