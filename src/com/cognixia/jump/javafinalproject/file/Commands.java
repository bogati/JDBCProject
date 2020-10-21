package com.cognixia.jump.javafinalproject.file;

public enum Commands {
	ADD("add"), 
	UPDATE("update"), 
	REMOVE("remove"), 
	LIST("list"), 
	EXIT("exit"),
	HELP("help"),
	BACK("back");

	private String command;
	
	Commands(String command) {
		this.command = command;
	}
}
