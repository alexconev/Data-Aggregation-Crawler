package com.musala.content.parsers;

import com.musala.content.Source;

interface Parser {

    void parse(Source source);

    void sendContent();
}
