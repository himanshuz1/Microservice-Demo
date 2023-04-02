/**
 * 
 */
package com.decorator.pattern.demo;

/**
 * @author himanshu
 *
 */
public class PizzaDecorator implements Pizza {

	private Pizza pizza;

	/**
	 * @param pizza
	 */
	public PizzaDecorator(Pizza pizza) {
		this.pizza = pizza;
	}

	/**
	 * @return the pizza
	 */
	public Pizza getPizza() {
		return pizza;
	}

	/**
	 * @param pizza the pizza to set
	 */
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public void bake() {
		pizza.bake();
	}

}
