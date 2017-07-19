package ru.itstep.studyshell;

public class EchoDirectoryCommand implements Command{

    private String command;
    
    public EchoDirectoryCommand(String command) {
	this.command = command;
    }
    
    public void execute() {
	
	if(this.command.equals("user")) {
	    Console.print(System.getProperty("user.name") + "<br>");
	} else {
	    Console.print(command + "<br");
	}
	
    }

}
