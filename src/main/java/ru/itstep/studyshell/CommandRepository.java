package ru.itstep.studyshell;

import java.util.ArrayList;
import java.util.List;

public class CommandRepository {
	
	
	private static CommandRepository instance;
	List<CommandFactory> factories = new ArrayList<CommandFactory>();
	
	
	
	private CommandRepository () {
		factories.add(new ListDirectoryCommandFactory());
		factories.add(new EchoCommandFactory());
	}

	public static CommandRepository getInstance() {
		
		if(instance == null)
			instance = new CommandRepository();
		
		return instance;
	
		
	}
	public Command create (String command) {
		
		for(CommandFactory factory: factories) {
			Command result = factory.creat(command);
			if(result != null)
				return result;
			
		}
		return null;
	}
	
}
