package echo;

import commands.Commands;
import interfaces.CommandFactory;
import parsing.Parsing;
import ru.itstep.studyshell.Command;

public class EchoCommandFactory implements CommandFactory{

    
public Command create(String command) {
	
    
    Parsing parsing = new Parsing(command);
    
    
    if (parsing.containsCommand(Commands.ECHO)) {
	    String parametr = parsing.getParametr(Commands.ECHO);
	    if (parametr.length() != 0) {
		String [] splitParametr = parametr.split(" "); 
		return new EchoDirectoryCommand(splitParametr);
	    }
	}  
    return null;
    
    
    
}
    
    
    
}
