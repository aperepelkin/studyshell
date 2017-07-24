package mkdir;

import java.io.File;

import directory.Directory;
import ru.itstep.studyshell.Command;
import ru.itstep.studyshell.Console;

public class MakeDirectoryCommand implements Command{

    private String[] folderName;
    
    
    
    public MakeDirectoryCommand(String[] folderName) {
	this.folderName = folderName;
    }
    
    public MakeDirectoryCommand(String folderName) {
	this.folderName = new String[1];
	this.folderName[0] = folderName;
    } 



    public void execute() {
	
	if (folderName[0].equals("-p")) {
	    String [] dir = folderName[1].split("/");
	    for (int i=0; i<dir.length; i++){
		new MakeDirectoryCommand(dir[i]).execute();
		Directory.getInstanse();
		Directory.setCurrentDirectory(Directory.getCurrentDirectory() + "\\\\" + dir[i]);
	    }
	    Directory.setConsoleMessage(Directory.getUser() + "~/" + dir[dir.length-1] + "$");
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for (int i=2; i< dir.length; i++)
		sb.append(dir[i]);
	    
	    Console.print("Create tree " + sb.toString(), "black", true);
	} else {
	    for (int i=0; i< folderName.length; i++) {
		    File folder = new File(Directory.getCurrentDirectory() + "\\\\" + folderName[i].replace("/", "\\\\"));
		        if (!folder.exists()) {
		             folder.mkdir();
		        }
	    }
	    
            StringBuilder sb = new StringBuilder();
	    
	    for (int i=0; i< folderName.length; i++)
		sb.append(folderName[i]);
	    Console.print("Create folder(s) " + sb.toString(), "black", true);
	}
	
	
	
	
    }

}
