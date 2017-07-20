package ru.itstep.studyshell;

import java.io.File;
import java.util.Arrays;


public class ListDirectoryCommand implements Command{

	public void execute() {
		
		File file = new File("./");
		File [] listOfFiles = file.listFiles();
		System.out.println(Arrays.toString(listOfFiles));
		
		
	}
}