package ru.itstep.studyshell;

import java.io.File;
import java.util.Scanner;

public class CdDirectoryCommandFactory implements CommandFactory {

	
	Scanner dir = new Scanner(System.in);
	File file = new File("./ " );
	String pole = "pole";
	
	public Command create(String command) {
	
		if(command.equals("cd"))
			return new ListDirectoryCommand(new ShortFilesOutputStrategy());
		if(command.startsWith("cd")) {
			if (command.split(" ")[1].equals("-l")) 
				return new ListDirectoryCommand(new DetailedFilesOutputStrategy());
		}
		return null;
	}

	

}
