package echo;

import ru.itstep.studyshell.Command;
import ru.itstep.studyshell.Console;

public class EchoDirectoryCommand implements Command{

    private String[] parametr;
    
    public EchoDirectoryCommand(String[] parametr) {
	this.parametr = parametr;
    }
    
    public void execute() {
	
	if (this.parametr.length >= 1) {
	    if (this.parametr[0].equals("user")) {
		Console.print(System.getProperty("user.name"), "black", true);
	    } else {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<this.parametr.length; i++) {
		    sb.append(this.parametr[i] + " ");
		}
		Console.print(sb.toString(), "black", true);
	    }
	}
	
    }

}
