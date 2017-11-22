package com.musala.content.parsers;

import com.musala.content.utils.Source;

import java.util.Map;

interface Parser {

    public Map<String, String> parse(Source source);
}
