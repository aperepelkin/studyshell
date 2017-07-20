package ru.itstep.studyshell;

public class EchoCommandFactory implements CommandFactory {

	public Command creat(String command) {
			
		if(command.startsWith("echo"))
			return new EchoCommand(command.split(" ")[1]);
		return null;
	}

}
