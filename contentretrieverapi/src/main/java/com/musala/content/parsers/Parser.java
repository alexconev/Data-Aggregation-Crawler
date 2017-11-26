package com.musala.content.parsers;

import com.musala.content.utils.Source;

import java.util.Map;

interface Parser {

    Map<String, String> parse(Source source);
}
