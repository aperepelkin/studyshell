package ru.itstep.studyshell;

import java.io.File;

import cd.ChangeDirectoryCommand;
import commands.Commands;
import echo.EchoDirectoryCommand;
import head.HeadCommand;
import interfaces.CommandFactory;
import mkdir.MakeDirectoryCommand;
import parsing.Parsing;
import pwd.PrintWorkingDirectoryCommand;
import rm.RemoveCommand;

public class ListDirectoryCommandFactory implements CommandFactory{
    
    
    


    public Command create(String command) {
	
	
        Parsing parsing = new Parsing(command);
	
	
	if (parsing.containsCommand(Commands.LS)) {
	    String parametr = parsing.getParametr(Commands.LS);
	    if (parametr.length() != 0) {
		String [] splitParametr = parametr.split(" "); 
		for (String str: splitParametr) {
		    if (str.equals("-l")) {
			return new ListDirectoryCommand(new DetailFilesOutputStrategy());
		    }
		}
	    } else {
		return new ListDirectoryCommand(new ShortFilesOutputStrategy());
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
    
    

    

}
