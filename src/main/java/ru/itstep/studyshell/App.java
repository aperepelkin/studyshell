package ru.itstep.studyshell;

import java.util.Scanner;

public class App {
	
	private static App instance;
	
	private String currentDirectory;
	
	private App() {}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		Command command = CommandRepository.getInstance().create(line);
		if (command != null)
			command.execute();
		System.out.println("\b");
		line = scanner.nextLine();
	}
	
	public static App getInstance() {
		if(instance == null)
			instance = new App();
		return instance;
	}

	public String getCurrentDirectory() {
		return currentDirectory;
	}

	public void setCurrentDirectory(String currentDirectory) {
		this.currentDirectory = currentDirectory;
	}
}
