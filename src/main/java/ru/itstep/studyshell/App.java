package ru.itstep.studyshell;

import java.util.Scanner;


public class App {
	
	static App instance;
	private static boolean exit = false ;
	private String directory = "./";

    public static void main( String[] args ) {
    	
    	 while (!exit) {
    	Scanner sc = new Scanner(System.in);	
    	String line = sc.nextLine();
    	Command command = CommandRepository.getInstance().create(line);
     
    	if(command != null)
    		command.execute();
    	else System.out.println("command not found");
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
    
	public String getDirectory() {
		
		return directory;
	}
	public void setDirectory(String directory) {
		
		this.directory = directory;
	}
}
