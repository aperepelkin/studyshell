package ru.itstep.studyshell;

import java.util.ArrayList;

import cat.CatFactory;
import cd.ChangeDirectoryFactory;
import clear.ClearFactory;
import echo.EchoCommandFactory;
import filter.FilterFactory;
import head.HeadFactory;
import interfaces.CommandFactory;
import mkdir.MakeDirectoryFactory;
import pwd.PrintWorkingDirectoryFactory;
import rm.RemoveFactory;
import tail.TailFactory;

import java.util.*;

public class CommandRepository {

    private static CommandRepository instance;
    private List<CommandFactory> factories = 
	    new ArrayList<CommandFactory>();
    
    private CommandRepository() {
	factories.add(new ListDirectoryCommandFactory());
	factories.add(new EchoCommandFactory());
	factories.add(new ChangeDirectoryFactory());
	factories.add(new PrintWorkingDirectoryFactory());
	factories.add(new RemoveFactory());
	factories.add(new MakeDirectoryFactory());
	factories.add(new ClearFactory());
	factories.add(new TailFactory());
	factories.add(new HeadFactory());
	factories.add(new FilterFactory());
	factories.add(new CatFactory());
	
    }
    
    
    public static CommandRepository getInstance() {
	if (instance == null) {
	    return new CommandRepository();
	} else
	    return instance;
    }

    public Command create(String command) {
	
	for (CommandFactory factory: factories) {
	   
	   Command result = factory.create(command);
	   if (result != null) {
	        return result;
	    }
	   
	}
	
	return null;
    }
    
    
}
