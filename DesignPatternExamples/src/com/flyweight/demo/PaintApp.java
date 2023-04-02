/**
 * 
 */
package com.flyweight.demo;

/**
 * @author himanshu
 *
 */
public class PaintApp {

	/**
	 * 
	 */
	public PaintApp() {
		System.out.println("inside PaintApp constructor");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			if (i % 2 != 0) {
				ShapeFactory.getShape("circle").draw(i);
			} else {
				ShapeFactory.getShape("rectangle").draw(i, i);
			}

		}

	}

}
