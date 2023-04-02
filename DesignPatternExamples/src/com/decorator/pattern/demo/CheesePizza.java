/**
 * 
 */
package com.decorator.pattern.demo;

/**
 * @author himanshu
 *
 */
public class CheesePizza extends PizzaDecorator {

	public CheesePizza(Pizza pizza) {
		super(pizza);
	}

	@Override
	public void bake() {
		super.bake();
		System.out.println("adding cheese to pizza");
	}

}
