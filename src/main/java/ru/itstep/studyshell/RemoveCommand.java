package ru.itstep.studyshell;

import java.io.File;

public class RemoveCommand implements Command{

    private String command;
    
    /**
     * @param command
     */
    public RemoveCommand(String command) {
	this.command = command;
    }

    @Override
    public void execute() {
	
	String [] commandSplit = command.split(" ");
	
	if (commandSplit.length > 1) {
	    switch (commandSplit[0]) {
	        case "-f":  //удалить файл
		    File file = new File(ListDirectoryCommandFactory.getCurrentDirectory() + "\\\\" + commandSplit[1]);
		    file.delete();
		    Console.print("File delete<br>");
		break;
	        case "-rf": //удаление папок
	            for (int i=1; i< commandSplit.length; i++) {
	        	deleteFolder(new File(ListDirectoryCommandFactory.getCurrentDirectory() + "\\\\" + commandSplit[i]));
	            }
	            Console.print("Folder delete<br>");
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
