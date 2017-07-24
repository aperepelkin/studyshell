package cat;

import commands.Commands;
import interfaces.CommandFactory;
import parsing.Parsing;
import ru.itstep.studyshell.Command;

public class CatFactory implements CommandFactory{

    @Override
    public Command create(String command) {
	// TODO Auto-generated method stub
	
	Parsing parsing = new Parsing(command);
	
	if (parsing.containsCommand(Commands.CAT)) {
	    String parametr = parsing.getParametr(Commands.CAT);
	    if (parametr.length() != 0) {
		String [] splitParametr = parametr.split(" "); 
		return new CatCommand(splitParametr);
	    }
	}  
    return null;
    }

    
    
    
}
