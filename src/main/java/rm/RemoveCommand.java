package rm;

import java.io.File;

import directory.Directory;
import ru.itstep.studyshell.Command;
import ru.itstep.studyshell.Console;

public class RemoveCommand implements Command{

    private String[] command;
    
    /**
     * @param command
     */
    public RemoveCommand(String[] command) {
	this.command = command;
    }

    @Override
    public void execute() {
	
	if (command.length > 1) {
	    switch (command[0]) {
	        case "-f":  //удалить файл
	            Directory.getInstanse();
		    File file = new File(Directory.getCurrentDirectory() + "\\\\" + command[1]);
		    file.delete();
		    Console.print("File delete", "black", true);
		break;
	        case "-rf": //удаление папок
	            for (int i=1; i< command.length; i++) {
	        	Directory.getInstanse();
	        	deleteFolder(new File(Directory.getCurrentDirectory() + "\\\\" + command[i]));
	            }
	            Console.print("Folder delete", "black", true);
	        break;
	    }
	}
	
    }
    
    
    
    
    public void deleteFolder(File file){
      if(!file.exists())
        return;
      if(file.isDirectory()) {
        for(File f : file.listFiles())
            deleteFolder(f);
        file.delete();
      } else {
        file.delete();
      }
    }

}
