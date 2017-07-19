package ru.itstep.studyshell;

import java.util.Scanner;

/**
 * Hello world!
 *
 */

public class App {
    
    static Scanner in = new Scanner(System.in);
    private static boolean exit = false;
    
    public static void main( String[] args ) {
	//стр 94
	
	ListDirectoryCommandFactory.calibration();
	
	while (!exit) {
	    System.out.print(ListDirectoryCommandFactory.consoleMessage);
	    String line = in.nextLine();
	    Command command = CommandRepository.getInstance().create(line);
	    if (command != null) {
	        command.execute();
	    }
	}
    }
    
    
    public static void setExit() {
	exit = true;
    }
    
}
