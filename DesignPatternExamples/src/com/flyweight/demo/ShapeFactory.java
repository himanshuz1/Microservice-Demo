package com.flyweight.demo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ShapeFactory {

	private ShapeFactory() {

	}

	private static final Map<String, Shape> cache = new ConcurrentHashMap<>();

	public static Shape getShape(String type) {
		Shape shape = null;
		if (cache.get(type) != null) {
			shape = cache.get(type);
		} else {
			if ("circle".equalsIgnoreCase(type)) {
				shape = new Circle();
			} else if ("rectangle".equalsIgnoreCase(type)) {
				shape = new Rectangle();
			}
			cache.put(type, shape);
		}
		return shape;
	}

}
