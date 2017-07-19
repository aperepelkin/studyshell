package ru.itstep.studyshell;

import java.io.File;

import interfaces.CommandFactory;

public class ListDirectoryCommandFactory implements CommandFactory{
    
    
    private static String currentDirectory = "./";
    public static final String user = System.getProperty("user.name") + ":";
    public static String consoleMessage = user + "~$";
    
    
    

    public static String getCurrentDirectory() {
        return currentDirectory;
    }


    public static void setCurrentDirectory(String currentDirectory) {
	ListDirectoryCommandFactory.currentDirectory = currentDirectory;
    }
    
    public ListDirectoryCommandFactory() {
	File file = new File(currentDirectory);
	setCurrentDirectory(file.getAbsolutePath());
    }


    public Command create(String command) {
	
	String [] splitCommand = command.split(" ");
	
	switch (splitCommand[0]) {
        	case "ls":
        	    return new ListDirectoryCommand();
        	case "mkdir":
        	    return new MakeDirectoryCommand(createCommand(splitCommand));
        	case "pwd":
        	    return new PrintWorkingDirectoryCommand();
        	case "rm":
        	    return new RemoveCommand(createCommand(splitCommand));
        	case "exit":
        	    App.setExit();
        	case "echo":
        	    return new EchoDirectoryCommand(createCommand(splitCommand));
        	case "cd":
        	    StringBuilder sb = new StringBuilder();
        	    for (int i=1; i<splitCommand.length; i++) {
        		if (i != splitCommand.length - 1) {
        		    sb.append(splitCommand[i]+" ");
        		} else {
        		    sb.append(splitCommand[splitCommand.length-1]);
        		}
        	    }
        	    
        	    if (!sb.toString().isEmpty()) {
        		return new ChangeDirectoryCommand(sb.toString());
        	    } else {
        		return new ChangeDirectoryCommand();
        	    }
	}
	

	
	
	return null;

    }

    private String createCommand(String [] splitCommand) {
	StringBuilder sb = new StringBuilder();
	    for (int i=1; i<splitCommand.length-1; i++) {
		sb.append(splitCommand[i]+" ");
	    }
	    sb.append(splitCommand[splitCommand.length-1]);
	    return sb.toString();
    }
    
    

    public static void calibration() {
	// TODO Auto-generated method stub
		File f = new File (currentDirectory);
		currentDirectory = f.getAbsolutePath().substring(0, f.getAbsolutePath().length()-2);
		String[] dirToShow = currentDirectory.split("\\\\");
		consoleMessage = ListDirectoryCommandFactory.user + "~/" + dirToShow[dirToShow.length-1] + "$";
    }

}
