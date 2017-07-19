package ru.itstep.studyshell;

public class EchoDirectoryCommand implements Command{

    private String command;
    
    public EchoDirectoryCommand(String command) {
	this.command = command;
    }
    
    public void execute() {
	
	if(this.command.equals("user")) {
	    System.out.println(System.getProperty("user.name"));
	} else {
	    System.out.println(command);
	}
	
    }

}
