package ru.itstep.studyshell;

import java.io.File;
import java.util.Scanner;


public class App {
	
	static App instance;
	private static boolean exit = false ;
	private File directory = new File ("./");

    public static void main( String[] args ) {
    	
    	 while (!exit) {
    	Scanner sc = new Scanner(System.in);	
    	String line = sc.nextLine();
    	Command command = CommandRepository.getInstance().create(line);
     
    	if(command != null)
    		command.execute();
    	System.out.println(App.getInstance().getDirectory().getAbsolutePath());
    	 }
    }
    public static App getInstance() {
    	
    	if(instance == null)
			instance = new App();
		
		return instance;
   	
    }
    public void exit () {
    	exit = true;
    }
    
	public File getDirectory() {
		
		return directory;
	}
	public void setDirectory(File directory) {
		
		this.directory = directory;
	}
}
