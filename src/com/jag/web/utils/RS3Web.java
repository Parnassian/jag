package com.jag.web.utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.jag.web.HTTPGet;

/**
 * 
 * A RS3Web class fetches and parses content from the runescape 3 webclient page.
 * 
 * @author Parnassian
 *
 */
public class RS3Web extends HTTPGet {
	private URL url;
	private String pageSource;
	
	public RS3Web() throws MalformedURLException {
		this(String.format("http://world%d.runescape.com/", (int) (Math.random() * 100 + 1)));
	}
	
	public RS3Web(String url) throws MalformedURLException {
		this(new URL(url));
	}

	public RS3Web(URL url) {
		this.url = url;
	}
	
	public URL getURL() {
		return this.url;
	}
	
	public String getPageContents() throws IOException {
		return pageSource == null ? pageSource = getAsText(url) : pageSource;
	}

}
