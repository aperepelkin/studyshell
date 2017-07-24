package parsing;

import java.util.ArrayList;
import commands.Commands;

public class Parsing {

    private ArrayList<String> command = new ArrayList<String>();
    private ArrayList<String> parametr = new ArrayList<String>();
    private int currentIndex;
    
    public int getCurrentIndex() {
        return currentIndex;
    }


    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }


    public Parsing(String fullCommand) {
	
	
	
	if (fullCommand.contains("|") && fullCommand.indexOf("|") != 0){
	    
	    String [] splitFullCommand = fullCommand.split(" ");
	    StringBuilder sb = new StringBuilder();
	    
	    for (String str: splitFullCommand) {
		if (str.equals(Commands.getCommand(str))) {
			command.add(str);
		    } else {
			sb.append(str + " ");
		    }
	    }
	    parametr.add(sb.toString()); 
	} else {
	    StringBuilder sb = new StringBuilder();
	    String [] splitFullCommand = fullCommand.split(" ");
	    for (String str: splitFullCommand){
		if (str.equals(Commands.getCommand(str))) {
		    command.add(str);
		} else {
		    sb.append(str + " ");
		}
	    }
	    parametr.add(sb.toString());
	}
	
	
    }
    

    
    public String getParametr(Commands commands) {
	int index = -1;
	for (String str: this.command) {
	    index++;
	    if (str.equals(Commands.getCommand(str))) {
		setCurrentIndex(index);
		return this.parametr.get(index);
	    }	
	}
	return null;
    }
    
    
    
    public boolean containsCommand(Commands commands) {
	for (String str: this.command) {
	    if (str.equals(Commands.getCommand(commands.name())))
		return true;
	}
	return false;
    }
    
    
    

    public ArrayList<String> getCommand() {
        return command;
    }



    public void setCommand(ArrayList<String> command) {
        this.command = command;
    }

    public ArrayList<String> getParametr() {
        return parametr;
    }

    public void setParametr(ArrayList<String> parametr) {
        this.parametr = parametr;
    }


    
    
    
}
