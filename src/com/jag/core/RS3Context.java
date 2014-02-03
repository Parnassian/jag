package com.jag.core;

import java.awt.BorderLayout;

import com.jag.loader.client.ClientProvider;
import com.jag.ui.components.RS3Component;
import com.jag.web.parsers.RS3WebApplet;
import com.jag.web.utils.RS3Web;

public class RS3Context implements Runnable {
	private ClientProvider provider;
	private RS3WebApplet webClient;
	private RS3Component rs3Component;
	
	public RS3Context() {
		this.rs3Component = new RS3Component();
	}
	
	public RS3WebApplet getWebClient() {
		return webClient;
	}
	
	public RS3Component getComponent() {
		return rs3Component;
	}
	
	public ClientProvider getProvider() {
		return this.provider;
	}

	@Override
	public void run() {
		try {
			this.webClient = new RS3WebApplet(new RS3Web("http://world40.runescape.com/"));
			this.provider = new ClientProvider(webClient);
			rs3Component.addGame(this);
			Jag.getInstance().getJagUI().getContentPane().add(rs3Component, BorderLayout.CENTER);
			Jag.getInstance().getJagUI().pack();
		} catch(Throwable t) {
			t.printStackTrace();
		}
	}
	
	

}
