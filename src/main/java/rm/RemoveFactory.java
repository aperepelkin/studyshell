package rm;

import commands.Commands;
import interfaces.CommandFactory;
import parsing.Parsing;
import ru.itstep.studyshell.Command;

public class RemoveFactory implements CommandFactory{

    @Override
    public Command create(String command) {
	// TODO Auto-generated method stub
	
	Parsing parsing = new Parsing(command);
	
	if (parsing.containsCommand(Commands.RM)) {
	    String parametr = parsing.getParametr(Commands.RM);
	    if (parametr.length() != 0) {
		String [] splitParametr = parametr.split(" "); 
		return new RemoveCommand(splitParametr);
	    }
	}  
        return null;
    }

}
