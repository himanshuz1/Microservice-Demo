package com.command.pattern.demo;

public class OnCommand implements Command {

	private Television television;

	/**
	 * @param television
	 */
	public OnCommand(Television television) {
		this.television = television;
	}

	@Override
	public void execute() {
		television.switchOff();
	}

	/**
	 * @return the television
	 */
	public Television getTelevision() {
		return television;
	}

	/**
	 * @param television the television to set
	 */
	public void setTelevision(Television television) {
		this.television = television;
	}

}
