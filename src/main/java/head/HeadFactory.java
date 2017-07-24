package head;

import commands.Commands;
import interfaces.CommandFactory;
import parsing.Parsing;
import ru.itstep.studyshell.Command;

public class HeadFactory implements CommandFactory{

    @Override
    public Command create(String command) {
	// TODO Auto-generated method stub
	
	
	Parsing parsing = new Parsing(command);
	
	
	if (parsing.containsCommand(Commands.HEAD)) {
	    String parametr = parsing.getParametr(Commands.HEAD);
	    if (parametr.length() != 0) {
		String [] splitParametr = parametr.split(" "); 
		return new HeadCommand(splitParametr);
	    }
	}  
        return null;
	
	

    }

}
