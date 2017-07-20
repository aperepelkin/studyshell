package ru.itstep.studyshell;

import java.util.Scanner;

public class EchoCommand implements Command{

	String field;
	
	public void execute() {
	
		System.out.println(field);
		
	}
		EchoCommand( String field) {
		
		this.field = field;
		
	}

}
