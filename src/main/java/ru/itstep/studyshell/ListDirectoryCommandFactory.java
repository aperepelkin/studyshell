package ru.itstep.studyshell;

public class ListDirectoryCommandFactory implements CommandFactory{

	public Command creat(String command) {
		if(command.equals("ls"))
			return new ListDirectoryCommand();
		return null;
	}

	
}
