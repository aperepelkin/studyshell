package ru.itstep.studyshell;


public class EchoCommandFactory implements CommandFactory {

	public Command create(String option) {
			
		if(option.startsWith("echo"))
			return new EchoCommand(option.split(" ")[1]);
		
		
		return null;
	}


	
}
