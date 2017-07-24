package cd;

import java.io.File;

import directory.Directory;
import ru.itstep.studyshell.Command;
import ru.itstep.studyshell.Console;

public class ChangeDirectoryCommand implements Command{
    
    private String[] dir;
    
    public ChangeDirectoryCommand(String[] directory) {
	this.dir = directory;
    }
    
    public ChangeDirectoryCommand() {
    }

    public void execute() {
	// TODO Auto-generated method stub
	
	File folder; 
	if (this.dir == null){
	    Directory.getInstanse();
	    String[] tempSplit = Directory.getCurrentDirectory().split("\\\\");
	    if (tempSplit[tempSplit.length-1].indexOf(":") == -1) {
		StringBuilder sb = new StringBuilder();
		    for (int i=0; i<tempSplit.length-1; i++) {
			sb.append(tempSplit[i] + "\\\\");
		    }
		    Directory.setCurrentDirectory(sb.toString());
	    }
	} else {
	    
	    if (this.dir.length == 1) {
		
		if (this.dir[0].indexOf("/") == 0) {
			    this.dir[0].replace("/", "\\\\");
			    this.dir[0] = Directory.getCurrentDirectory()+this.dir[0];
			} else {
			    this.dir[0] = Directory.getCurrentDirectory().substring(0, 3);
			}
		    }
	    
	    
	    
		folder = new File(this.dir[0]);
		if (folder.exists()) {
		    Directory.setCurrentDirectory(this.dir[0]);
		} else {
		    Console.print("There is no such directory", "red", true);
		}
	    
	}
	
	folder = new File(Directory.getCurrentDirectory());
	String[] dirToShow = folder.getAbsolutePath().split("\\\\");
	
	
	if (dirToShow[dirToShow.length-1].indexOf(":") == -1) {
	    Directory.setConsoleMessage(Directory.getUser() + "~/" + dirToShow[dirToShow.length-1] + "$");
	} else {
	    Directory.setConsoleMessage(Directory.getUser() + "~$");
	}
	
    }

}
