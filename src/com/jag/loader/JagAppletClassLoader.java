package com.jag.loader;

import java.net.URL;
import java.net.URLClassLoader;

public class JagAppletClassLoader extends URLClassLoader {

	public JagAppletClassLoader(URL[] urls) {
		super(urls);
	}

	@Override
	public Class<?> loadClass(String className) throws ClassNotFoundException {
		return findClass(className);
	}
	
	@Override
	public Class<?> findClass(String className) throws ClassNotFoundException {
		try {
			return super.getSystemClassLoader().loadClass(className);
		} catch (Exception e) {
			
		}
		return super.findClass(className);
	}

}
