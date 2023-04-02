package com.decorator.pattern.demo;

public class PizzaStore {

	public static void main(String[] args) {
		Pizza pizza=new CheesePizza(new PlainPizza());
		pizza.bake();
	}
}
