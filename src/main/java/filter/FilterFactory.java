package filter;


import commands.Commands;
import interfaces.CommandFactory;
import parsing.Parsing;
import ru.itstep.studyshell.Command;

public class FilterFactory implements CommandFactory{

    @Override
    public Command create(String command) {
	// TODO Auto-generated method stub
	
	
    Parsing parsing = new Parsing(command);
	
	if (parsing.containsCommand(Commands.FILTER)) {
	    String parametr = parsing.getParametr(Commands.FILTER);
	    if (parametr.length() != 0) {
		String [] splitParametr = parametr.split(" "); 
		return new FilterCommand(splitParametr);
	    }
	}  
    return null;
	
    }

}
