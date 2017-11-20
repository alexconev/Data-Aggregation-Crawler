package com.musala.content.parsers;

import com.musala.content.Page;

interface Parser {

    void parse(Page page);

    void sendContent();
}
