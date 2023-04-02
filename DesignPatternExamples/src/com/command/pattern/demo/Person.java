package com.command.pattern.demo;

public class Person {

	public static void main(String[] args) {
		Television television = new Television();
		Command onCommand = new OnCommand(television);
		RemoteController remoteController = new RemoteController();
		remoteController.setCommand(onCommand);
		remoteController.pressButton();
	}

}
