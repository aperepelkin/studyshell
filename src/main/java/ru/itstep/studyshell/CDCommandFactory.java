package ru.itstep.studyshell;

public class CDCommandFactory implements CommandFactory {

	public Command creat(String command) {
		
		if(command.startsWith("cd"))
		
			return new CDCommand(command.split(" ")[1]);
		return null;
	}

}
