package com.musala.content.service.parsers;

import com.musala.content.model.Source;

import java.util.Map;

interface Parser {

    Map<String, String> parse(Source source);
}
