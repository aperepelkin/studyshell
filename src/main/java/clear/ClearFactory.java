package clear;

import commands.Commands;
import interfaces.CommandFactory;
import parsing.Parsing;
import ru.itstep.studyshell.Command;

public class ClearFactory implements CommandFactory{

    @Override
    public Command create(String command) {
	// TODO Auto-generated method stub


	Parsing parsing = new Parsing(command);
	
	
	if (parsing.containsCommand(Commands.CLEAR)) {
	    String parametr = parsing.getParametr(Commands.CLEAR);
	    if (parametr.length() == 0) {
		return new ClearCommand();
	    }
	}  
        return null;
	

	
    }

}
