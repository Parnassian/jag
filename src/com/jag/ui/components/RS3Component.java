package com.jag.ui.components;

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.net.URL;

import javax.swing.JPanel;

import com.jag.core.RS3Context;

public class RS3Component extends JPanel implements AppletStub {
	private static final long serialVersionUID = -4787164965370260205L;
	private RS3Context rs3Context;
	
	public RS3Component() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(768, 560));
	}
	
	public void addGame(RS3Context context) {
		this.rs3Context = context;
		Applet game = rs3Context.getProvider().getApplet();
		game.setStub(this);
		game.init();
		game.start();
		add(game);
	}

	@Override
	public void appletResize(int w, int h) {

	}

	@Override
	public AppletContext getAppletContext() {
		return null;
	}

	@Override
	public URL getCodeBase() {
		return rs3Context.getWebClient().getWebClientPage().getURL();
	}

	@Override
	public URL getDocumentBase() {
		return getCodeBase();
	}

	@Override
	public String getParameter(String key) {
		return rs3Context.getWebClient().getProperty(key);
	}

	@Override
	public boolean isActive() {
		return false;
	}


}
