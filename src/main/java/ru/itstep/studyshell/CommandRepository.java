package ru.itstep.studyshell;

import java.util.ArrayList;
import interfaces.CommandFactory;
import java.util.*;

public class CommandRepository {

    private static CommandRepository instance;
    private List<CommandFactory> factories = 
	    new ArrayList<CommandFactory>();
    
    private CommandRepository() {
	factories.add(new ListDirectoryCommandFactory());
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
