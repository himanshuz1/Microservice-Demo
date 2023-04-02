/**
 * 
 */
package com.flyweight.demo;

/**
 * @author himanshu
 *
 */
public class Circle implements Shape {

	private String label;

	/**
	 * 
	 */
	public Circle() {
		label = "CIRCLE";
	}

	@Override
	public void draw(int radius) {	
		System.out.println(label+" with "+radius);
	}

	

}
