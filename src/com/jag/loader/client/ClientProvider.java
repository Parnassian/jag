package com.jag.loader.client;

import java.applet.Applet;
import java.lang.reflect.Constructor;
import java.net.URL;

import com.jag.loader.JagAppletClassLoader;
import com.jag.web.parsers.RS3WebApplet;

public class ClientProvider extends JagAppletClassLoader {
	private final RS3WebApplet webClient;
	private Applet rs3Applet;
	
	public ClientProvider(RS3WebApplet webClient) {
		super(new URL[] { webClient.getGamePackURL() });
		this.webClient = webClient;
	}
	
	@SuppressWarnings("unchecked")
	public Constructor<? extends Applet> getRS3AppletConstructor() throws NoSuchMethodException, SecurityException, ClassNotFoundException {
		return (Constructor<? extends Applet>) loadClass("Rs2Applet").getConstructor(new Class[] { });
	}
	
	public Applet getApplet() {
		if(rs3Applet != null) {
			return rs3Applet;
		}
		try {
			Constructor<? extends Applet> appletConstructor = getRS3AppletConstructor();
			this.rs3Applet = appletConstructor.newInstance();
		} catch(Throwable t) {
			t.printStackTrace();
		}
		return rs3Applet;
	}
	
	public RS3WebApplet getWebClient() {
		return webClient;
	}

}
