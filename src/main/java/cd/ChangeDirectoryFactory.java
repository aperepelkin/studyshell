package cd;

import commands.Commands;
import interfaces.CommandFactory;
import parsing.Parsing;
import ru.itstep.studyshell.Command;

public class ChangeDirectoryFactory implements CommandFactory{

    @Override
    public Command create(String command) {
	// TODO Auto-generated method stub
	
	
	
    Parsing parsing = new Parsing(command);
	
	if (parsing.containsCommand(Commands.CD)) {
	    String parametr = parsing.getParametr(Commands.CD);
	    if (parametr.length() != 0) {
		String [] splitParametr = parametr.split(" "); 
		return new ChangeDirectoryCommand(splitParametr);
	    } else 
		return new ChangeDirectoryCommand();
	}  
    return null;
	

    }

}
