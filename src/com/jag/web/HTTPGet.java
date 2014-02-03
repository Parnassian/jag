package com.jag.web;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * 
 * A HTTPGet class fetches content a page
 * 
 * @author Parnassian
 * 
 * TODO - agents, HTTPSUrlConnection etc....
 *
 */
public class HTTPGet {
	
	/**
	 * Fetches content from a page
	 * @param url
	 * @return the contents of the page
	 * @throws IOException 
	 */
	public static String getAsText(String url) throws IOException {
		return getAsText(new URL(url));
	}
	
	/**
	 * Fetches contents from a page
	 * @param url
	 * @return the contents of the page
	 * @throws IOException
	 */
	public static String getAsText(URL url) throws IOException {
		Scanner sc = new Scanner(url.openStream());
		StringBuilder sb = new StringBuilder();
		while(sc.hasNext()) {
			sb.append(sc.nextLine());
		}
		sc.close();
		return new String(sb);
	}

}
