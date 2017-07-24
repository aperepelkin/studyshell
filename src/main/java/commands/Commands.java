package commands;


    public enum Commands {
	LS, CD, MKDIR, RM, ECHO, TAIL, CLEAR, PWD, HEAD, FILTER, CAT;
	
	public static String getName(Commands command) {
	    for (Commands coms: Commands.values()) {
		if (command == coms){
		    return command.name().toLowerCase();
		}   
	    }
	    return null;
	}
	
	public static String getCommand(String part){
	    for (Commands coms: Commands.values()) {
		if (coms.name().startsWith(part) || coms.name().toLowerCase().startsWith(part)){
		    return coms.name().toLowerCase();
		}   
	    }
	    return null;
	}
    }

    


