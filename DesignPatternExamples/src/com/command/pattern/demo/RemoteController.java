package com.command.pattern.demo;

public class RemoteController {

	private Command command;

	public void pressButton() {
		command.execute();
	}

	/**
	 * @return the command
	 */
	public Command getCommand() {
		return command;
	}

	/**
	 * @param command the command to set
	 */
	public void setCommand(Command command) {
		this.command = command;
	}

}
