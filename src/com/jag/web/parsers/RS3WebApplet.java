package com.jag.web.parsers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jag.web.utils.RS3Web;

public class RS3WebApplet extends Properties {
	private static final long serialVersionUID = -4734681720825650706L;
	private final Pattern parametersPattern;
	private final Pattern gamePackPattern;
	private final RS3Web web;
	private URL gamePackURL;
	
	public RS3WebApplet() throws MalformedURLException {
		this(new RS3Web());
	}

	public RS3WebApplet(RS3Web web) {
		this.web = web;
		this.parametersPattern = Pattern
				.compile("<param name=\"([^\\s]+)\"\\s+value=\"([^>]*)\">");
		this.gamePackPattern = Pattern.compile("archive=(.+?) '");

		try {
			parseParameters(web.getPageContents());
			parseJarURL(web.getPageContents());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void parseParameters(String pageSource) {
		Matcher matcher = parametersPattern.matcher(pageSource);
		while (matcher.find()) {
			final String key = matcher.group(1);
			final String value = matcher.group(2);
			put(key, value);
		}
		// meh
		put("haveie6", "false"); // SEE: HTTPGet TODO
	}

	private void parseJarURL(String pageSource) {
		final Matcher matcher = gamePackPattern.matcher(pageSource);
		if (!matcher.find()) {
			throw new RuntimeException("Failed to fetch gamepack location.");
		}
		String jarLoc = matcher.group(1);
		try {
			this.gamePackURL = new URL(web.getURL().toString() + jarLoc);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public URL getGamePackURL() {
		return this.gamePackURL;
	}
	
	public RS3Web getWebClientPage() {
		return this.web;
	}

}
