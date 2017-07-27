package ru.itstep.studyshell;


public class EchoCommandFactory implements CommandFactory {

	public Command create(String command) {
			
		if(command.startsWith("echo"))
			return new EchoCommand(command.split(" ")[1]);
		if (command.split(" ")[1].equals("aaa")) {
			System.out.println("AAA");
		}
		return null;
	}


	
}
