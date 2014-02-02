package com.jag.reflect.utils;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

public class ReflectUtils extends Modifier {
	private static final Set<Class<?>> WRAPPER_TYPES;

	static {
		WRAPPER_TYPES = new HashSet<Class<?>>();
		WRAPPER_TYPES.add(Boolean.class);
		WRAPPER_TYPES.add(Character.class);
		WRAPPER_TYPES.add(Byte.class);
		WRAPPER_TYPES.add(Short.class);
		WRAPPER_TYPES.add(Integer.class);
		WRAPPER_TYPES.add(Long.class);
		WRAPPER_TYPES.add(Float.class);
		WRAPPER_TYPES.add(Double.class);
		WRAPPER_TYPES.add(Void.class);
	}
	
	public static Set<Class<?>> getWrapperTypes() {
		return WRAPPER_TYPES;
	}

	public static boolean isWrapperType(Class<?> clazz) {
		return WRAPPER_TYPES.contains(clazz);
	}
	
	public static boolean isWrapperType(Object object) {
		return isWrapperType(object.getClass());
	}

	public static boolean instanceOf(Object instance, Class<?> clazz) {
		return clazz.isInstance(instance);
	}

	public static void makeAccessible(Field field) {
		if (!field.isAccessible()) {
			field.setAccessible(true);
		}
	}

	public static void makeAccessible(Method method) {
		if (!method.isAccessible()) {
			method.setAccessible(true);
		}
	}

	public static void makeAccessible(Constructor<?> constructor) {
		if (!constructor.isAccessible()) {
			constructor.setAccessible(true);
		}
	}
	
	public static boolean isArray(Class<?> clazz) {
		return clazz.isArray();
	}

	public static boolean isArray(Object object) {
		return isArray(object.getClass());
	}

	public static int getArrayLength(Object object) {
		if (!isArray(object)) {
			return -1;
		}
		return Array.getLength(object);
	}

}
