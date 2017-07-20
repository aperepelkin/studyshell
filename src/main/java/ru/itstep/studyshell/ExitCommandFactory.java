package ru.itstep.studyshell;

public class ExitCommandFactory implements CommandFactory {

	public Command creat(String command) {
	
		if(command.startsWith("exit"))
			return new ExitCommand();
		return null;
	}
}
