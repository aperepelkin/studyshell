package pwd;

import directory.Directory;
import ru.itstep.studyshell.Command;
import ru.itstep.studyshell.Console;

public class PrintWorkingDirectoryCommand implements Command{
  
    public void execute() {
	
	Directory.getInstanse();
         Console.print(Directory.getCurrentDirectory(), "black", true);
    }

}
