package ru.itstep.studyshell;

import java.util.Scanner;

import javax.swing.JFrame;

import directory.Directory;

/**
 * Hello world!
 *
 */

public class App {
    
    static Scanner in = new Scanner(System.in);
    static boolean exit = false;
    
    public static void main( String[] args ) {
	//стр 94
		
	Directory.getInstanse();
	Directory.calibration();
	
	Console window = new Console("Console");
	window.setVisible(true);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setSize(700, 460);
	window.setResizable(true);
	window.setLocationRelativeTo(null);
	

    }
    
}
