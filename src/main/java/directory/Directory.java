package directory;

import java.io.File;

import ru.itstep.studyshell.ListDirectoryCommandFactory;

public class Directory {
    
    private static String currentDirectory = "./";
    private final static String user = System.getProperty("user.name") + ":";
    private static String consoleMessage = user + "~$";
    private static Directory instance;
    
    
    public static String getUser() {
        return user;
    }


    public static String getConsoleMessage() {
        return consoleMessage;
    }


    public static void setConsoleMessage(String consoleMessage) {
        Directory.consoleMessage = consoleMessage;
    }


    public static Directory getInstanse() {
	if (instance == null) {
	    return new Directory();
	}
	return instance;
    }
    

    public static String getCurrentDirectory() {
        return Directory.currentDirectory;
    }


    public static void setCurrentDirectory(String currentDir) {
	Directory.currentDirectory = currentDir;
    }
    
    private Directory() {
	File file = new File(currentDirectory);
	setCurrentDirectory(file.getAbsolutePath());
    }
    
    
    
    
    public static void calibration() {
	// TODO Auto-generated method stub
		File f = new File (currentDirectory);
		currentDirectory = f.getAbsolutePath().substring(0, f.getAbsolutePath().length()-2);
		String[] dirToShow = currentDirectory.split("\\\\");
		consoleMessage = Directory.user + "~/" + dirToShow[dirToShow.length-1] + "$";
    }
    
    
}
