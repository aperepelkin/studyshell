package ru.itstep.studyshell;

import java.io.File;

public class ChangeDirectoryCommand implements Command{
    
    private String dir = new String();
    
    public ChangeDirectoryCommand(String directory) {
	this.dir = directory;
    }
    
    public ChangeDirectoryCommand() {
    }

    public void execute() {
	// TODO Auto-generated method stub
	
	File folder; 
	
	if (this.dir.isEmpty()){
	    String[] tempSplit = ListDirectoryCommandFactory.getCurrentDirectory().split("\\\\");
	    if (tempSplit[tempSplit.length-1].indexOf(":") == -1) {
		StringBuilder sb = new StringBuilder();
		    for (int i=0; i<tempSplit.length-1; i++) {
			sb.append(tempSplit[i] + "\\\\");
		    }
		    ListDirectoryCommandFactory.setCurrentDirectory(sb.toString());
	    }
	} else {
	    if (this.dir.indexOf("/") == 0) {
		if (this.dir.length() != 1) {
		    this.dir.replace("/", "\\\\");
		    this.dir = ListDirectoryCommandFactory.getCurrentDirectory()+this.dir;
		} else {
		    this.dir = ListDirectoryCommandFactory.getCurrentDirectory().substring(0, 3);
		}
	    }
	    
		folder = new File(this.dir);
		if (folder.exists()) {
		    ListDirectoryCommandFactory.setCurrentDirectory(this.dir);
		} else {
		    Console.print("There is no such directory");
		}
	    
	}
	
	folder = new File(ListDirectoryCommandFactory.getCurrentDirectory());
	String[] dirToShow = folder.getAbsolutePath().split("\\\\");
	
	
	if (dirToShow[dirToShow.length-1].indexOf(":") == -1) {
	    ListDirectoryCommandFactory.consoleMessage = ListDirectoryCommandFactory.user + "~/" + dirToShow[dirToShow.length-1] + "$";
	} else {
	    ListDirectoryCommandFactory.consoleMessage = ListDirectoryCommandFactory.user + "~$";
	}
    }

}
