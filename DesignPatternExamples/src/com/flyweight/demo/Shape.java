/**
 * 
 */
package com.flyweight.demo;

/**
 * @author himanshu
 *
 */
public interface Shape {

	public default void draw(int length, int breadth) {
		System.out.println("default implementations");
	}
	
	
	public default void draw(int radius) {
		System.out.println("default implementations");
	}
	
}
