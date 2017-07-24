package pwd;

import commands.Commands;
import interfaces.CommandFactory;
import parsing.Parsing;
import ru.itstep.studyshell.Command;

public class PrintWorkingDirectoryFactory implements CommandFactory{

    @Override
    public Command create(String command) {
	// TODO Auto-generated method stub
	
	Parsing parsing = new Parsing(command);
	
	
	if (parsing.containsCommand(Commands.PWD)) {
	    System.out.println("1" + parsing.getParametr(Commands.PWD) + "1");
	    if (parsing.getParametr(Commands.PWD).length() == 0) {
		return new PrintWorkingDirectoryCommand();
	    }
	}  
        return null;
	
	
    }

}
