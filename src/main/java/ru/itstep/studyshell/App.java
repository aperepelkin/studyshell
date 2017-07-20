package ru.itstep.studyshell;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
    	
    	 while (true) {
    	Scanner sc = new Scanner(System.in);	
    	String line = sc.nextLine();
    	Command command = CommandRepository.getInstance().create(line);
     
    	if(command != null)
    		command.execute();
    	else System.out.println("command not found");
    	 }
    }
}
