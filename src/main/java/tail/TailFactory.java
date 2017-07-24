package tail;

import commands.Commands;
import interfaces.CommandFactory;
import parsing.Parsing;
import ru.itstep.studyshell.Command;

public class TailFactory implements CommandFactory{

    @Override
    public Command create(String command) {
	// TODO Auto-generated method stub


	Parsing parsing = new Parsing(command);
	
	if (parsing.containsCommand(Commands.TAIL)) {
	    String parametr = parsing.getParametr(Commands.TAIL);
	    if (parametr != null) {
		String [] splitParametr = parametr.split(" "); 
		return new TailCommand(splitParametr);
	    }
	}  
        return null;
	
    }

}
