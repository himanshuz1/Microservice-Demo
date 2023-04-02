package com.flyweight.demo;

public class Rectangle implements Shape {

	private String label;

	public Rectangle() {
		label = "RECTANGLE";
	}

	@Override
	public void draw(int length, int breadth) {
		System.out.println(label + " with length= " + length + " " + "breadth= " + breadth);
	}

}
