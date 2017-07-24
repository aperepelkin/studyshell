package mkdir;

import commands.Commands;
import interfaces.CommandFactory;
import parsing.Parsing;
import ru.itstep.studyshell.Command;

public class MakeDirectoryFactory implements CommandFactory{

    @Override
    public Command create(String command) {
	// TODO Auto-generated method stub
	
	Parsing parsing = new Parsing(command);
	
	
	if (parsing.containsCommand(Commands.MKDIR)) {
	    String parametr = parsing.getParametr(Commands.MKDIR);
	    if (parametr.length() != 0) {
		String [] splitParametr = parametr.split(" "); 
		return new MakeDirectoryCommand(splitParametr);
	    }
	}  
        return null;
	
    }

}
