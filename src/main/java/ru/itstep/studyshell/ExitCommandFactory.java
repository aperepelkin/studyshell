package ru.itstep.studyshell;


public class ExitCommandFactory implements CommandFactory {

	public Command create(String command) {
	
		if(command.startsWith("exit"))
			return new ExitCommand();
		return null;
	}


}
