package ru.itstep.studyshell;

import java.io.File;

public class MakeDirectoryCommand implements Command{

    private String folderName;
    
    
    
    public MakeDirectoryCommand(String folderName) {
	this.folderName = folderName;
    }



    public void execute() {
	
	String [] splitDir = folderName.split(" ");
	
	if (splitDir[0].equals("-p")) {
	    String [] dir = splitDir[1].split("/");
	    for (int i=0; i<dir.length; i++){
		new MakeDirectoryCommand(dir[i]).execute();
		ListDirectoryCommandFactory.setCurrentDirectory(ListDirectoryCommandFactory.getCurrentDirectory() + "\\\\" + dir[i]);
	    }
	    ListDirectoryCommandFactory.consoleMessage = ListDirectoryCommandFactory.user + "~/" + dir[dir.length-1] + "$";
	    
	    StringBuilder sb = new StringBuilder();
	    
	    for (int i=2; i< dir.length; i++)
		sb.append(dir[i]);
	    
	    Console.print("Create tree " + sb.toString() + "<br>");
	} else {
	    for (int i=0; i< splitDir.length; i++) {
		    File folder = new File(ListDirectoryCommandFactory.getCurrentDirectory() + "\\\\" + splitDir[i]);
		        if (!folder.exists()) {
		             folder.mkdir();
		        }
	    }
	    
            StringBuilder sb = new StringBuilder();
	    
	    for (int i=0; i< splitDir.length; i++)
		sb.append(splitDir[i]);
	    Console.print("Create folder(s) " + sb.toString() + "<br>");
	}
	
	
	
	
    }

}
