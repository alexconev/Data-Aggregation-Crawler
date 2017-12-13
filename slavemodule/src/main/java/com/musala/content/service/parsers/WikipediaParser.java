package com.musala.content.service.parsers;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.musala.content.model.Source;

public class WikipediaParser implements Parser {

	private static final Logger LOGGER = LoggerFactory.getLogger(WikipediaParser.class);
	
	@Override
	public Map<String, String> parse(Source source) {
		 Map<String, String> data = new HashMap<>();
		 
		 if(source.getContent() == null){
			 
			 LOGGER.warn(String.format("The source is null"));
			 return null;
		 }
		 Document doc = Jsoup.parse(source.getContent());   
		 String firstHeader = doc.getElementById("firstHeading").text();
		 if(firstHeader == null){
			 LOGGER.warn(String.format("Invalid Wikipedia Page"));
			 return null;
		 }
		 
		 String firstParagraph = "";
		 Element contentEl = doc.select("div.mw-parser-output").first();
		 
		 for (Element e : contentEl.getElementsByTag("p")) {

			 firstParagraph = e.text();
			 break;
			 
		}
		
		 
	        
	        data.put("Title", firstHeader);
	        data.put("First Paragraph", firstParagraph);
	        return data;
	}

	
}
