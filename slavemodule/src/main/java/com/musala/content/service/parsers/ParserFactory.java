package com.musala.content.service.parsers;

public class ParserFactory {
	public Parser getParser(String siteUrl) {

		if (siteUrl == null) {
			return null;
		}

		if (siteUrl.equalsIgnoreCase("homes.bg")) {
			return new HomesParser();

		} else if (siteUrl.equalsIgnoreCase("wikipedia.org")) {
			return new WikipediaParser();

		}

		return null;
	}

}
