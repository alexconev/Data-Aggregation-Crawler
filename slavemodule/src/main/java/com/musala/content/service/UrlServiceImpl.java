package com.musala.content.service;

import com.musala.content.service.parsers.Parser;
import com.musala.content.service.parsers.ParserFactory;
import com.musala.content.service.urlfetcher.UrlFetcher;


import com.musala.content.model.Source;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class UrlServiceImpl implements UrlService {
	 
	private static final Logger LOGGER = LoggerFactory.getLogger(UrlServiceImpl.class);

	@Value("${currentModule.sourceName}")
	private String sourceName;

	@Autowired
	private UrlFetcher urlFetcher;

	public UrlServiceImpl() {
		// NO-OP
	}

	@Override
	public String extractUrlContent(String url) {
		Source data = new Source(url);
		JSONObject extractedResults = new JSONObject();

		Set<String> fetchedUrls = urlFetcher.getUrls(data);
		extractedResults.put("urls", fetchedUrls);

		ParserFactory pf = new ParserFactory();
		Parser parser = pf.getParser(sourceName);

		Map<String, String> extractedData = parser.parse(data);
		
		if(extractedData == null){
			 LOGGER.warn(String.format("There is NO extracted data"));
			 return null;
		}

		extractedResults.put("data", extractedData);

		return extractedResults.toString();
	}
}
