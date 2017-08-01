package ru.itstep.studyshell;

import java.util.Date;

public class DateCommandFactory implements CommandFactory {

	public Command create(String command) {
		if(command.equals("date"))
			return new DateCommand(String.format("%tr", new Date()));
		if(command.startsWith("date")) {
			if (command.split(" ")[1].equals("-fd")) 
				return new DateCommand(String.format("%tr", new Date()));
		}
		return null;
	}

}
