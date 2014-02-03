package com.jag.loader;

import java.awt.Canvas;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;

import com.jag.canvas.RS3Canvas;

public class JagAppletClassLoader extends URLClassLoader {
	private static HashMap<Class<?>, Class<?>> remapper = new HashMap<Class<?>, Class<?>>();

	public JagAppletClassLoader(URL[] urls) {
		super(urls);
		
		remapper.put(Canvas.class, RS3Canvas.class);
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
	
	public Class<?> remap(Class<?> key) {
		return remapper.containsKey(key) ? remapper.get(key) : key;
	}

}
