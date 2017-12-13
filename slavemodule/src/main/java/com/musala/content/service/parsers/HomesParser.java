package com.musala.content.service.parsers;

import com.musala.content.model.Source;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HomesParser implements Parser {

	// TODO: We need a validator that checks if the page is valid homes.bg offer
		@Override
		public Map<String, String> parse(Source source) {
			Map<String, String> data = new HashMap<>();

			Document doc = Jsoup.parse(source.getContent());
			Element table = doc.select("table").get(2);

			Element titleEl = doc.select("h1.ver30black").first();
			String titleStr = titleEl.text();

			Element priceSpan = doc.select("span.ver20black").first();
			String priceStr = priceSpan.text();

			Elements elements = doc.getElementsByTag("b");

			String titleString = "";
			String addressString = "";

			int index = 1;
			for (Element element : elements) {
				if (index == 3) {
					titleString = element.text();
				}
				if (index == 4) {
					addressString = element.text();
				}

				index++;
			}

			data.put("Title", titleStr);
			data.put("Title1", titleString);
			data.put("Price", priceStr);
			data.put("Address", addressString);
			return data;
		}

}
