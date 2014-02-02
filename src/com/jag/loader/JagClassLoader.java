package com.jag.loader;

import java.awt.Canvas;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;

import com.jag.canvas.RS3Canvas;

public class JagClassLoader extends URLClassLoader {
	private static HashMap<Class<?>, Class<?>> remapper = new HashMap<Class<?>, Class<?>>();

	public JagClassLoader(URL[] urls) {
		super(urls);
		
		remapper.put(Canvas.class, RS3Canvas.class);
	}

	@Override
	public Class<?> loadClass(String className) throws ClassNotFoundException {
		Class<?> clazz = super.loadClass(className);
		return remap(clazz);
	}
	
	public Class<?> remap(Class<?> key) {
		return remapper.containsKey(key) ? remapper.get(key) : key;
	}

}
